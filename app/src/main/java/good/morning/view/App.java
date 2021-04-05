/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package good.morning.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import good.morning.controller.TaskDao;

public class App {    

    static InputStream inputStream;

    public static void main(String[] args) throws SQLException {
        System.out.println("***");    
        System.out.println("Program starting...");
        System.out.println("");

        Properties properties = new Properties();
        try {
            inputStream = new FileInputStream("database.properties");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            properties.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
            TaskDao taskDao = new TaskDao(connection);

            taskDao.headspace();
            // taskDao.bottomLine();
            // taskDao.sideNote();
            // taskDao.frontAndCenter();
            // taskDao.backBurner();
            // taskDao.topOfMind();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("");
        System.out.println("Program ending...");
        System.out.println("***");
    }
}
