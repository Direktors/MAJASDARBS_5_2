import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {

        DBtoDo db = new DBtoDo();

        Scanner scan = new Scanner(System.in);

        System.out.println("Your ToDo list is here: (C - create new task, R - read ALL, P - sort by priority, U - update task status, D - delete: ");
        String user_choise = scan.nextLine();

        switch (user_choise) {
            case "C":
                System.out.println("Create task: ");
                String task_value = scan.nextLine();
                String dueDate_value = scan.nextLine();
                String priority_value = scan.nextLine();
                String status_value = scan.nextLine();

                db.create(task_value, dueDate_value, priority_value, status_value);
                break;

            case "R":
                db.read();
                break;

            case "P":
                db.read();
                break;

            case "U":
                System.out.println("Which task ID to update: ");
                String task_row = scan.nextLine();

                System.out.println("Update value: ");
                String task_update_row = scan.nextLine();

                db.update(task_row, task_update_row);
                break;

            case "D":
                System.out.println("Which task to delete: ");
                String row_id = scan.nextLine();

                db.delete(row_id);

                System.out.println("Task with id: " +row_id+ " deleted...");
        }


    db.create();
//    db.delete();
//    db.update();
//    db.read();

    }
}