package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class YumeData {
    static Faker faker = new Faker(new Locale("en"));

    public String item = faker.options().option(
            "Filadelfija",
            "Filadelfija Premium",
            "Filadelfija Ebi",
            "Filadelfija Tuna",
            "Filadelfija Tobiko"
    );

    public String city = faker.options().option(
            "NoviSad",
            "Beograd");

    public String phoneNumber(String city) {
        String phoneNumber = "";
        if (city.equals("Beograd")) {
            phoneNumber = "+381612714798";
        }
        if (city.equals("Novi Sad")) {
            phoneNumber = "+381614813011";
        }
        return phoneNumber;
    }
}
