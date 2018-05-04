public class HashTableLProbeTest {
    public static void main(String[] args) {
        try {
            LUT<Integer> myLUT = new HashTableLProbe<Integer>(10);

            myLUT.insert("Priscilla", new Integer(41));
            System.out.println(myLUT);
            myLUT.insert("Travis", new Integer(34));
            System.out.println(myLUT);
            myLUT.insert("Samuel", new Integer(28));
            System.out.println(myLUT);
            myLUT.insert("Helena", new Integer(39));
            System.out.println(myLUT);
            myLUT.insert("Andrew", new Integer(14));
            System.out.println(myLUT);
            myLUT.insert("Kay", new Integer(24));
            System.out.println(myLUT);
            myLUT.insert("John", new Integer(67));
            System.out.println(myLUT);

            myLUT.remove("Travis");
            System.out.println(myLUT);
            myLUT.remove("John");
            System.out.println(myLUT);
            myLUT.remove("Kay");
            System.out.println(myLUT);
            myLUT.insert("Dani", new Integer(15));
            System.out.println(myLUT);
            myLUT.insert("John", new Integer(67));
            System.out.println(myLUT);
            myLUT.insert("Travis", new Integer(34));
            System.out.println(myLUT);

        } catch (LUTKeyException e) {
            throw new AssertionError("This should not happen." + e);
        }
    }
}
