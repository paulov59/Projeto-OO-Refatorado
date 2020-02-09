package main;

import java.util.*;

public class AuxiliaryMethods {

    public static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Gerenciar caixa");
        System.out.println("\t[2] - Gerenciar clientes");
        System.out.println("\t[3] - Gerenciar funcionários");
        System.out.println("\t[4] - Gerenciar estoque");
        System.out.println("\t[5] - Sair");
    }

    public static void openCashierMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Realizar venda");
        System.out.println("\t[2] - Cancelar venda");
        System.out.println("\t[3] - Buscar venda");
        System.out.println("\t[4] - Relatório de vendas");
        System.out.println("\t[5] - Fechar caixa");
        System.out.println("\t[6] - Voltar");
    }

    public static void closedCashierMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Abrir caixa");
        System.out.println("\t[2] - Relatório de vendas");
        System.out.println("\t[3] - Voltar");
    }

    public static void clientMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar cliente");
        System.out.println("\t[2] - Remover cliente");
        System.out.println("\t[3] - Visualizar clientes");
        System.out.println("\t[4] - Buscar cliente");
        System.out.println("\t[5] - Alterar cadastro de cliente");
        System.out.println("\t[6] - Voltar");
    }

    public static void employeeMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar funcionário");
        System.out.println("\t[2] - Remover funcionário");
        System.out.println("\t[3] - Visualizar funcionários");
        System.out.println("\t[4] - Buscar funcionário");
        System.out.println("\t[5] - Alterar cadastro de funcionário");
        System.out.println("\t[6] - Voltar");
    }

    public static void stockMenu() {
        System.out.println("Selecione:");
        System.out.println("\t[1] - Adicionar produto");
        System.out.println("\t[2] - Remover produto");
        System.out.println("\t[3] - Visualizar produtos");
        System.out.println("\t[4] - Buscar produto");
        System.out.println("\t[5] - Alterar produto");
        System.out.println("\t[6] - Voltar");
    }

    public static boolean validateCpf(String cpf) {
        return cpf.matches("[0-9]*");
    }

    public static void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static int readNumber() {
        int option = 0;
        boolean flag = false;
        while (!flag) {
            try {
                option = 0;
                flag = true;
                option = input.nextInt();
                if (option < 1 || option > 5) {
                    throw new Exception("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira uma opção válida");
                input.nextLine();
                flag = false;
            }
        }

        return option;
    }

    public static String readCpf() {
        String cpf = null;
        boolean flag = false;
        while (!flag) {
            try {
                flag = true;
                System.out.print("CPF: ");
                cpf = input.nextLine();
                if (!validateCpf(cpf) || cpf.length() != 11) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira um CPF válido");
                flag = false;
            }
        }

        return cpf;
    }

}
