package Question;

import java.util.ArrayList;
import java.util.Collections;

public class Comparable {
    static class Employee implements java.lang.Comparable<Employee> {
        int id;
        String name;
        int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }
        public int getSalary() {
            return salary;
        }
        public int getId() {
            return id;
        }
        @Override
        public int compareTo(Employee e){
           return this.id - e.id;
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
    public static void main(String args[]){
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(2, "Hema", 5000000));
        list.add(new Employee(1,"Sony", 10000000));

        Collections.sort(list);
        System.out.println(list);
    }
}
