package br.com;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaIngressos {

    static Scanner scanner = new Scanner(System.in);
    static final int LIMITE = 100;
    static ArrayList<Integer> vendidos = new ArrayList<>();
    static ArrayList<Integer> meia = new ArrayList<>(50);
    static ArrayList<Integer> inteira = new ArrayList<>(50);
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
                    cancelarCompra();
                } else if (opcao == 3) {
                    consultarSituacao();
                } else if (opcao == 4) {
                    mostrarArrecadado();
                } else if (opcao == 5) {
                    System.out.println("Sistema encerrado.");
                } else {
                    System.out.println("Opção inválida.");
                }
            }

            catch (Exception e) {
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
        
        System.out.println("\nDigite: (1) Inteira ou (2) Meia\n");
        int opcao = scanner.nextInt();
        System.out.println("\nDigite: (1) Inteira ou (2) Meia\n");
        int quantidade = scanner.nextInt();

        if (quantidade > (LIMITE - vendidos.size())){
            System.out.println("\nNão possui essa quantidade de ingressos no estoque\n");
        } else {
            if (opcao == 1){
                inteira.add(scanner.nextInt(quantidade));
            } else if (opcao == 2) {
                meia.add(scanner.nextInt(quantidade));
            }
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
}
