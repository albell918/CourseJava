package Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project CourseJava
 * @class TexrProcessor
 * @since 19.04.2021 - 18.06
 */
public class TextProcessor {




    public static void frequentlyUsedWords(String path) throws IOException {

        String textRaw = new String(Files.readAllBytes(Paths.get(path)));

        textRaw = textRaw.toLowerCase().replaceAll("[^A-Za-z ']", "");

        String[] words = textRaw.split("\\s+");

        List<String> list = Arrays.stream(words).collect(Collectors.toList());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            if (!map.containsKey(words[i])) {

                map.put(words[i], 1);

            } else {
                Integer value = map.get(words[i]);
                map.put(words[i], ++value);

            }

        }

        Map<String, Integer> sorted = new LinkedHashMap<>();


        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));

        sorted.entrySet().stream().limit(20).forEach(System.out::println);
}

public static void findNames(String path) throws IOException {

    String textRaw = new String(Files.readAllBytes(Paths.get(path)));

    textRaw = textRaw.toLowerCase().replaceAll("[^A-Za-z ']", "");

    String[] words = textRaw.split("\\s+");

    List<String> list = Arrays.stream(words).collect(Collectors.toList());


    boolean isUppercase;

    int counter = -1;

    for (int i = 0; i < 100; i++) {
        counter++;

        String [] myWord = words[i].split("(?!^)");



       isUppercase = myWord[0].chars().noneMatch(Character::isUpperCase);

        if (isUppercase==true){
            System.out.println(myWord[counter]);
        }

    }

};

    public static void main(String[] args) throws IOException {
        frequentlyUsedWords("G:harry.txt");
        findNames("G:harry.txt");

//        Files.write(Paths.get("G:CourseOutput.txt"), str.getBytes(StandardCharsets.UTF_8));

    }

}

//        the=3628
//        and=1919
//        to=1855
//        a=1688
//        he=1527
//        of=1259
//        harry=1214
//        was=1186
//        it=1025
//        in=964
//        his=937
//        you=862
//        said=794
//        had=702
//        i=652
//        on=635
//        at=625
//        that=601
//        they=597
//        as=526
