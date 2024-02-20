package org.example;

import org.junit.jupiter.api.DisplayNameGenerator;
import java.lang.reflect.Method;

public class DefaultDisplayNameGenerator extends DisplayNameGenerator.Standard {

    public DefaultDisplayNameGenerator() {
    }

    public String generateDisplayNameForClass(Class<?> testClass) {
        return replaceCamelCase(super.generateDisplayNameForClass(testClass));
    }

    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
    }

    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return replaceCamelCase(super.generateDisplayNameForMethod(testClass, testMethod));
    }

    private static String replaceCamelCase(String name) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            char currentCharInLowerCase = Character.toLowerCase(currentChar);
            if (Character.isUpperCase(currentChar) && i != 0) {
                result.append(" ");
            }
            result.append(currentCharInLowerCase);
        }

        result.setCharAt(0, Character.toUpperCase(result.charAt(0)));

        return result.toString();
    }
}
