package base;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Base {
    @Test
    private void main() {
        int[] a;
        a = new int[10];
        a[1] = 1;
        Arrays.stream(a).forEach(System.out::println);

    }
}



