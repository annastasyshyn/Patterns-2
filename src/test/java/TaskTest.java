import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.visitor.*;


import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testFreezeGeneratesId() {
        Task<String> task = new Signature<>(System.out::println);
        assertNull(task.getId());

        task.freeze();

        assertNotNull(task.getId());
    }
}