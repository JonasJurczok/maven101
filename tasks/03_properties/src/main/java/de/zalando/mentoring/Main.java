package de.zalando.mentoring;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> temp = new ArrayList<String>();
        temp.add("test1");
        temp.add("test2");
        temp.add("test3");

        temp.forEach(element -> System.out.println(element));
    }
}
