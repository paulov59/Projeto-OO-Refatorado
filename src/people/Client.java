package people;

public class Client {
    protected int sales;
    protected String name;
    protected String cpf;
    protected String address;

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        this.sales = 0;
    }

    public void setSales() {
        this.sales++;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return String.format("Nome: %s\n\tCPF: %s\n\tEndereço: %s\n\tCompras realizadas: %d\n",
                this.name, this.cpf, this.address, this.sales);
    }
}