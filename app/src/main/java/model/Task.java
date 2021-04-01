package model;

public class Task {
    private int id;
    private String context;
    private String name;

    public Task(int id, String context, String name) {
        this.id = id;
        this.context = context;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
