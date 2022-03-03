package online.HomeWork4;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String[] myWords = {
                "Яблоко", "Апельсин", "Автомобиль", "Кошка", "Собака",
                "Собака", "Линза", "Очки", "Собака", "Линза",
                "Мопед", "Автомобиль", "Число", "Номер", "Кот",
                "Система", "Мультипаспорт", "Легионер", "Макака", "Апельсин"
        };

        countUniqueWordsIn(myWords);

        System.out.println("Работа с телефонной книгой");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.appendNewPhoneToName("8(999)999-99-99", "Малахов");
        phoneBook.appendNewPhoneToName("8(988)888-88-88", "Костин");
        phoneBook.appendNewPhoneToName("8(977)777-77-77", "Костин");
        phoneBook.appendNewPhoneToName("8(966)666-66-66", "Иванов");
        phoneBook.appendNewPhoneToName("8(955)555-55-55", "Михайлюк");
        phoneBook.appendNewPhoneToName("8(944)444-44-44", "Антропов");
        phoneBook.appendNewPhoneToName("8(933)333-33-33", "Михайлюк");
        phoneBook.appendNewPhoneToName("8(922)222-22-22", "Левицкий");
        phoneBook.appendNewPhoneToName("8(911)111-11-11", "Барышев");

        System.out.println(phoneBook.getPhonesBy("Малахов"));
        System.out.println(phoneBook.getPhonesBy("Костин"));
        System.out.println(phoneBook.getPhonesBy("Иванов"));
        System.out.println(phoneBook.getPhonesBy("Михайлюк"));
        System.out.println(phoneBook.getPhonesBy("Антропов"));
        System.out.println(phoneBook.getPhonesBy("Левицкий"));
        System.out.println(phoneBook.getPhonesBy("Барышев"));

    }


    public static void countUniqueWordsIn(String[] array) {
        HashMap<String, Integer> wordsToCount = new HashMap<>(); // Словарь для хранения слова и того, сколько раз оно встречается.
        final int firstTimeSee = 1;
        for (String word : array) {
            if (wordsToCount.containsKey(word)) {
                int count = wordsToCount.get(word);
                wordsToCount.put(word, count + 1);
            } else {
                wordsToCount.put(word, firstTimeSee);
            }
        }

        System.out.println("Вывод уникальных слов в массиве");
        for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
            if (wordEntry.getValue() == firstTimeSee) {
                System.out.println(wordEntry.getKey());
            }
        }

        System.out.println("Вывод повторений слов в массиве");
        for (Map.Entry<String, Integer> wordEntry : wordsToCount.entrySet()) {
            System.out.println(wordEntry.getKey() + " : " + wordEntry.getValue());
        }
    }
}
