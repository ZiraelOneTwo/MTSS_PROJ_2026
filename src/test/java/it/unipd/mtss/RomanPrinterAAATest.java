package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;
import java.time.Duration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanPrinterAAATest
{
    private static final String EXPECTED_I = """
             ___\s
            |_ _|
             | |\s
             | |\s
            |___|\n""";

    private static final String EXPECTED_V = """
            __     __
            \\ \\   / /
             \\ \\ / /\s
              \\ V /\s\s
               \\_/\s\s\s\n""";

    private static final String EXPECTED_X = """
            __  __
            \\ \\/ /
             \\  /\s
             /  \\\s
            /_/\\_\\\n""";

    private static final String EXPECTED_IV = """
             ___    __     __
            |_ _|   \\ \\   / /
             | |     \\ \\ / /\s
             | |      \\ V /\s\s
            |___|      \\_/\s\s\s\n""";

    private static final String EXPECTED_IX = """
             ___    __  __
            |_ _|   \\ \\/ /
             | |     \\  /\s
             | |     /  \\\s
            |___|   /_/\\_\\\n""";

    private static final String EXPECTED_L = """
             _\s\s\s\s\s
            | |\s\s\s\s
            | |\s\s\s\s
            | |___\s
            |_____|\n""";

    private static final String EXPECTED_C = """
             ____\s
            / ___|
            | |\s\s\s
            | |___
            \\____|\n""";

    private static final String EXPECTED_D = """
            _____\s\s
            |  _ \\\s
            | | | |
            | |_| |
            |____/\s\n""";

    private static final String EXPECTED_M = """
             __  __\s
            |  \\/  |
            | |\\/| |
            | |  | |
            |_|  |_|\n""";

    private static Stream<Arguments> provideAsciiArtCases() {
        return Stream.of(
            Arguments.of(1, EXPECTED_I),
            Arguments.of(5, EXPECTED_V),
            Arguments.of(10, EXPECTED_X),
            Arguments.of(4, EXPECTED_IV),
            Arguments.of(9, EXPECTED_IX),
            Arguments.of(50, EXPECTED_L),
            Arguments.of(100, EXPECTED_C),
            Arguments.of(500, EXPECTED_D),
            Arguments.of(1000, EXPECTED_M)
        );
    }

    // [Right] [B]: boundaries are traced correctly.
    @ParameterizedTest(name = "Correct print for integer {0}")
    @MethodSource("provideAsciiArtCases")
    public void testValidNumbersPrint(int input, String expectedAsciiArt)
    {
        // Arrange & Act
        String result = RomanPrinter.print(input);

        // Assert
        assertEquals(expectedAsciiArt, result);
    }

    // [I]nverse Relationship
    @Test
    @Disabled("Fuori dominio: specifiche non richiedono l'implementazione del decodificatore inverso.")
    public void testInverseRelationship()
    {
        // Ma se fosse stato richiesto:
        // Arrange
        // int original_number = 543;
        // String res = RomanPrinter.print(original_number);

        // Act
        // int after_transformation = IntegerPrinter.print(res);

        // Assert
        // assertEquals(original_number, after_transformation);
    }

    // [C]ross-Check
    @Test
    @Disabled("Fuori dominio: la ripetizione standard (.repeat) concatena in verticale, mentre il dominio ASCII richiede una composizione matriciale orizzontale (riga per riga). L'uguaglianza non si può ottenere strutturalmente con una logica alternativa semplice per come è posto il problema.")
    public void testCrossCheckWithAlternativeLogic() {}

    // [E]rror Conditions
    @ParameterizedTest(name = "Input out of domain ({0}) throws exception")
    @CsvSource({
        "0",
        "-10",
        "1001"
    })
    public void testExceptionPropagationForInvalidInput(int invalid_input)
    {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            // Act
            RomanPrinter.print(invalid_input);
        });
    }

    // [P]erformance Evaluation
    @Test
    public void testPerformanceOverEntireDomain()
    {
        // Assert: the block MUST terminate before 2Sec
        assertTimeout(Duration.ofMillis(2000), () -> {
            // Act: convert all possible inputs
            for (int i = 1; i <= 1000; i++) {
                RomanPrinter.print(i);
            }
        }, "Il sistema non rispetta i limiti prestazionali richiesti!");

    }
}
