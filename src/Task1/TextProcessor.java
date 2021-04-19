package Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bieliaiev Oleksandr
 * @version 1.0.0
 * @project CourseJava
 * @class TextProcessor
 * @since 19.04.2021 - 18.06
 */
public class TextProcessor {


    public static List<String> frequentlyUsedWords(String path) throws IOException {

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

        return sorted.entrySet().stream().limit(20).map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static void writeToFile(List<String> mostFreqWords) throws IOException {

        Writer writer = new BufferedWriter(new FileWriter("J:CourseOutput.txt"));

        StringBuilder sb = new StringBuilder();

        for (String mostFreqWord : mostFreqWords) {
            sb.append(mostFreqWord).append("\n");
        }
        writer.write(sb.toString());

        writer.close();

    }

    public static void main(String[] args) throws IOException {

        List<String> mostFreqWords = frequentlyUsedWords("G:harry.txt");

        writeToFile(mostFreqWords);


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
