package it.unipd.mtss;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerToRomanAAATest
{

    // [Right] [B]oundaries Traced Correctly
    @ParameterizedTest(name = "convert({0}) returns {1}")
    @CsvSource({
        "3, III",
        "5, V",
        "9, IX",
        "40, XL",
        "90, XC",
        "300, CCC",
        "1000, M"
    })
    public void testLowEntropyValidConversion(int input, String expected)
    {
        // Arrange & Act
        String result = IntegerToRoman.convert(input);

        // Assert
        assertEquals(expected, result);
    }

    // [Right]
    @ParameterizedTest(name = "convert({0}) returns {1}")
    @CsvSource({
        "678, DCLXXVIII",
        "12,  XII",
        "943, CMXLIII",
        "315, CCCXV",
        "789, DCCLXXXIX",
        "492, CDXCII",
        "559, DLIX"
    })
    public void testHighEntropyValidConversion(int input, String expected)
    {
        // Arrange & Act
        String result = IntegerToRoman.convert(input);

        // Assert
        assertEquals(expected, result);
    }

    // [I]nverse Relationship
    @Test
    @Disabled("Fuori dominio: specifiche non richiedono l'implementazione del decodificatore inverso.")
    public void testInverseRelationship()
    {
        // Ma se fosse stato richiesto:
        // Arrange
        // int original_number = 543;
        // String res = IntegerToRoman.convert(original_number);

        // Act
        // int after_transformation = RomanToInteger.convert(res);

        // Assert
        // assertEquals(original_number, after_transformation);
    }

    // [C]ross-Check
    @Test
    public void testCrossCheckWithAlternativeLogic()
    {
        // Arrange
        int i = 3;
        String expectedViaCrossCheck = "I".repeat(i);

        // Act
        String result = IntegerToRoman.convert(i);

        // Assert
        assertEquals(expectedViaCrossCheck, result);
    }

    // [E]rror Conditions
    @ParameterizedTest(name = "Input out of domain ({0}) throws exception")
    @CsvSource({
        "0",
        "-10",
        "1001"
    })
    public void testInvalidInputsThrowException(int invalid_input)
    {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            // Act
            IntegerToRoman.convert(invalid_input);
        });
    }

    // [P]erformance Evaluation
    @Test
    public void testPerformanceOverEntireDomain()
    {
        // Assert: the block MUST terminate before 100ms
        assertTimeout(Duration.ofMillis(100), () -> {
            // Act: convert all the possible domain input
            for (int i = 1; i <= 1000; i++) {
                IntegerToRoman.convert(i);
            }
        }, "Il sistema non rispetta i limiti prestazionali richiesti!");

    }
}
