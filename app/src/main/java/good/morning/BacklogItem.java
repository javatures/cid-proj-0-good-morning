package good.morning;

import java.util.Arrays;

public class BacklogItem {
    private int previousHash;
    private String[] tasks;

    private int backlogItemHash;

    public BacklogItem(int previousHash, String[] tasks) {
        this.previousHash = previousHash;
        this.tasks = tasks;

        Object[] contents = {Arrays.hashCode(tasks), previousHash};
        this.backlogItemHash = Arrays.hashCode(contents);
    }


    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTasks() {
        return tasks;
    }

    public int getBacklogItemHash() {
        return backlogItemHash;
    }
}


