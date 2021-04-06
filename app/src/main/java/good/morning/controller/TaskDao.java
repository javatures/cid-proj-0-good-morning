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

import good.morning.App;
import good.morning.model.Task;
import good.morning.view.Display;

public class TaskDao implements Dao<Task> {
    
    static Connection connection;
    static Logger logger = LogManager.getLogger(TaskDao.class);
    static Scanner userInput = new Scanner(System.in);

    static List<Task> headspace = new ArrayList<>();
    static List<Task> bottomLine = new ArrayList<>();
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
            frontAndCenter.clear();
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
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Headspace: Front And Center");
            System.out.println("---");
            System.out.println("This is what you're working on- your infinite sticky note.");
            System.out.println("Brief to-do list, reminder, bolts of lightning from brainstorms...");
            System.out.println("---");
            System.out.println();
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "", "frame of", "", "");
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "id", "mind", "location", "thought");
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("*************************************************************************************************");
            System.out.println();
            System.out.println();

            // frontAndCenter.forEach(task -> System.out.println(task.getName()));
            for (Task task : frontAndCenter) {
                if (task.getPriority().equals("FRONT AND CENTER")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }
            
            System.out.println();
            System.out.println();
            System.out.println("*************************************************************************************************");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            // Display.doMenu();
            logger.info("Database query executed successfully");
        } catch (SQLException e) {
            logger.error("Error while executing database query: " + e.getMessage());
            e.printStackTrace();
        }
        return frontAndCenter;
    }

    public static List<Task> bottomLine() {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE priority LIKE 'BOTTOM LINE' ORDER BY context DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                bottomLine.add(task);
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Headspace: Bottom Line");
            System.out.println("---");
            System.out.println("This is what it ALL amounts to- where we transcend into the Heartspace.");
            System.out.println("A question to ask yourself quotidiously...");
            System.out.println("---");
            System.out.println();
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "", "frame of", "", "");
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "id", "mind", "location", "thought");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();

            for (Task task : bottomLine) {
                if (task.getPriority().equals("BOTTOM LINE")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bottomLine;
    }

    public static List<Task> headspace() {

        logger.info("Dispalying headspace");

        try {
            logger.info("Executing database query");
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
            logger.info("Database query executed successfully");
        } catch (SQLException e) {
            logger.error("Error while executing database query");
            e.printStackTrace();
        }
        return headspace;
    }

    public static List<Task> ghud() throws Exception {

        logger.info("Displaying ghud frame of mind");

        try {
            logger.info("Executing database query");
            headspace.clear();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks ORDER BY priority DESC, context DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                headspace.add(task);
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("ghuD: Headspace");
            System.out.println("---");
            System.out.println("This is what is on your mind- the only thing worth managing.");
            System.out.println("Organize your thoughts, clear your head, repeat...");
            System.out.println("---");
            System.out.println();
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "", "frame of", "", "");
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "id", "mind", "location", "thought");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            
            for (Task task : headspace) {
                if (task.getPriority().equals("TOP OF MIND")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("*************************************************************************************************");
            System.out.println();
            System.out.println();

            for (Task task : headspace) {
                if (task.getPriority().equals("FRONT AND CENTER")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("*************************************************************************************************");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();

            for (Task task : headspace) {
                if (task.getPriority().equals("BOTTOM LINE")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            // Display.doMenu();
            logger.info("Database query executed successfully");
        } catch (SQLException e) {
            logger.info("Error while executing database query");
            e.printStackTrace();
        }
        return headspace;
    }

    public static List<Task> topOfMind() throws Exception {

        logger.info("Displaying top of mind");

        try {
            logger.info("Executing database query");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE priority LIKE 'TOP OF MIND' ORDER BY context DESC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                String priority = resultSet.getString("priority");

                Task task = new Task(id, context, name, priority);
                topOfMind.add(task);
            }

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Headspace: Top Of Mind");
            System.out.println("---");
            System.out.println("This is what you hope to remember today- your random access memory.");
            System.out.println("Daily habits, important dates, put the toilet seat down...");
            System.out.println("---");
            System.out.println();
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "", "frame of", "", "");
            System.out.println();
            System.out.printf("%-5.5s %-10.10s %-30.30s %-100.100s", "id", "mind", "location", "thought");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();

            for (Task task : topOfMind) {
                if (task.getPriority().equals("TOP OF MIND")) {
                    System.out.format("%-5.5s %-10.10s %-30.30s %-100.100s", task.getId(), task.getContext(), task.getPriority(), task.getName());
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            // Display.thinkMenuLogic();
            logger.info("Database query executed successfully"); 
        } catch (SQLException e) {
            logger.error("Error while executing database query" + e.getMessage());
            e.printStackTrace();
        }
        return topOfMind;
    }

    public static void rethink() throws Exception {

        logger.info("Rethinking a thought");

        try {

            logger.info("Executing database update");

            System.out.println("What's the ID of the thought to rethink?");
            System.out.println();
            int id = userInput.nextInt();
            userInput.nextLine();


            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE tasks SET name = ? WHERE id = " + id + ";");

            // Scanner userInput = new Scanner(System.in);

            System.out.println("Rethinking record: " + id);
            System.out.println("What is the new thought?");
            String newThought = userInput.nextLine();
            preparedStatement.setString(1, newThought);
            int rowCount = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + rowCount);

            // userInput.close();
            logger.info("Database update executed sucessfully");
            Display.thinkMenu();
        } catch (SQLException e) {
            logger.error("Error while executing database update: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void forget() {

        logger.info("Forgetting a thought");

        try {
            logger.info("Executing database query");

            TaskDao.ghud();

            System.out.println("What's the ID of the thought to forget?");
            System.out.println();
            int id = userInput.nextInt();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tasks WHERE id = " + id + ";");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                userInput.nextLine();
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
                String yesNoConfirm;
                yesNoConfirm = userInput.nextLine();
                switch (yesNoConfirm) {
                case "Yes":
                    logger.info("Executing database update");
                    PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM tasks WHERE id = " + id + ";");
                    preparedStatement2.executeUpdate();
                    System.out.println("Forgotten!");
                    break;
                case "No":
                    System.out.println("Okay, let's forget forgetting!");
                    break;
                default:
                    System.out.println("Huh? Hmm... let's forget forgetting!");
                    break;
                }
                // userInput.close();
                logger.info("Database update executed successfully");
            }
            Display.thinkMenu();
        } catch (Exception e) {
            logger.error("Error while executing database update: " + e.getMessage());
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
            System.out.println("[1] LOVE: Things you wanna do!");
            System.out.println("[2] LIVE: Things you gotta do!");
            System.out.println("[3] LEARN: Things you do to grow!");
            System.out.println("[4] EARN: Things you have!");
            System.out.println("[5] ALL: All the things!");

            int frameOfMindSelection = userInput.nextInt();
            String newTaskContext = null;
            userInput.nextLine();
            switch(frameOfMindSelection) {
                case 1:
                    newTaskContext = "LOVE";
                    break;
                case 2:
                    newTaskContext = "LIVE";
                    break;
                case 3:
                    newTaskContext = "LEARN";
                    break;
                case 4:
                    newTaskContext = "EARN";
                    break;
                case 5:
                    newTaskContext = "ALL";
                    break;
                default:
                    System.out.println("Hmm...");
                    Display.thinkMenu();
                    break;
            }

            System.out.println();
            System.out.println("Where should we keep this Thought?");
            System.out.println();
            System.out.println("[1] TOP OF MIND");
            System.out.println("[2] FRONT AND CENTER");
            System.out.println("[3] BOTTOM LINE");
            System.out.println();
            int prioritySelection = userInput.nextInt();
            String newTaskPriority = null;
            userInput.nextLine();
            switch(prioritySelection) {
                case 1:
                    newTaskPriority = "TOP OF MIND";
                    break;
                case 2:
                    newTaskPriority = "FRONT AND CENTER";
                    break;
                case 3:
                    newTaskPriority = "BOTTOM LINE";
                    break;
                default:
                    System.out.println();
                    System.out.println("Hmm...");
                    System.out.println();
                    Display.thinkMenu();
                    break;
            }

            System.out.println();
            System.out.println("What's your Thought?");
            System.out.println();
            String newTaskName = userInput.nextLine();

            preparedStatement.setString(1, newTaskContext);
            preparedStatement.setString(2, newTaskName);
            preparedStatement.setString(3, newTaskPriority);
            int rowCount = preparedStatement.executeUpdate();

            System.out.println();
            System.out.println("Affected rows: " + rowCount);
            System.out.println();

            // userInput.close();
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

            // userInput.close();

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

    public static void exit() {
        App.on = false;
    }

}