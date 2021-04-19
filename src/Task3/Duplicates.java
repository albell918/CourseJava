package Task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project CourseJava
 * @class Duplicates
 * @since 19.04.2021 - 18.48
 */
public class Duplicates {
    public static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);

        List<Integer> list = Arrays.stream(array).boxed().distinct().collect(Collectors.toList());

        if (list.size() != array.length) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 6, 2, 9, 33, 21};
        System.out.println(hasDuplicates(array));  // false
        array[5] = 1;
        System.out.println(hasDuplicates(array)); // true
    }
}
//        false
//        true