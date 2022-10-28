package org.example.codingbat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void test() {

        int outcome = max(2, 3);

        Assertions.assertEquals(3, outcome);

    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }
}
