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

}
