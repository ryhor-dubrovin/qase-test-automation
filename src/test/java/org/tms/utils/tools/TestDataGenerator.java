package org.tms.utils.tools;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String createProjectName() {
        return faker.book().title();
    }
    public static String createProjectCode() {
        return faker.regexify("[A-Z0-9]{2,10}");
    }
    public static String createSuiteTitle() {
        return "Suite " + faker.lorem().word();
    }
    public static String createCaseTitle() {
        return "Case " + faker.lorem().word();
    }
    public static String createSuiteDescription() {
        return faker.lorem().sentence();
    }

}
