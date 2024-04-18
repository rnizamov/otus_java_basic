package ru.otus.javabasic.hw22.utils.array.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.javabasic.hw22.utils.array.ArrayException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ru.otus.javabasic.hw22.utils.array.ArrayUtils.getElementsAfterLastOne;

public class ElementsAfterLastOneTest {

    @ParameterizedTest
    @MethodSource("testDataAfterLastOne")
    @DisplayName("Позитивный тест")
    void getElementsAfterLastOnePositiveTest(int[] in, int[] expected) {
        Assertions.assertArrayEquals(expected, getElementsAfterLastOne(in));
    }

    @Test
    @DisplayName("Негативный тест, проверка на выброс ArrayException")
    void getElementsAfterLastOneExceptionTest() {
        Assertions.assertThrowsExactly(ArrayException.class, () -> {
            getElementsAfterLastOne(new int[]{2,2,2,2});
        });
    }

    public static Stream<Arguments> testDataAfterLastOne() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 1, 2, 2}, new int[]{2, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 1, 3}, new int[]{3}));
        out.add(Arguments.arguments(new int[]{1, 3, 3, 4}, new int[]{3, 3, 4}));
        return out.stream();
    }
}