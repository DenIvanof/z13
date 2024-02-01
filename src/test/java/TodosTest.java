import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.task.*;

import java.util.Arrays;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(
                55,
                subtasks
        );

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №1");
        System.out.println("Ожидаемый результат");
        System.out.println(Arrays.toString(expected));
        System.out.println("Фактический результат");
        System.out.println(Arrays.toString(actual));
    }
}
