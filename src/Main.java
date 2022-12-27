import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] names= {"Ron", "Wilson", "Harry", "Grace", "Mike"};
        Arrays.stream(names)
                .filter(name -> name.startsWith("R"))
                .forEach(name-> System.out.println(name));
    }
}