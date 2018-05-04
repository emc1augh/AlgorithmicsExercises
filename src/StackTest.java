
public class StackTest {
    public static void main(String[] args) {
        Stack myStack = new StackArray(25);

        // Add some elements to the stack
        for (int i=0; i < 26; i++) {
            try {
                myStack.push(new Integer(10*i));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Take out elements in turn and print them.
        while (!myStack.empty()) {
            try {
                System.out.println(myStack.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
