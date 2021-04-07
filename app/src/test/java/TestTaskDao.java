import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import good.morning.controller.TaskDao;
import good.morning.model.Task;

public class TestTaskDao {

    // Arrange
    @Mock
    private ResultSet resultSet;

    
    // Act
    @Test
    void testCreateListFromQuery() throws SQLException {
        try {
            createTestResultSet();
            List<Task> taskList = new ArrayList<>();
            TaskDao.createListFromQuery(taskList, resultSet);
            
            // Assert
            assertNotNull(taskList, "tasks were not added to arraylist");
            
        } catch (SQLException e) {
            
        }
    }
    
    private void createTestResultSet() throws SQLException {
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getInt("id")).thenReturn(1);
        Mockito.when(resultSet.getString("name")).thenReturn("name");
        Mockito.when(resultSet.getString("context")).thenReturn("context");
        Mockito.when(resultSet.getString("priority")).thenReturn("priority");
    }
    
    
}
