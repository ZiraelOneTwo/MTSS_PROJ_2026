package it.unipd.mtss;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAppInstantiation()
    {
        // Forza l'attraversamento del costruttore di default in src/main/java
        App app = new App();

        // Verifica banalmente che l'oggetto esista
        assertNotNull(app);
    }
}
