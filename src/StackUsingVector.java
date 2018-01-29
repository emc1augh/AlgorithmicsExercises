import java.util.*;

public class StackUsingVector {

    private Vector myVector;

    private StackUsingVector(){
        myVector = new Vector();
    }

    private void push(Object obj){
        myVector.add(obj);
    }

    private Object pop() throws Exception{
        Object obj = null;
        if(myVector.size()>0){
            obj = myVector.elementAt(myVector.size()-1);
            myVector.removeElementAt(myVector.size()-1);
        } else {
            throw new Exception("Stack Underflow");
        }
        return obj;
    }

    private Object peek(){
        Object obj = null;
        if(myVector.size()>0){
            obj = myVector.elementAt(myVector.size()-1);
        }
        return obj;
    }

    public static void main(String args []) throws Exception {
        StackUsingVector stack= new StackUsingVector();

        stack.push(new String("One"));
        System.out.println("Added: "+stack.peek());
        stack.push(new String("Two"));
        System.out.println("Added: "+stack.peek());
        stack.push(new String("Three"));
        System.out.println("Added: "+stack.peek());

        System.out.println();
        System.out.println("The top of stack now is... "+stack.peek());
        stack.pop();
        System.out.println("We have just popped the stack");
        System.out.println("The top of stack now is... "+stack.peek());
        stack.pop();
        System.out.println("We have just popped the stack");
        System.out.println("The top of stack now is... "+stack.peek());
        stack.pop();
        System.out.println("We have just popped the stack");
        System.out.println("The top of stack now is... "+stack.peek());
    }
}