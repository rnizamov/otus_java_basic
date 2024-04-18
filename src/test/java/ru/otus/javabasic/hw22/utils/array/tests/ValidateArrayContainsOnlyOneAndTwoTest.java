package ru.otus.javabasic.hw22.utils.array.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ru.otus.javabasic.hw22.utils.array.ArrayUtils.validateArrayContainsOnlyOneAndTwo;

public class ValidateArrayContainsOnlyOneAndTwoTest {

    @ParameterizedTest
    @MethodSource("positiveData")
    @DisplayName("Позитивный тест")
    void validateArrayContainsOnlyOneAndTwoPositiveTest(int[] in) {
        Assertions.assertTrue(validateArrayContainsOnlyOneAndTwo(in));
    }

    @ParameterizedTest
    @MethodSource("negativeData")
    @DisplayName("Негативный тест")
    void validateArrayContainsOnlyOneAndTwoNegativeTest(int[] in) {
        Assertions.assertFalse(validateArrayContainsOnlyOneAndTwo(in));
    }

    public static Stream<Arguments> positiveData() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 1}));
        return out.stream();
    }

    public static Stream<Arguments> negativeData() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,1}));
        out.add(Arguments.arguments(new int[]{1,3}));
        return out.stream();
    }
}
