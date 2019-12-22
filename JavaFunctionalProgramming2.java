import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class JavaFunctionalProgramming2 {
    public static void main(String[] args) {

        Employee p1 = new Employee(35, "Schaumburg", 1);
        Employee p2 = new Employee(35, "Elgin", 2);
        Employee p3 = new Employee(30, "Elgin", 3);
        Employee p4 = new Employee(31, "Schaumburg", 4);

        Map<Integer, List<Employee>> mapList = new ArrayList<Employee>(Arrays.asList(p1, p2, p3, p4)).stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(mapList);
    }

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }
}

class Employee {
    private Integer age;

    private String city;

    private Integer eid;

    public Employee(Integer age, String city, Integer eid) {
        this.age = age;
        this.city = city;
        this.eid = eid;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Integer getEid() {
        return eid;
    }
}