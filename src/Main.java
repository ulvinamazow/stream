import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ulvi", "IT", 2500.0, 22));
        employees.add(new Employee("Murad", "HR", 1800.0, 32));
        employees.add(new Employee("Ali", "Finance", 3200.0, 35));
        employees.add(new Employee("Aysel", "IT", 2200.0, 29));
        employees.add(new Employee("Nigar", "HR", 2800.0, 41));

        printWorker(employees);
        squareOfNumber();
        sortingByLength();
        groupingWorkerByDepartment(employees);

    }
    // 1.
    public static void squareOfNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result1 = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n  * n)
                .toList();

        System.out.println(result1);
    }

    // 2.
    public static void sortingByLength() {
        List<String> names = List.of(
                "Ulvi",
                "Murad",
                "Anar",
                "Murad",
                "Natiq",
                "Nigar"
        );

        List<String> result = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
    }

    // 3.
    public static void printWorker(List<Employee> employees ) {
        // en yuksek maas
        Optional<Employee> employee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        employee.ifPresent(System.out::println);

        // Orta maas
        double avarage = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Orta maas: "+ avarage);

        // umumi maas
        double total = employees.stream()
                .filter(e -> e.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Umumi maas: "+ total);
    }


    public static void groupingWorkerByDepartment(List<Employee> employees) {
        //
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        grouped.forEach((department, list ) -> System.out.println(
                department + " -> " + list));

        //
        Map<String, Long> counts = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        counts.forEach((department, count) -> System.out.println(
                department + " -> " + count
        ));

        //
        Map<String, Double> avarages = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(
                        Employee::getSalary)
                        ));

        avarages.forEach((department, avarage) -> System.out.println(department + " -> " + avarage));
    }

    public static void toCombineEmails(List<String> emails) {
        Long count = emails.stream()
                .map(String::toLowerCase)
                .filter(email -> email.endsWith("@gmail.com"))
                .distinct()
                .count();

        System.out.println("Unikal Gmail sayi: " + count);
    }

    public static void printStudents(List<String> students) {
        students.stream()
                .map(name -> "Telebe: " + name)
                .forEach(System.out::println);
    }

    public static void printNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n > 10)
                .toList();
        System.out.println(numbers);
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
