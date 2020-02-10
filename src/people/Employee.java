package people;

public class Employee {
    protected int employeeId;
    protected int sales;
    protected double salary;
    protected String name;
    protected String cpf;

    public Employee (String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        sales = 0;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSales() {
        this.sales++;
    }

    public void removeSale(){
        this.sales--;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n\tCPF: %s\n\tIdentidade profissional: %d\n\tSalário: R$ %.2f\n\tVendas: %d\n",
                this.name, this.cpf, this.employeeId, this.salary, this.sales);
    }

}