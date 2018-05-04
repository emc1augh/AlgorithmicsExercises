package ExerciseCode1;

import org.junit.Test;

public class StackArrayTest {

    @Test
    public void testPushOkay() {
        StackGeneric<Integer> myStack = new StackArrayGeneric<Integer>(25);
        // Add some elements to the stack
        for (int i = 0; i < 25; i++) {
            try {
                myStack.push(new Integer(10 * i));
            } catch (StackException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(expected = StackException.class)
    public void testPushFailure()
    throws StackException {
        StackGeneric<Integer> myStack = new StackArrayGeneric<Integer>(25);
        // Add some elements to the stack
        for (int i = 0; i < 26; i++) {
            try {
                myStack.push(new Integer(10 * i));
            } catch (StackException e) {
                throw new StackException(e.getMessage());
            }
        }
    }
}
