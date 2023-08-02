package ru.netology.inherit;
public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {            //метод поискового запроса
        if (title.contains(query)) {
            return true;
        }
        return false;
    }
}
