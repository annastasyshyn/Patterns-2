import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ua.edu.ucu.apps.atm.*;

public class ATMTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testATMProcessValidAmount() {
        ATM atm = new ATM();
        atm.process(155);
        String expectedOutput = "Please recieve 1 x 5\nPlease recieve 1 x 50\nPlease recieve 1 x 100";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testATMProcessInvalidAmount() {
        ATM atm = new ATM();
        atm.process(3);
    }

    @Test
    public void testATMProcessZeroAmount() {
        ATM atm = new ATM();
        atm.process(0);
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void testATMProcessExactHundreds() {
        ATM atm = new ATM();
        atm.process(200);
        String expectedOutput = "Please recieve 2 x 100";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}