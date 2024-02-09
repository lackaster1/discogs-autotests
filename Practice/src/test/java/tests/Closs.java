package tests;

import java.util.*;

public class Closs {

    public String abs_2() {
        return "222";
    }

    static class Ff<U, T> {
        private U u;
        private T t;

        private <U> void doi(List<U> list) {
            for (U u : list) {
                System.out.println(u);
            }
        }
    }

    public static void main(String[] args) {
        Ff<String, Integer> wee = new Ff<>();
        wee.doi(List.of(1));

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }
}
