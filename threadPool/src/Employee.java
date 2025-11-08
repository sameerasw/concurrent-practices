public class Employee {
    private String name;
    private int id;
    private double salary;
    private int noOfWorkingDays;
    
    public Employee(String name, int id, double salary, int noOfWorkingDays) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.noOfWorkingDays = noOfWorkingDays;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public int getNoOfWorkingDays() {
        return noOfWorkingDays;
    }
    
    public void setNoOfWorkingDays(int noOfWorkingDays) {
        this.noOfWorkingDays = noOfWorkingDays;
    }
    
}
