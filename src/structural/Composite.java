package structural;

import java.util.ArrayList;
import java.util.List;

interface Salary{
    int getSalary();
}

class Employee implements Salary{
    private int salary;
    Employee(int salary){
        this.salary = salary;
    }
    @Override
    public int getSalary() {
        return salary;
    }
}

class Manager implements Salary{
    private int salary;
    Manager(int salary){
        this.salary = salary;
    }
    @Override
    public int getSalary() {
        return salary;
    }

    public int getNumberofEmployeesManaged(){
        return 10; // Example fixed number
    }
}

class Department implements Salary{
    private List<Salary> members = new ArrayList<>();
    public void addMember(Salary member){
        members.add(member);
    }
    @Override
    public int getSalary() {
        int total = 0;
        for(Salary member : members){
            total += member.getSalary();
        }
        return total;
    }
}

public class Composite {
    public static void main(String[] args) {
        Employee e = new Employee(5000);
        Manager m = new Manager(10000);
        Department d = new Department();
        d.addMember(e);
        d.addMember(m);
        System.out.println("Total Salary: " + d.getSalary());
    }
}
