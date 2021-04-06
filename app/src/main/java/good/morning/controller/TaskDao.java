package good.morning.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import good.morning.model.Task;
import good.morning.view.Display;

public class TaskDao implements Dao<Task> {
    
    static Connection connection;
    static Logger logger = LogManager.getLogger(TaskDao.class);
    static Scanner userInput = new Scanner(System.in);

    List<Task> headspace = new ArrayList<>();
    List<Task> bottomLine = new ArrayList<>();
    List<Task> sideNote = new ArrayList<>();
    static List<Task> frontAndCenter = new ArrayList<>();
    List<Task> backBurner = new ArrayList<>();
    static List<Task> topOfMind = new ArrayList<>();

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

    public static List<Task> frontAndCenter() throws Exception {

        logger.info("Displaying front and center frame of mind");

        try {
            logger.info("Executing database query");
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE priority LIKE 'FRONT AND CENTER';");
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
            Display.doMenu();
            logger.info("Database query executed successfully");
        } catch (SQLException e) {
            logger.error("Error while executing database query: " + e.getMessage());
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
            for (Task task : headspace) {
                System.out.format("%-5.5s %-10.10s %-15.15s %-50.50s", task.getId(), task.getContext(),
                        task.getPriority(), task.getName());
                System.out.println();
            }
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------");
            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];
            System.out.println("-----------------------------------------------------------------------------");

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println();
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headspace;
    }

    public List<Task> getGhud() {
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
            String header = "ghuD:";
            System.out.println(header);
            System.out.println("");

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.printf("%-5.5s %-10.10s %-20.20s %-100.100s", "id", "frame", "priority", "name");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();

            for (Task task : headspace) {
                System.out.format("%-5.5s %-10.10s %-20.20s %-100.100s", task.getId(),
                        task.getContext(), task.getPriority(), task.getName());
                System.out.println();
            }
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------------------");
            byte[] headerAsByteArray = header.getBytes();
            byte[] footer = new byte[headerAsByteArray.length];
            System.out.println("-------------------------------------------------------------------------------------------------");

            for (int i = 0; i < headerAsByteArray.length; i++)
                footer[i] = headerAsByteArray[headerAsByteArray.length - i - 1];
            System.out.println();
            System.out.println(new String(footer));
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headspace;
    }

    public static List<Task> topOfMind() throws Exception {

        logger.info("Displaying top of mind");

        try {
            logger.info("Executing database query");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE priority LIKE 'TOP OF MIND';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                topOfMind.add(task);
            }

            System.out.println("TOP OF MIND:");
            System.out.println("");

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.printf("%-5.5s %-10.10s %-100.100s", "id", "frame", "name");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();

            for(Task task : topOfMind) {
                System.out.printf("%-5.5s %-10.10s %-100.100s", task.getId(), task.getContext(), task.getName());
                System.out.println();
            }
            Display.thinkMenu();
            logger.info("Database query executed successfully"); 
        } catch (SQLException e) {
            logger.error("Error while executing database query" + e.getMessage());
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

    public static void add() throws Exception {

        logger.info("Adding thought to headspace");

        try {
            logger.info("Executing database insert");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tasks (context, name, priority) VALUES (?, ?, ?)");
            
            System.out.println("What frame of mind are we in?");
            System.out.println();
            String newTaskContext = userInput.nextLine();
            System.out.println();
            System.out.println("What's your Thought?");
            String newTaskName = userInput.nextLine();
            System.out.println();
            System.out.println("How important is this Thought?");
            String newTaskPriority = userInput.nextLine();

            preparedStatement.setString(1, newTaskContext);
            preparedStatement.setString(2, newTaskName);
            preparedStatement.setString(3, newTaskPriority);
            int rowCount = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + rowCount);

            userInput.close();
            Display.thinkMenu();
            logger.info("Database insert executed successfully");
        } catch (SQLException e) {
            logger.error("Error while executing database insert: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void insert() {

        Scanner userInput = new Scanner(System.in);

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO tasks (context, name, priority) VALUES (?, ?, ?)");
            
            System.out.println("What frame of mind are we in?");
            System.out.println();
            String newTaskContext = userInput.nextLine();
            System.out.println();
            System.out.println("What's your Thought?");
            String newTaskName = userInput.nextLine();
            System.out.println();
            System.out.println("How important is this Thought?");
            String newTaskPriority = userInput.nextLine();

            preparedStatement.setString(1, newTaskContext);
            preparedStatement.setString(2, newTaskName);
            preparedStatement.setString(3, newTaskPriority);
            int rowCount = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + rowCount);

            userInput.close();

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