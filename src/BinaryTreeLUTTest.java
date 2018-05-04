public class BinaryTreeLUTTest {
    public static void main(String[] args) {
        try {
            LUT<Integer> myLUT = new BinaryTreeLUT<Integer>();

            myLUT.insert("Priscilla", 41);
            myLUT.insert("Travis", 34);
            myLUT.insert("Samuel", 28);
            myLUT.insert("Helena", 39);
            myLUT.insert("Andrew", 14);
            myLUT.insert("Kay", 24);
            myLUT.insert("John", 67);


            System.out.println(myLUT);
            System.out.println(myLUT.retrieve("John"));

            myLUT.update("Samuel", 29);
            myLUT.remove("Andrew");

            System.out.println(myLUT);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
