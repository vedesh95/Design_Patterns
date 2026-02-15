package structural;

import java.util.ArrayList;
import java.util.List;

interface Budget { Integer getBudget(); }

class Employee implements Budget{
    private final Integer budget;
    Employee (Integer budget) {this.budget = budget;}
    @Override
    public Integer getBudget() { return this.budget; }
}

class Department implements Budget{
    private List<Employee> employees = new ArrayList<>();
    void addEmployee(Employee employee) {this.employees.add(employee);}
    @Override
    public Integer getBudget() {
        int budget = 0;
        for(Employee e : employees) budget += e.getBudget();
        return budget;
    }
}
public class composite {
    public static void main(String[] args) {
        Employee e = new Employee(10);
        Department d = new Department();
        d.addEmployee(e);

        System.out.println(e.getBudget());
        System.out.println(d.getBudget());
    }
}
