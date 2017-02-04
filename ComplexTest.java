package CSIS202JunitTests;

import com.foba.CSIS202.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

//TODO: Add tests for large integers
//TODO: Add tests for negatives (Irattional, large, small)

class ComplexTest {

    public static final double EPSILON = 1e-10;

    final double REAL_PART_VALUE_1 = 3.5;
    final double IMAGINARY_PART_VALUE_1 = 7;

    final double REAL_PART_VALUE_2 = 8.34;
    final double IMAGINARY_PART_VALUE_2 = 6.1;

    /*
    I added these for robustness. At the start of each test run these
    variables will be loaded with random irrational values. That way we can
    test with irrational values.
    */
    private Random random = new Random();
    final double REAL_PART_RAND_VALUE_1 = random.nextDouble();
    final double IMAGINARY_PART_RAND_VALUE_1 = random.nextDouble();
    final double REAL_PART_RAND_VALUE_2 = random.nextDouble();
    final double IMAGINARY_PART_RAND_VALUE_2 = random.nextDouble();


    //***Check that the class has the specified properties***//
    @Test
    void complexObjectHasRealPartProperty()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        assertThat(complex, hasProperty("realPart"));
    }

    @Test
    void complexObjectHasImaginaryPartProperty()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        assertThat(complex, hasProperty("imaginaryPart"));
    }

    //***Check that the object instantiates with the correct values***//
    //Using rational values
    @Test
    void complexObjectHasCorrectRealPartValue()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        assertThat(complex, hasProperty("realPart", equalTo(REAL_PART_VALUE_1)));
    }

    @Test
    void complexObjectHasCorrectImaginaryPartValue()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        assertThat(complex, hasProperty("imaginaryPart", equalTo(IMAGINARY_PART_VALUE_1)));
    }

    //Using irrational random values
    @Test
    void complexObjectHasCorrectRealPartValueRand()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        assertThat(complex, hasProperty("realPart", closeTo(REAL_PART_RAND_VALUE_1, EPSILON)));
    }

    @Test
    void complexObjectHasCorrectImaginaryPartValueRand()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        assertThat(complex, hasProperty("imaginaryPart", closeTo(IMAGINARY_PART_RAND_VALUE_1, EPSILON)));
    }


    //***Checking the getters***//
    //Using Rational values
    @Test
    void getRealPartReturnsCorrectValueRat()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Assertions.assertEquals(REAL_PART_VALUE_1, complex.getRealPart());
    }

    @Test
    void getImaginaryPartReturnsCorrectValueRat()
    {
        Complex complex = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Assertions.assertEquals(IMAGINARY_PART_VALUE_1, complex.getImaginaryPart());
    }

    //Using Irrational values
    @Test
    void getRealPartReturnsCorrectValueIrrat()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        assertThat(complex.getRealPart(), closeTo(REAL_PART_RAND_VALUE_1, EPSILON));
    }

    @Test
    void getImaginaryPartReturnsCorrectValueIrrat()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        assertThat(complex.getImaginaryPart(), closeTo(IMAGINARY_PART_RAND_VALUE_1, EPSILON));
    }

    @Test
    void addComplexNumbersCorrectRealPartValueRat()
    {
        double newRealPart = REAL_PART_VALUE_1 + REAL_PART_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.add(complex2);

        assertThat(complex1.getRealPart(), equalTo(newRealPart));
    }

    @Test
    void addComplexNumbersCorrectImaginaryPartValueRat()
    {
        double newImaginaryPart = IMAGINARY_PART_VALUE_1 + IMAGINARY_PART_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.add(complex2);

        assertThat(complex1.getImaginaryPart(), equalTo(newImaginaryPart));
    }

    @Test
    void addComplexNumbersCorrectRealPartValueIrrat()
    {
        double newRealPart = REAL_PART_RAND_VALUE_1 + REAL_PART_RAND_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.add(complex2);

        assertThat(complex1.getRealPart(), closeTo(newRealPart, EPSILON));
    }

    @Test
    void addComplexNumbersCorrectImaginaryPartValueIrrat()
    {
        double newImaginaryPart = IMAGINARY_PART_RAND_VALUE_1 + IMAGINARY_PART_RAND_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.add(complex2);

        assertThat(complex1.getImaginaryPart(), closeTo(newImaginaryPart, EPSILON));
    }

    @Test
    void subComplexNumbersCorrectRealPartValueRat()
    {
        double newRealPart = REAL_PART_VALUE_1 - REAL_PART_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getRealPart(), equalTo(newRealPart));
    }

    @Test
    void subComplexNumbersCorrectImaginaryPartValueRat()
    {
        double newImaginaryPart = IMAGINARY_PART_VALUE_1 - IMAGINARY_PART_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getImaginaryPart(), equalTo(newImaginaryPart));
    }

    @Test
    void subComplexNumbersCorrectRealPartValueIrrat()
    {
        double newRealPart = REAL_PART_RAND_VALUE_1 - REAL_PART_RAND_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getRealPart(), closeTo(newRealPart, EPSILON));
    }

    @Test
    void subComplexNumbersCorrectImaginaryPartValueIrrat()
    {
        double newImaginaryPart = IMAGINARY_PART_RAND_VALUE_1 - IMAGINARY_PART_RAND_VALUE_2;
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getImaginaryPart(), closeTo(newImaginaryPart, EPSILON));
    }

    @Test
    void multiplyComplexNumbersCorrectRealPartValueRat()
    {
        //Multiplication is defined as: (a + bi)(c + di) = (ac - bd) + (bc + ad)i
        double newRealPart = ((REAL_PART_VALUE_1 * REAL_PART_VALUE_2) -  (IMAGINARY_PART_VALUE_1 * IMAGINARY_PART_VALUE_2));

        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.multiply(complex2);

        assertThat(newRealPart, equalTo(complex1.getRealPart()));
    }

    @Test
    void multiplyComplexNumbersCorrectImaginaryPartValueRat()
    {
        double newImaginaryPart = (IMAGINARY_PART_VALUE_1 * REAL_PART_VALUE_2 -  REAL_PART_VALUE_1 * IMAGINARY_PART_VALUE_2);
        Complex complex1 = new Complex(REAL_PART_VALUE_1, IMAGINARY_PART_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_VALUE_2, IMAGINARY_PART_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getImaginaryPart(), equalTo(newImaginaryPart));
    }

    @Test
    void multiplyComplexNumbersCorrectRealPartValueIrrat()
    {
        double newRealPart = (REAL_PART_RAND_VALUE_1 * REAL_PART_RAND_VALUE_2) -  (IMAGINARY_PART_RAND_VALUE_1 * IMAGINARY_PART_RAND_VALUE_2);
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getRealPart(), closeTo(newRealPart, EPSILON));
    }

    @Test
    void multiplyComplexNumbersCorrectImaginaryPartValueIrrat()
    {
        double newImaginaryPart = (IMAGINARY_PART_RAND_VALUE_1 * REAL_PART_RAND_VALUE_2) -  (REAL_PART_RAND_VALUE_1 * IMAGINARY_PART_RAND_VALUE_2);
        Complex complex1 = new Complex(REAL_PART_RAND_VALUE_1, IMAGINARY_PART_RAND_VALUE_1);
        Complex complex2 = new Complex(REAL_PART_RAND_VALUE_2, IMAGINARY_PART_RAND_VALUE_2);

        complex1.sub(complex2);

        assertThat(complex1.getImaginaryPart(), closeTo(newImaginaryPart, EPSILON));
    }









}

//-_realPart: double
//-_imaginaryPart: double
//+Complex()
//+Complex(initialReal: double, initialImaginary: double)
//+getRealPart(): double
//+getImaginaryPart(): double
//+add(anotherNum: Complex)
//+subtract(anotherNum: Complex)
//+multiply(anotherNum: Complex)
//+divide(anotherNum: Complex)
//+toString(): String
//+equals(anotherNum: Complex): boolean