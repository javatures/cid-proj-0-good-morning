package good.morning.model;

/**
 * !!!The Task class is set to be renamed as Thought!!!
 * 
 * The Thought class manages headspace 
 * 
 * !!!Content below is deprecated!!!
 * The Task class manages task management.
 * 
 */

public class Task {
    private int id;
    private String context;
    private String name;
    private String priority;

    public Task(int id, String context, String name) {
        this.id = id;
        this.context = context;
        this.name = name;
    }
    
    public Task(int id, String context, String name, String priority) {
        this.id = id;
        this.context = context;
        this.name = name;
        this.priority = priority;
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
    
    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return "Task [context=" + context + ", id=" + id + ", name=" + name + ", priority=" + priority + "]";
    }

}
