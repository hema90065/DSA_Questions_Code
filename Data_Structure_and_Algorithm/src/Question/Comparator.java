package Question;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Comparator {

    public abstract int compareTo(Employee e1, Employee e2);

     static class Employee{
        int id;
        String name;
        int salary;

        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }

        public int getSalary() {
            return salary;
        }
        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
//    static class sortByNameThenId implements Comparator<Employee>{
//        @Override
//        public int compareTo(Employee e1 , Employee e2){
//            if (e1.name.equals(e2.name)){
//                return e1.id - e2.id;
//            } else {
//                return e1.name.compareTo(e2.name);
//            }
//        }
//    }
    public static void main(String args[]) {
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "hema", 50000000));
        emp.add(new Employee(2, "sony", 10000000));
        emp.add(new Employee(5, "manisha", 20000000));
        emp.add(new Employee(7, "kabita", 60000000));

        System.out.println("Sort by id");
        Collections.sort(emp, java.util.Comparator.comparing(Employee::getId));
        for (Employee employee : emp) {
            System.out.println(employee);
        }

        System.out.println();

        System.out.println("Sort by name");
        Collections.sort(emp, java.util.Comparator.comparing(Employee::getName));
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }
}
