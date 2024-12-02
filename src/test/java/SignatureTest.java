import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.visitor.*;

import static org.junit.jupiter.api.Assertions.*;

class SignatureTest {

    @Test
    void testApplyExecutesConsumer() {
        StringBuilder output = new StringBuilder();
        Signature<String> signature = new Signature<>(output::append);

        signature.apply("test");

        assertEquals("test", output.toString());
    }

    @Test
    void testFreezeSetsId() {
        Signature<String> signature = new Signature<>(System.out::println);
        assertNull(signature.getId());

        signature.apply("test");

        assertNotNull(signature.getId());
    }
}