import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaFunctionalProgramming2 {
    public static void main(String[] args) {

        Employee p1 = new Employee(35, "Schaumburg", 1, 100000);
        Employee p2 = new Employee(35, "Elgin", 2, 200000);
        Employee p3 = new Employee(30, "Elgin", 3, 350000);
        Employee p4 = new Employee(31, "Schaumburg", 4, 175000);

        Map<String, List<Employee>> mapList = Arrays.asList(p1, p2, p3, p4).stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(mapList);

        Map<String, List<Integer>> mapList2 = Arrays.asList(p1, p2, p3, p4).stream().collect(
                Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getAge, Collectors.toList())));
        System.out.println(mapList2);

        Map<String, Double> mapList3 = Arrays.asList(p1, p2, p3, p4).stream().collect(
                Collectors.groupingBy(Employee::getCity, Collectors.averagingInt(Employee::getAge)));
        System.out.println(mapList3);

        Map<String, Integer> mapList4 = Arrays.asList(p1, p2, p3, p4).stream().collect(
                Collectors.groupingBy(Employee::getCity, Collectors.reducing(0, Employee::getSalary, Integer::sum)));
        System.out.println(mapList4);
    }

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }
}

class Employee {
    private Integer age;

    private String city;

    private Integer eid;

    private Integer salary;

    public Employee(Integer age, String city, Integer eid, Integer salary) {
        this.age = age;
        this.city = city;
        this.eid = eid;
        this.salary = salary;
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

    public Integer getSalary() {
        return salary;
    }
}