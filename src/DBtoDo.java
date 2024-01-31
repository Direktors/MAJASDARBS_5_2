import java.sql.*;

public class DBtoDo {


    private String DB = "jdbc:mysql://localhost:3306/java_toDo";
    private String USER = "root";
    private String PASS = "3343";

    //crud - create(insert), read(select), update, delete

    //create
    public void create(String task_value, String dueDate_value, String priority_value, String status_value) throws SQLException {
        Connection conn = DriverManager.getConnection(DB,USER,PASS);
        Statement stmt = conn.createStatement();



        String insert = "INSERT INTO tasks (task, dueDate, priority, status) VALUES ('" + task_value + "','"  + dueDate_value + "','"  + priority_value + "','"  + status_value + "')";

        stmt.executeUpdate(insert);

    }

    // delete
    public void delete(String row_id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String delete = "DELETE FROM tasks WHERE id = '"+ row_id +"'";

        stmt.executeUpdate(delete);
    }

    // update
    public void update(String row_id, String row_value) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String update = "UPDATE tasks SET status = '" + row_value + "' WHERE id = '"+ row_id +"'";

        stmt.executeUpdate(update);
    }

    // read - select
    public void read() throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String select = "SELECT * FROM TASKS";

        ResultSet resultSet = stmt.executeQuery(select);

        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id"));
            System.out.println("task: " + resultSet.getString("task"));
            System.out.println(" ");
        }


    }


}
