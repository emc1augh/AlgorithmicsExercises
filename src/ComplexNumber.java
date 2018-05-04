/**
 * Complex number class.
 *
 * Class representing complex values allowing simple numerical
 * operations to be performed.
 */

public class ComplexNumber {

    // Private data items - the data structure, which constitutes
    // the internal representation of the data type.

    private double real = 0;
    private double imaginary = 0;

    /**
     * Constructs a complex number from doubles representing the real
     * and imaginary parts.
     */
    public ComplexNumber(double r, double i)  {
        real = r;
        imaginary = i;
    }

    /**
     * Returns the value of the real part.
     */
    public double real()  {
        return real;
    }

    /**
     * Returns the value of the imaginary part.
     */
    public double imaginary() {
        return imaginary;
    }

    /**
     * Returns a String representing the complex number.
     */
    public String toString()  {
        return "(" + String.valueOf(real) + ") + (" +
               String.valueOf(imaginary) + ")i";
    }

    /**
     * Adds the complex number c and returns the result.
     */
    public ComplexNumber add(ComplexNumber c) {
        double newr = real + c.real();
        double newi = imaginary + c.imaginary();
        return new ComplexNumber(newr, newi);
    }

    /**
     * Multiplies by the complex number c and returns the result.
     */
    public ComplexNumber multiply(ComplexNumber c)  {
        double newr = real*c.real() - imaginary*c.imaginary();
        double newi = real*c.imaginary() + imaginary*c.real();
        return new ComplexNumber(newr, newi);
    }

    /**
     * Returns the reciprocal of the complex number.
     */
    public ComplexNumber reciprocate()
    throws ComplexNumberException {
        double denominator = real*real + imaginary*imaginary;

        if (denominator == 0) {
            throw new ComplexNumberException(
                      "Cannot reciprocate zero");
        }

        double newr = real/denominator;
        double newi = -imaginary/denominator;

        return new ComplexNumber(newr, newi);
    }
}
