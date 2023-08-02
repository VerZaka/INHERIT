package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void searchReqestSimpleTaskPositive() {
        Task task = new SimpleTask(2, "задача1");

        Boolean expected = true;
        Boolean actual = task.matches("задача1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchReqestSimpleTaskNegative() {
        Task task = new SimpleTask(2, "задача1");

        Boolean expected = false;
        Boolean actual = task.matches("задача0");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchReqestEpicPositive() {
        String[] subtasks = {"задача1", "задача2", "задача3"};
        Task task = new Epic(3, subtasks);

        Boolean expected = true;
        Boolean actual = task.matches("задача2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchReqestEpicNegative() {
        String[] subtasks = {"задача1", "задача2", "задача3"};
        Task task = new Epic(3, subtasks);

        Boolean expected = false;
        Boolean actual = task.matches("задача007");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchReqestMeetingPositive() {
        Task task = new Meeting(45, "тема1", "проект34", "20.05.2023 21:30");

        Boolean expected = true;
        Boolean actual = task.matches("проект34");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchReqestMeetingNegative() {
        Task task = new Meeting(45, "тема1", "проект34", "20.05.2023 21:30");

        Boolean expected = false;
        Boolean actual = task.matches("задача007");

        Assertions.assertEquals(expected, actual);
    }


}
