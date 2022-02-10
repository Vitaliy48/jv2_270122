package lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {

        Map<String, Integer> wordlist = new HashMap<>();
        String[] words = {
                "карета", "колесо", "корона",
                "арбуз", "корона", "дыня",
                "колесо", "арбуз", "змея",
                "зеркало", "телефоне", "карета",
                "дыня", "змея", "зеркало",
                "телефон", "мёд", "корица"
        };

        for (String e : words) {
            var put = wordlist.put(e, wordlist.getOrDefault(e, 0) + 1);
        }

        System.out.println(wordlist);

        System.out.println(Arrays.toString((words)));
        System.out.println();


        Phone phonebook = new Phone();
        phonebook.add("Петров", "123456789");
        phonebook.add("Иванов", "234567891");
        phonebook.add("Сидоров", "345678912");
        phonebook.add("Федоров", "456789123");
        phonebook.add("Смирнов", "567891234");
        phonebook.add("Ларин", "678912345");
        phonebook.add("Дукалис", "789123456");
        phonebook.add("Ларин", "891234567");


        System.out.println("Телефон Ларин" + phonebook.get("Ларин"));
        System.out.println("Телефон Иванов" + phonebook.get("Иванов"));
    }
}

