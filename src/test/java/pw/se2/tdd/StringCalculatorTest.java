package pw.se2.tdd;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @org.junit.jupiter.api.Test
    void calculateEmpty() throws Exception {
        String empty = "";
        assertEquals(0,stringCalculator.calculate(empty));
    }
    @org.junit.jupiter.api.Test
    void calculateSingleNumber() throws Exception {
        String singleNumber = "5";
        assertEquals(5,stringCalculator.calculate(singleNumber));
    }
    @org.junit.jupiter.api.Test
    void calculateNormal() throws Exception {
        String normal = "5,6";
        assertEquals(11,stringCalculator.calculate(normal));
    }
    @org.junit.jupiter.api.Test
    void calculateLineDelimited() throws Exception {
        String lineSeperated = "5\n2";
        assertEquals(7,stringCalculator.calculate(lineSeperated));
    }
    @org.junit.jupiter.api.Test
    void calculateMultipleNumbers() throws Exception {
        String mixtureSeparation = "5\n2,8";
        assertEquals(15,stringCalculator.calculate(mixtureSeparation));
    }
    @org.junit.jupiter.api.Test
    void calculateNegative() {
        String mixtureSeparation = "-3\n2,8";
        Throwable exception = assertThrows(Exception.class,()->{
            stringCalculator.calculate(mixtureSeparation);
        });
        assertEquals("Negatives are not allowed!", exception.getMessage());
    }
    @org.junit.jupiter.api.Test
    void calculateOverThousand() throws Exception {
        String overThousand = "1000\n2,8";
        assertEquals(10, stringCalculator.calculate(overThousand));
        String overThousands = "1000\n6200,8";
        assertEquals(8, stringCalculator.calculate(overThousands));
        String singleOverThousands = "1200";
        assertEquals(0, stringCalculator.calculate(singleOverThousands));
    }
    @org.junit.jupiter.api.Test
    void calculateCustomSeparator() throws Exception {
        String withCustomSeparator = "//#5#2,8";
        assertEquals(15, stringCalculator.calculate(withCustomSeparator));
        String withCustomSeparator2 = "//*5*2,8";
        assertEquals(15, stringCalculator.calculate(withCustomSeparator));
    }
}