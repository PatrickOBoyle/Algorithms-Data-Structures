public class Check_Triangle {
    public static final int ACUTE_TRI = 2;
    public static final int RIGHT_ANGLED_TRI = 1;
    public static final int OBTUSE_TRI = 3;
    public static final double TINY_DIFF = 0.0001;
    public static final int NOT_TRI = 0;

     static boolean form_triangle(double[] ls) {
        return ( 2 * max(ls) < sum(ls) );
    }

    static int kind_triangle(double[] ls) {
        if( !form_triangle(ls) ){
            return NOT_TRI;
        }

        double c = 0;
        int index = 0;

        for(int i = 0; i < ls.length; i++){
            if(c < ls[i]) {
                c = ls[i];
                index = i;
            }
        }

        double a;
        double b;

        if(index == 0){
            a = ls[1];
            b = ls[2];
        }else if(index == 1){
            a = ls[0];
            b = ls[2];
        }else{
            a = ls[0];
            b = ls[1];
        }

        double result = (c * c) - ( (a * a) + (b * b) );

        if(result == 0)
            return RIGHT_ANGLED_TRI;
        else if(result < 0)
            return ACUTE_TRI;
        else
            return OBTUSE_TRI;
    }


    static double sum(double[] arr) {
        double result = 0;

        for (int k = 0; k < arr.length; k++)
            result += arr[k];
        return result;
    }

    static double max(double[] arr) {
        int j = 0;

        int k = arr.length - 1;

        while ( j < k ) {
            if (arr[j] < arr[k])
                j++;
            else
                k--;
        }
        return arr[j];
    }
}