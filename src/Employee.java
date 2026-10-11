public class Employee {
    private String name;
    private String department;
    private Double salary;
    private Integer age;

    public Employee(String name, String department, Double salary, Integer age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }
}
