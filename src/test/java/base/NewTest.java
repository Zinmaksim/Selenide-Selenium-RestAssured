package base;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewTest {
    @Test
    public void test() {

List<String> list1 = Arrays.asList("num-1", "num-2", "num-3", "num-4");

 List<String> list2 = list1.stream().map(s -> s.replaceAll("-", " " )).collect(Collectors.toList());


        list1.forEach(s -> list1.replaceAll(s1 -> s1.replaceAll("-", " ")));
        list1.forEach(System.out::println);
    }
}



