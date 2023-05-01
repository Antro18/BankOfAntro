public class PersonManager extends SalaryManager {
    public SalaryManager salaryManager;
    public SalaryManager[] salaryManagers;
    public  PersonManager(SalaryManager[] salaryManagers) {
        for(SalaryManager salaryManager1: salaryManagers) {
            this.salaryManagers = salaryManagers;
        }
    }
    public PersonManager() {
    }


    public double Salary(double salary) {
        salaryManager.Salary(salary);
     return salary;
    }


}
