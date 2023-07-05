package Hw_5;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Vasya Pupkin", "8918-1234");
        addContact(phoneBook, "Ivan Ivanich", "123-5678");
        addContact(phoneBook, "Vasya Pupkin", "0987-9876");
        addContact(phoneBook, "San Sanich", "998-4321");

        List<Map.Entry<String, List<String>>> sortedContacts = sortContacts(phoneBook);
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }

    public static List<Map.Entry<String, List<String>>> sortContacts(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(sortedContacts);
        return sortedContacts;
    }
}