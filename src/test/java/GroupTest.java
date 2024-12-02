import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.visitor.*;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void testAddTask() {
        Group<String> group = new Group<>();
        Task<String> task1 = new Signature<>(System.out::println);
        Task<String> task2 = new Signature<>(System.out::println);

        group.addTask(task1).addTask(task2);

        assertDoesNotThrow(() -> group.apply("test"));
    }

    @Test
    void testApplyExecutesTasks() {
        StringBuilder output = new StringBuilder();
        Task<String> task1 = new Signature<>(output::append);
        Task<String> task2 = new Signature<>(s -> output.append(s.toUpperCase()));
        Group<String> group = new Group<>();
        group.addTask(task1).addTask(task2);

        group.apply("a");

        assertEquals("aA", output.toString());
    }

    @Test
    void testGroupVisitorSetsGroupUUID() {
        Task<String> task = new Signature<>(System.out::println);
        Group<String> group = new Group<>();
        group.addTask(task);

        group.apply("test");

        String groupUUID = group.getHeader("groupUUID");
        assertNotNull(groupUUID);
        assertEquals(groupUUID, task.getHeader("groupUUID"));
    }
}