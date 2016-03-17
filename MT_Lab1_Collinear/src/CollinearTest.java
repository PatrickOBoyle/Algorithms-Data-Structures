import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  Patrick O'Boyle
 *  @version 29/09/14 13:22:29
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty() {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays", expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearSorted failed with 3 empty arrays", expectedResult, Collinear.countCollinearSorted(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse() {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearSorted({10}, {5}, {15})", expectedResult, Collinear.countCollinearSorted(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue() {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };
        int[] a3sorted = { 5, 15 }; int[] a2sorted = { 5 }; int[] a1sorted = { 5, 10, 15 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearSorted(" + Arrays.toString(a1sorted) + "," + Arrays.toString(a2sorted) + "," + Arrays.toString(a3sorted) + ")", expectedResult, Collinear.countCollinearSorted(a1sorted, a2sorted, a3sorted));
    }

    public void testCountCollinear() throws Exception {
    }

    @Test
    public void testBinarySearch(){
        int[] a3sorted = {2, 3, 6};

        boolean expectedResult = true;

        assertEquals("binarySearch({2, 3, 6})", expectedResult, Collinear.binarySearch(a3sorted, 3));
        assertEquals("binarySearch({2, 3, 6})", expectedResult, Collinear.binarySearch(a3sorted, 6));

        expectedResult = false;

        assertEquals("binarySearch({2, 3, 6})", expectedResult, Collinear.binarySearch(a3sorted, 7));
    }

}

