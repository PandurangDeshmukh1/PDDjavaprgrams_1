import java.util.*;

public class EmployeeRecords {
    public static void main(String[] args) {
        Hashtable<Integer, String> employees = new Hashtable<>();
        employees.put(101, "John Doe");
        employees.put(102, "Jane Smith");
        employees.put(103, "Alice Johnson");

        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
