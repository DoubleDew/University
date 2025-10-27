// import java.util.*;
// import org.junit.jupiter.api.Test;
// import com.example.Employee;
// import com.example.Main;

// import static org.junit.jupiter.api.Assertions.*;

// public class MainTest {
//     @Test
//     public void testPopulateEmployees() {
//         ArrayList<Employee> employees = new ArrayList<>();

//         assertEquals(10, employees.size(), "Employee list should contain 10 entries.");

//         assertEquals("Alice", employees.get(0).getName(), "First employee should be Bruce.");
//         assertEquals("Peter", employees.get(9).getName(), "Last employee should be Peter.");
//     }

//     @Test
//     public void testFindEmployeeByName_true(){
//         ArrayList<Employee> employees = new ArrayList<>();
//         Map<String, Employee> employeeMap = new HashMap<>();
//         for (Employee emp : employees) {
//             employeeMap.put(emp.getName().toLowerCase(), emp);
//         }

//         String searchName = "Bruce";
//         Employee foundEmployee = employeeMap.get(searchName.toLowerCase());
//         assertTrue(foundEmployee.contains("Employee found"), "The result should indicate the employee was found.");
//         assertTrue(foundEmployee.contains("Bruce"), "The result should contain the employee's name.");
//     }    

//     @Test
//     void testFindEmployeeByName_EmployeeDoesNotExist() {

//         ArrayList<Employee> employees = Main.populateEmployeeList();
//         Map<String, Employee> employeeMap = new HashMap<>();
//         for (Employee employee : employees) {
//             employeeMap.put(employee.getName().toLowerCase(), employee);
//         }

//         String result = Main.findEmployeeByName(employeeMap, "Zara");

//         assertEquals("Employee not found.", result, "The result should indicate the employee was not found.");
//     }
       
// }
