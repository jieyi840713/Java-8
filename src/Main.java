import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // 範例1
//        String[] names= {"Ron", "Wilson", "Harry", "Grace", "Mike"};
//        Arrays.stream(names)
//                .filter(name -> name.startsWith("R"))
//                .forEach(name-> System.out.println(name));
        // 範例2
//        Arrays.stream(new int[] {2,4,6,8,10})
//                .map(n-> n *n)
//                .average()
//                .ifPresent(System.out::println);
        // 範例3
//        ArrayList<String> people = new ArrayList<>();
//        people.add("Ron");
//        people.add("rat");
//        people.add("Wilson");
//        people.add("Harry");
//        people.add("Grace");
//        people.add("Mike");
//        people.stream()
//                .map(String::toLowerCase)
//                .filter(name->name.startsWith("r"))
//                .forEach(System.out::println);
        Stream<String> bands = Files.lines(Paths.get("bands.txt"), StandardCharsets.UTF_8);
//        bands
//                .filter(name-> name.length() > 13)
//                .sorted()
//                .forEach(System.out::println);
        List<String> myList =bands
                .filter(name->name.contains("jit"))
                        .collect(Collectors.toList());
        myList.forEach(System.out::println);
    }
}