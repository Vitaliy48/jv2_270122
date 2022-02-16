package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {
    private Map<String, List<String>> PhoneDirectory = new HashMap<>();

    private List<String> thePhoneNumber;

    public void add(String surname, String phone_number) {
        if (PhoneDirectory.containsKey(surname)) {
            thePhoneNumber = PhoneDirectory.get(surname);
            thePhoneNumber.add(phone_number);
            PhoneDirectory.put(surname, thePhoneNumber);
        } else {
            thePhoneNumber = new ArrayList<>();
            thePhoneNumber.add(phone_number);
            PhoneDirectory.put(surname, thePhoneNumber);
        }
    }

    public List<String> get(String surname) {
        return PhoneDirectory.get(surname);
    }

}
