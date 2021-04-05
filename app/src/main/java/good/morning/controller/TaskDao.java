package good.morning.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import good.morning.model.Task;

public class TaskDao implements Dao<Task> {
    Connection connection;

    List<Task> headspace = new ArrayList<>();
    List<Task> bottomLine = new ArrayList<>();
    List<Task> sideNote = new ArrayList<>();
    List<Task> frontAndCenter = new ArrayList<>();
    List<Task> backBurner = new ArrayList<>();
    List<Task> topOfMind = new ArrayList<>();

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    public List<Task> sideNote() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE context LIKE 'LEARN';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                sideNote.add(task);
            }
            String header = "SIDE NOTE:";
            System.out.println(header);
            System.out.println("");

            sideNote.forEach(task -> System.out.println(task.getName()));
            System.out.println("");

            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sideNote;
    }

    public List<Task> backBurner() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE context LIKE 'EARN';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                backBurner.add(task);
            }
            String header = "BACK BURNER:";
            System.out.println(header);
            System.out.println("");

            backBurner.forEach(task -> System.out.println(task.getName()));
            System.out.println("");

            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return backBurner;
    }

    public List<Task> frontAndCenter() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE context LIKE 'LIVE';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                frontAndCenter.add(task);
            }
            String header = "FRONT AND CENTER:";
            System.out.println(header);
            System.out.println("");

            frontAndCenter.forEach(task -> System.out.println(task.getName()));
            System.out.println("");

            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return frontAndCenter;
    }

    public List<Task> bottomLine() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE context LIKE 'LOVE';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                bottomLine.add(task);
            }
            String header = "BOTTOM LINE:";
            System.out.println(header);
            System.out.println("");

            bottomLine.forEach(task -> System.out.println(task.getName()));
            System.out.println("");

            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bottomLine;
    }

    public List<Task> headspace() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                headspace.add(task);
            }
            String header = "HEADSPACE:";
            System.out.println(header);
            System.out.println("");

            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%-5.5s %-10.10s %-15.15s %-50.50s", "id", "context", "priority", "name");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println();
            for(Task task : headspace) {
                System.out.format("%-5.5s %-10.10s %-15.15s %-50.50s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                System.out.println();
            }
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------");
            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];
            System.out.println("-----------------------------------------------------------------------------");

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headspace;
    }

    public List<Task> topOfMind() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE priority LIKE 'TOP OF MIND';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                topOfMind.add(task);
            }
            String header = "TOP OF MIND:";
            System.out.println(header);
            System.out.println("");

            topOfMind.forEach(task -> System.out.println(task.getName()));
            System.out.println("");

            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topOfMind;
    }

    public void rethink(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tasks SET name = ? WHERE id = " + id + ";");

            Scanner userInput = new Scanner(System.in);

            System.out.println("Rethinking record: " + id);
            System.out.println("What is the new thought?");
            String newThought = userInput.nextLine();
            preparedStatement.setString(1, newThought);
            int rowCount = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + rowCount);

            userInput.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void forget(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE id = " + id + ";");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);

                System.out.println("Are you sure you don't need to remember this?");
                System.out.println(task.getId());
                System.out.println(task.getContext());
                System.out.println(task.getName());
                System.out.println(task.getPriority());

                System.out.println("");
                System.out.println("Yes/No");
                Scanner userInput = new Scanner(System.in);
                switch (userInput.toString()) {
                case "Yes":
                    PreparedStatement preparedStatement2 = connection
                            .prepareStatement("DELETE FROM tasks WHERE id = " + id + ";");
                    preparedStatement2.executeUpdate();
                    System.out.println("Forgotten!");
                    break;
                case "No":
                    System.out.println("Okay, let's forget forgetting!");
                    break;
                default:
                    System.out.println("Huh? Hmm... let's forget forgetting!");
                }
                userInput.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Task task) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO tasks (context, name) VALUES (?, ?, ?)");
            preparedStatement.setString(1, task.getContext());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getPriority());
            int rowCount = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + rowCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Task task) {
    }

    @Override
    public void delete(Task entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Task> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
}