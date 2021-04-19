import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project CourseJava
 * @class Task4
 * @since 19.04.2021 - 19.00
 */
public class Prefix {

    public static String prefix(String[] array) {

        String currentPref = array[0];
        for (int i = 1; i < array.length; i++) {
            while (array[i].indexOf(currentPref) != 0) {
                currentPref = currentPref.substring(0, currentPref.length() - 1);
                if (currentPref.equals("")) return "";
            }
        }
        return currentPref;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"};

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"};

        System.out.println(prefix(array2)); // abc

    }
}

//            abc
//            abc