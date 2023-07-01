package org.tms.utils.tools;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String getTestProjectName() {
        return faker.book().title();
    }

}
