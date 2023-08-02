package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
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
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void todosSearchMeeting() {

        Task simpleTask = new SimpleTask(5, "сходить в магазин");

        String[] subtasks = {"пропылесосить", "помыть пол", "помыть кота"};
        Task epic = new Epic(35, subtasks);

        Task meeting = new Meeting(
                341,
                "ооп",
                "учеба",
                "Сегодня после завтрака"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("ооп");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void todosSearchEpic() {

        Task simpleTask = new SimpleTask(5, "сходить в магазин");

        String[] subtasks = {"пропылесосить", "помыть пол", "помыть кота"};
        Task epic = new Epic(35, subtasks);

        Task meeting = new Meeting(
                341,
                "ооп",
                "учеба",
                "Сегодня после завтрака"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("помыть пол");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void todosSearchSimpleTask() {

        Task simpleTask = new SimpleTask(5, "сходить в магазин");

        String[] subtasks = {"пропылесосить", "помыть пол", "помыть кота"};
        Task epic = new Epic(35, subtasks);

        Task meeting = new Meeting(
                341,
                "ооп",
                "учеба",
                "Сегодня после завтрака"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("сходить в магазин");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchMultipleTasks() {
        Task simpleTask = new SimpleTask(5, "сходить в магазин");

        String[] subtasks = {"пропылесосить", "помыть пол", "помыть кота", "учеба"};
        Task epic = new Epic(35, subtasks);

        Task meeting = new Meeting(
                341,
                "ооп",
                "учеба",
                "Сегодня после завтрака"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("учеба");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchIfNoTasks() {
        Task simpleTask = new SimpleTask(5, "сходить в магазин");

        String[] subtasks = {"пропылесосить", "помыть пол", "помыть кота"};
        Task epic = new Epic(35, subtasks);

        Task meeting = new Meeting(
                341,
                "ооп",
                "учеба",
                "Сегодня после завтрака"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("бездельничать");
        Assertions.assertArrayEquals(expected, actual);

    }
}
