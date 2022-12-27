import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // 範例1
//        Stream<String> rows = Files.lines(Paths.get("data.txt"), StandardCharsets.UTF_8);
//        Map<String, Integer> map= rows.map(x->x.split(","))
//                .filter(x-> x.length == 3)
//                .filter(x-> Integer.parseInt(x[1]) > 15)
//                        .collect(Collectors.toMap(
//                                x-> x[0],
//                                x -> Integer.parseInt(x[1])
//                        ));
//        map.forEach((key, value)-> System.out.println(key+ "," + value));
        // 範例2
//        IntSummaryStatistics s =  IntStream.of(3,4,5,6,7,8,9,10).summaryStatistics();
//        System.out.println(s.getMax());
//        System.out.println(s.getMin());
//        System.out.println(s.getAverage());
//        System.out.println(s.getCount());
//        System.out.println(s.getSum());
        // 範例3 數字相加
//        int result=  Stream.of(3,4,5,6,7,8).reduce(0, (Integer a, Integer b)-> a+b);
//        System.out.println(result);
        // 範例4 相乘
//        int result=  Stream.of(3,4,5,6,7,8).reduce(1, (Integer a, Integer b)-> a*b);
//        System.out.println(result);
        Random random = new Random();
        int[] list = random.ints(50000000).toArray();

        System.out.println("Number of processors " + Runtime.getRuntime().availableProcessors());

        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list)
                .filter(e -> e > 0)
                .sorted()
                .limit(5)
                .toArray();
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution is " + (endTime - startTime) + "milliseconds.");

        System.out.println("===================================");

        startTime = System.currentTimeMillis();
        int[] list2 = IntStream.of(list)
                .parallel()
                .filter(e -> e > 0)
                .sorted()
                .limit(5)
                .toArray();
        System.out.println(Arrays.toString(list2));
        endTime = System.currentTimeMillis();
        System.out.println("Parallel execution is " + (endTime - startTime) + "milliseconds.");
    }
}