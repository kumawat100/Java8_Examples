import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamExamples {
	public static void main(String[] args) {
		List<Employee> employeesList=getListOfEmployees();
		
		/*
		 * Given a list of employees, you need to find all the employees whose age is greater than 30 and print the employee names.(Java 8 APIs only)
		 */
		employeesList.stream()
		.filter(e -> e.getAge()>30)
		.map(Employee::getName)
		.forEach(System.out::println);
		
		/*
		 * Given the list of employees, find the count of employees with age greater than 25?
		 */
		long count = employeesList.stream()
		.filter(e -> e.getAge() > 25)
		.count();
		
		System.out.println(count);
		
		/*
		 * Given the list of employees, find the employee whose name is John.
		 */
		employeesList.stream()
		//.map(e -> e.getName())
		.filter(e -> e.getName().equals("John"))
		.forEach(System.out::println);
		
		/*
		 * Given a list of employees, You need to find highest age of employee?
		 */
		OptionalInt maxAge = employeesList.stream()
				.mapToInt(e -> e.getAge())
				.max();
		System.out.println(maxAge.getAsInt());
		
		/*
		 * Given a list of employees, you need sort employee list by age? Use java 8 APIs only
		 */
		employeesList.stream()
		.sorted((e1, e2) -> e1.getAge() - e2.getAge())
		.forEach(System.out::println);
		
		/*
		 * Given the list of Employees, you need to join the all employee names with ","?
		 */
		List<String> empNames = employeesList.stream()
		.map(e -> e.getName())
		.collect(Collectors.toList());
		
		System.out.println(String.join(",", empNames));
		
		/*
		 * Given the list of employees, you need to group them by name
		 */
		Map<String, List<Employee>> empNamesGroupedByName = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getName));
		empNamesGroupedByName.forEach((name, listByName) -> System.out.println(name + "-->" + listByName));
	}
	
	public static List<Employee> getListOfEmployees() {
		 
        List<Employee> listOfEmployees = new ArrayList<>();
 
        Employee e1 = new Employee("Mohan", 24,Arrays.asList("Newyork","Banglore"));
        Employee e2 = new Employee("John", 27,Arrays.asList("Paris","London"));
        Employee e3 = new Employee("Vaibhav", 32,Arrays.asList("Pune","Seattle"));
        Employee e4 = new Employee("Amit", 22,Arrays.asList("Chennai","Hyderabad"));
 
        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
        //listOfEmployees.add(new Employee("Amit", 25,Arrays.asList("C","H")));
        
        return listOfEmployees;
    }
}
