package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaComparator {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Vasiliy",
                "Yu",
                "Ana"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
       // Arrays.sort(names, lengthCmp);
        Comparator<String> cmpDesSize = (left, right) -> {
            System.out.println("left: " + left + ":    " + "right " + right);
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(names, cmpDesSize);
        System.out.println(Arrays.toString(names));
    }

}
