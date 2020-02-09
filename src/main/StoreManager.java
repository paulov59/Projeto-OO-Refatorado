package main;

import people.*;
import products.*;

import java.util.*;

public class StoreManager {

    private Scanner input = new Scanner(System.in);
    private boolean isOpen = false;

    private CashierManagement cashier = new CashierManagement();
    private ClientManagement clientManagement = new ClientManagement();
    private EmployeeManagement employeeManagement = new EmployeeManagement();
    private StockManagement stock = new StockManagement();

    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();


    public void run() {
        AuxiliaryMethods.clear();
        System.out.println("Bem vindo ao Store Manager!");
        System.out.println("Selecione uma das opções no menu...");
        int option = menu();
        do {
            if (option == 5) {
                break;
            }
            AuxiliaryMethods.clear();
            option = menu();
        } while (option != 5);

        System.out.println("\nObrigado por usar o Store Manager!\n");

    }

    private int menu() {
        AuxiliaryMethods.mainMenu();

        int option = AuxiliaryMethods.readNumber();

        switch (option) {
            case 1:
                cashierManagement();
                break;
            case 2:
                clientManagement();
                break;
            case 3:
                employeeManagement();
                break;
            case 4:
                stockManagement();
                break;
            default:
                break;
        }
        return option;
    }

    private void cashierManagement() {
        AuxiliaryMethods.clear();
        if (isOpen) {
            AuxiliaryMethods.openCashierMenu();

            int option = AuxiliaryMethods.readNumber();

            AuxiliaryMethods.clear();

            switch (option) {
                case 1:
                    cashier.toSell(products, clients, employees);
                    break;
                case 2:
                    cashier.cancelSale(products);
                    break;
                case 3:
                    cashier.findSale();
                    break;
                case 4:
                    cashier.salesReport();
                    break;
                case 5:
                    isOpen = cashier.closeCashier();
                    break;
                case 6:
                    break;
            }
        } else {
            AuxiliaryMethods.closedCashierMenu();
            int option = AuxiliaryMethods.readNumber();
            AuxiliaryMethods.clear();

            switch (option) {
                case 1:
                    isOpen = cashier.openCashier();
                    break;
                case 2:
                    cashier.salesReport();
                    break;
                case 3:
                    break;
            }
        }
        System.out.println("Pressione ENTER para prosseguir!");
        input.nextLine();
    }

    private void clientManagement() {
        AuxiliaryMethods.clear();
        AuxiliaryMethods.clientMenu();

        int option = AuxiliaryMethods.readNumber();

        AuxiliaryMethods.clear();

        String cpf;
        Client client;

        switch (option) {
            case 1:
                client = clientManagement.addClient();
                clients.add(client);
                break;
            case 2:
                cpf = AuxiliaryMethods.readCpf();

                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    clients.remove(client);
                    System.out.println("Cliente removido!");
                }
                break;
            case 3:
                clientManagement.showAllClients(clients);
                break;
            case 4:
                cpf = AuxiliaryMethods.readCpf();

                client = clientManagement.findClient(cpf, clients);
                if (client == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    System.out.println(client);
                }
                break;
            case 5:
                cpf = AuxiliaryMethods.readCpf();

                Client aux = clientManagement.findClient(cpf, clients);
                if (aux == null) {
                    System.out.println("Cliente não encontrado!");
                } else {
                    client = clientManagement.changeClient(aux);
                    clients.remove(aux);
                    clients.add(client);
                }
                break;
            case 6:
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private void employeeManagement() {
        AuxiliaryMethods.clear();
        AuxiliaryMethods.employeeMenu();

        int option = AuxiliaryMethods.readNumber();
        AuxiliaryMethods.clear();

        String cpf;
        Employee employee;

        switch (option) {
            case 1:
                employee = employeeManagement.addEmployee();
                employees.add(employee);
                break;
            case 2:
                cpf = AuxiliaryMethods.readCpf();

                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    System.out.println("Funcionário removido!");
                    employees.remove(employee);
                }
                break;
            case 3:
                employeeManagement.showAllEmployees(employees);
                break;
            case 4:
                cpf = AuxiliaryMethods.readCpf();

                employee = employeeManagement.findEmployee(cpf, employees);
                if (employee == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    System.out.println(employee);
                }
                break;
            case 5:
                cpf = AuxiliaryMethods.readCpf();

                Employee aux = employeeManagement.findEmployee(cpf, employees);
                if (aux == null) {
                    System.out.println("Funcionário não encontrado!");
                } else {
                    employee = employeeManagement.changeEmployee(aux);
                    employees.remove(aux);
                    employees.add(employee);
                }
                break;

            case 6:
                break;
        }
        System.out.println("Pressioner ENTER para prosseguir.");
        input.nextLine();
    }

    private void stockManagement() {
        AuxiliaryMethods.clear();
        AuxiliaryMethods.stockMenu();

        int option = AuxiliaryMethods.readNumber();
        AuxiliaryMethods.clear();

        Product product;
        int code = 0;

        switch (option) {
            case 1:
                product = stock.addProduct();
                if (product != null) {
                    products.add(product);
                }
                break;
            case 2:
                code = AuxiliaryMethods.readNumber();
                product = stock.findProduct(code, products);
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    products.remove(product);
                    System.out.println("Produto removido!");
                }
                break;
            case 3:
                stock.showAllProducts(products);
                break;
            case 4:
                code = AuxiliaryMethods.readNumber();
                product = stock.findProduct(code, products);
                if (product == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    System.out.println("\t" + product + "\n");
                }
                break;
            case 5:
                code = AuxiliaryMethods.readNumber();
                Product aux = stock.findProduct(code, products);
                if (aux == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    product = stock.changeProduct(aux);
                    products.remove(aux);
                    products.add(product);
                }
                break;
            case 6:
                break;
        }
        System.out.println("Pressione ENTER para prosseguir!");
        input.nextLine();
    }

}