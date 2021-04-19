package Task2;

import java.util.Arrays;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project CourseJava
 * @class RightShift
 * @since 19.04.2021 - 20.00
 */
public class RightShift {

    public static int[] rightShift(int[] array, int step) {

        for (int i = 0; i < step; i++) {
            int last = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = last;
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(array, 1))); // [30, 10, 20]

        int[] array2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array2, 2))); // [40, 50, 10, 20, 30]

        int[] array3 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array3, 1))); // [50, 10, 20, 30, 40]
    }
}

//        [30, 10, 20]
//        [40, 50, 10, 20, 30]
//        [50, 10, 20, 30, 40]