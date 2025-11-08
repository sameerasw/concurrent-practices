import java.math.BigDecimal;

public class SalaryCal implements Runnable{

    Employee employee;

    public SalaryCal(Employee employee){
        this.employee = employee;
    }

    public double calcSalary(Employee employee){
        return employee.getSalary() * employee.getNoOfWorkingDays();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Calculating salary for " + employee.getName());
        double salary = calcSalary(employee);
        System.out.println("Salary of "  + employee.getName() + " is " + salary);
    }
}
