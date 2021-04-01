package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements Dao<Task> {
    Connection connection;

    List<Task> taskList = new ArrayList<>();

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Task task) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tasks (context, name) VALUES (?, ?)");
            preparedStatement.setString(1, task.getContext());
            preparedStatement.setString(2, task.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<Task> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String context = resultSet.getString("context");
                String name = resultSet.getString("name");
                
                System.out.println("");
                System.out.println("Syso within WHILE loop:");
                System.out.println("");
                System.out.println("ID: " + id);
                System.out.println("CONTEXT: " + context);
                System.out.println("NAME: " + name);
                System.out.println("");

                Task task = new Task(id, context, name);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public void update(Task entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Task entity) {
        // TODO Auto-generated method stub
        
    }
}