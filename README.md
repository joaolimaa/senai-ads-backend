package br.com;

import java.util.Scanner;
public class SistemaIngressos {
    static Scanner scanner = new Scanner(System.in);
    static final int LIMITE = 100;
    static int vendidos = 0;
    static int meia = 0;
    static int inteira = 0;
    static double precoInteira = 40.0;
    static double precoMeia = 20.0;
    static double valorArrecadado = 0;
    static void main() {
        int opcao = 0;
        while (opcao != 5) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1) {
                    comprarIngressos();
                } else if (opcao == 2) {
                    //cancelarCompra();
                } else if (opcao == 3) {
                    //consultarSituacao();
                } else if (opcao == 4) {
                    //mostrarArrecadado();
                } else if (opcao == 5) {
                    System.out.println("Sistema encerrado.");
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: digite apenas números.");
                scanner.nextLine();
            }
        }
    }
    static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Comprar ingressos");
        System.out.println("2 - Cancelar compra");
        System.out.println("3 - Consultar situação");
        System.out.println("4 - Valor arrecadado");
        System.out.println("5 - Sair");
        System.out.print("Escolha: ");
    }
    static void comprarIngressos() {

        try {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Quantidade de ingressos: (Máx. 5)");
            int qtd = scanner.nextInt();

            if (qtd <= 0 || qtd > 5) {
                System.out.println("Quantidade de inválida! (Máx. 5)");
                return;
            }

            System.out.println("1 - Inteira");
            System.out.println("2 - Meia");

            int tipo = scanner.nextInt();
            scanner.nextLine();

            double valor = 0;
            String tipoIngresso = "";


            if (tipo == 1) {
                valor = qtd * precoInteira;
                tipoIngresso = "Inteira";
                inteira += qtd;

            } else if (tipo == 2) {
                System.out.print("É estudante? (s/n): ");
                String estudante = scanner.nextLine();

                if (estudante.equalsIgnoreCase("s") || idade <= 21 || idade >= 60) {

                    valor = qtd * precoMeia;
                    tipoIngresso = "Meia";
                    meia += qtd;

                } else {

                    System.out.println("Cliente não possui direito à meia entrada.");
                    return;
                }

                }


        } catch (Exception e) {
            System.out.println("Erro na compra.");
        }
    }

    static void cancelarCompra() {
        // implementar
    }
    static void consultarSituacao() {
        // implementar
    }
    static void mostrarArrecadado() {
        // implementar
    }

    // ==== MÉTODOS AUXILIARES ====


}
