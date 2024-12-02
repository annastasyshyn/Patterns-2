import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ua.edu.ucu.apps.visitor.*;

class MyVisitorTest {

    @Test
    void testVisit() {
        Task<String> task = new Signature<>(System.out::println);
        MyVisitor visitor = new MyVisitor("test-group-uuid");

        visitor.visit(task);

        assertEquals("test-group-uuid", task.getHeader("groupUUID"));
    }
}