package CSIS202JunitTests;

import com.foba.CSIS202.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

// tdawson16@georgefox.edu
// Program 
// 2017-02-01

class ComplexTest {

    public static final double EPSILON = 1e-10;
    final double REAL_PART_VALUE = 3.5;
    final double IMAGINARY_PART_VALUE = 7;

    /*
    I added these for robustness. At the start of each test run these
    variables will be loaded with random irrational values. That way we can
    test with irrational values.
    */
    private Random random = new Random();
    final double REAL_PART_RAND_VALUE = random.nextDouble();
    final double IMAGINARY_PART_RAND_VALUE = random.nextDouble();


    //***Check that the class has the specified properties***//
    @Test
    void complexObjectHasRealPartProperty()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        assertThat(complex, hasProperty("realPart"));
    }

    @Test
    void complexObjectHasImaginaryPartProperty()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        assertThat(complex, hasProperty("imaginaryPart"));
    }

    //***Check that the object instantiates with the correct values***//
    //Using rational values
    @Test
    void complexObjectHasCorrectRealPartValue()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        assertThat(complex, hasProperty("realPart", equalTo(REAL_PART_VALUE)));
    }

    @Test
    void complexObjectHasCorrectImaginaryPartValue()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        assertThat(complex, hasProperty("imaginaryPart", equalTo(IMAGINARY_PART_VALUE)));
    }

    //Using irrational random values
    @Test
    void complexObjectHasCorrectRealPartValueRand()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE, IMAGINARY_PART_RAND_VALUE);
        assertThat(complex, hasProperty("realPart", closeTo(REAL_PART_RAND_VALUE, EPSILON)));
    }

    @Test
    void complexObjectHasCorrectImaginaryPartValueRand()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE, IMAGINARY_PART_RAND_VALUE);
        assertThat(complex, hasProperty("imaginaryPart", closeTo(IMAGINARY_PART_RAND_VALUE, EPSILON)));
    }



    //***Checking the getters***//
    //Using Rational values
    @Test
    void getRealPartReturnsCorrectValueRat()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        Assertions.assertEquals(REAL_PART_VALUE, complex.getRealPart());
    }

    @Test
    void getImaginaryPartReturnsCorrectValueRat()
    {
        Complex complex = new Complex(REAL_PART_VALUE, IMAGINARY_PART_VALUE);
        Assertions.assertEquals(IMAGINARY_PART_VALUE, complex.getImaginaryPart());
    }

    //Using Irrational values
    @Test
    void getRealPartReturnsCorrectValueIrrat()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE, IMAGINARY_PART_RAND_VALUE);
        assertThat(complex.getRealPart(), closeTo(REAL_PART_RAND_VALUE, EPSILON));
    }

    @Test
    void getImaginaryPartReturnsCorrectValueIrrat()
    {
        Complex complex = new Complex(REAL_PART_RAND_VALUE, IMAGINARY_PART_RAND_VALUE);
        assertThat(complex.getImaginaryPart(), closeTo(IMAGINARY_PART_RAND_VALUE, EPSILON));
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