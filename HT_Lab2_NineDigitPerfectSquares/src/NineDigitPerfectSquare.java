import java.util.ArrayList;

/**
 * CS2010 (Hilary Term) - Assignment 1
 *
 * Nine Digit Perfect Square
 *
 * A natural number, p, is a perfect square if for some natural number k, k^2=p.
 * For example, 16 is a perfect square, as 4^2=16. The number 20 is not a
 * perfect square as there is no natural number k such that k^2=20.
 *
 * Problem: Develop an algorithm that will find all nine-digit perfect squares
 * that use all nine digits exactly once. For example, 139,854,276 is a solution
 * (the first) as 11,826^2=139,854,276.
 *
 * 1) Fill in the implementation of the methods described in this file.
 *
 * 2) Test your implementation by developing suitable test suite in the
 * NineDigitPerfectSquareTest JUnit test case.
 *
 * @author: Patrick O'Boyle
 *
 */


public class NineDigitPerfectSquare {
    /*
        Name: floorSqrt
        Desc: Floors the square root of a passed double, x,
              and returns the result
        Param:
            - double, x:
        Returns:
            - int
    */
    private int floorSqrt(double x) {
        int odd, s, r;

        odd = 1;
        s = 1;
        r = 0;

        while ( s <= x ) {
            r++;
            odd = odd + 2;
            s = s + odd;
        }

        return r;
    }

    /*
        Name: convertIntegerArrayToIntArray
        Desc: Takes in an arraylist of type Integer, converts and returns
              it as an int[]
        Param:
            - ArrayList<Integer> arrayList
        Returns:
            - int[]
    */
    private int[] convertIntegerArrayToIntArray(ArrayList<Integer> arrayList){
        int perfectSquaresArray[] = new int[arrayList.size()];

        for(int i = 0; i < arrayList.size(); i++){
            perfectSquaresArray[i] = arrayList.get(i);
        }

        return perfectSquaresArray;
    }

    /**
     * A method to return an array containing all squares between low and high
     *
     * @param low: lowest perfect square
     * @param high: largest perfect square
     *
     * @return an array containing all the perfect squares between low and high
     */
    public int[] perfectSquaresBetween(int low, int high){
        int maxInteger = floorSqrt(high);

        ArrayList<Integer> perfectSquares = new ArrayList<>();

        for(int minInteger = floorSqrt(low); minInteger <= maxInteger; minInteger++){
            int perfectSquare = minInteger * minInteger;
            perfectSquares.add(perfectSquare);
        }

        return convertIntegerArrayToIntArray(perfectSquares);
    }

    public int countNineDigitPerfectSquares(){
        return getNineDigitPerfectSquares().length;
    }

    /**
     * A method to determine if the number specified in parameter "number"
     * contains all 9 digits exactly once.
     *
     * @param number
     *            : A number to be tested
     * @return whether the number contains all 9 digits exactly once
     */
    public boolean containsAllDigitsOnce(int number) {
        boolean array[] = new boolean[9];

        for(int i = 0; i < array.length; i++){
            array[i] = false;
        }

        char num[] = String.valueOf(number).toCharArray();

        boolean duplicateDetected = false;

        for(int i = 0; i < num.length; i++){
            int digit = (int)num[i] - 48;

            if(digit != 0){
                if(array[digit - 1]){
                    duplicateDetected = true;
                    break;
                }else{
                    array[digit - 1] = true;
                }
            }
        }

        if(!duplicateDetected){
            for(int i = 0; i < array.length; i++){
                if(!array[i])
                    return false;
            }
            return true;
        }else
            return false;
    }

    /**
     * A method to return an array containing all the squares discovered
     *
     * @return an array containing all of the perfect squares which
     * contain all digits 1..9 exactly once.
     */
    public int[] getNineDigitPerfectSquares() {
        // The first 9 digit perfect square that matches
        int MIN = 11826 * 11826;
        // The last 9 digit perfect square that exists
        int MAX = 31622 * 31622;

        // Get all perfect squares in the range MIN, MAX
        int perfectSquares[] = perfectSquaresBetween(MIN, MAX);
        System.out.println(perfectSquares.length);

        // Create an array list to hold all nine digit perfect squares that match the pattern
        ArrayList<Integer> nineDigitPerfectSquares = new ArrayList<>();

        // For all perfect squares in the range, test that they contain all nine digits
        for(int i = 0; i < perfectSquares.length; i++){
            if( containsAllDigitsOnce(perfectSquares[i])) {
                nineDigitPerfectSquares.add(perfectSquares[i]);
            }
        }

        return convertIntegerArrayToIntArray(nineDigitPerfectSquares);
    }
}
