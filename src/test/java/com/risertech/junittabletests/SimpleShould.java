package com.risertech.junittabletests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class SimpleShould {
    // Create a record with the test name and any arguments and return values
    record IdentityTest(String name, int number) {
    }

    @TestFactory
    Collection<DynamicTest> testIdentity() {
        // Create a list of Tests
        var tests = Arrays.asList(
                new IdentityTest("zero", 0),
                new IdentityTest("min", Integer.MIN_VALUE),
                new IdentityTest("max", Integer.MAX_VALUE));

        // Map over the tests to return a collection of dynamicTests
        return tests.stream().map(test -> dynamicTest(test.name, () -> {
            // Put test code here
            assertEquals(test.number, Simple.identity(test.number));
        })).collect(Collectors.toList());
    }
}
