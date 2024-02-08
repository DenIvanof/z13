import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.task.*;

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
        System.out.println("Тест №1 - добавление задач");
    }


    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №2 - подходит для SimpleTask");
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №3 - не подходит для SimpleTask");
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №4 - подходит для Epic");
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("молоко");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №5 - не подходит для Epic");
    }

    @Test
    public void shouldFindQueryInMeetingTrue() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №6 - подходит для Meeting");
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("приложение");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №7 - не подходит для Meeting");
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(55);

        boolean expected = false;
        boolean actual = task.matches("Приложение");

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №8 - не подходит");
    }


    //////////////////
    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №9 - подзадачи");
    }

    @Test
    public void shouldGetId() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Task task = new Task(55);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
        System.out.println("Тест №10 - айди");
    }


    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить продукты");

        String[] subtasks = {"Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Купить");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №11 - Поиск в SimpleTask и Epic");
    }


    @Test
    public void shouldSearchInMeetingAndEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №12 - Поиск в Meeting и Epic");
    }


    @Test

    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №13 - Поиск в SimpleTask");
    }


    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №14 - Поиск в Epic");
    }

    @Test
    public void shouldSearchInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №15 - Поиск в Meeting 1");
    }

    @Test
    public void shouldSearchInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №16 - Поиск в Meeting 2");
    }

    @Test
    public void shouldSearchInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №17 - Поиск в Meeting 3");
    }


    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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
        Task[] actual = todos.search("о");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №18 - Поиск в SimpleTask, Epic и Meeting");
    }

    @Test
    public void shouldNotSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

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

        Task[] expected = {};
        Task[] actual = todos.search("Курица");

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест №18 - Ничего не найдено");
    }
}
