package br.com;

import java.util.Scanner;
import java.util.HashMap;

public class SistemaIngressos {

    static Scanner scanner = new Scanner(System.in);

    static final int LIMITE = 100;
    static int vendidos = 0;
    static int meia = 0;
    static int inteira = 0;

    static double precoInteira = 40.0;
    static double precoMeia = 20.0;
    static double valorArrecadado = 0;

    static HashMap<String, Object[]> compras = new HashMap<>();

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
            System.out.print("Digite seu CPF: ");
            String cpf = scanner.nextLine();


            if (compras.containsKey(cpf)) {
                System.out.println("Já existe compra para esse CPF.");
                return;
            }

            System.out.print("Digite seu Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite sua Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Quantidade de ingressos (Máx. 5): ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            if (qtd <= 0 || qtd > 5) {
                System.out.println("Quantidade inválida!");
                return;
            }

            if (vendidos + qtd > LIMITE) {
                System.out.println("Quantidade indisponível! Disponíveis: " + (LIMITE - vendidos));
                return;
            }

            int tipo = tipoIngresso();

            double valor;

            if (tipo == 1) {
                valor = qtd * precoInteira;
                inteira += qtd;

            } else if (tipo == 2) {
                if (validarMeia(idade)) {
                    valor = qtd * precoMeia;
                    meia += qtd;
                } else{
                    System.out.println("Sem direito à meia.");
                    return;
                }
            }
            else {
                System.out.println("Tipo inválido.");
                return;
            }

            vendidos += qtd;
            valorArrecadado += valor;

            Object[] dados = new Object[5];
            dados[0] = nome;
            dados[1] = idade;
            dados[2] = qtd;
            dados[3] = tipo;
            dados[4] = valor;

            compras.put(cpf, dados);

            System.out.println("Compra realizada para " + nome);
            System.out.println("Valor: R$ " + valor);

        } catch (Exception e) {
            System.out.println("Erro na compra.");
            scanner.nextLine();
        }
    }

    static void cancelarCompra() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        if (!compras.containsKey(cpf)) {
            System.out.println("Compra não encontrada.");
            return;
        }

        Object[] dados = compras.get(cpf);

        int qtd = (int) dados[2];
        int tipo = (int) dados[3];
        double valor = (double) dados[4];

        vendidos -= qtd;
        valorArrecadado -= valor;

        if (tipo == 1) {
            inteira -= qtd;
        } else {
            meia -= qtd;
        }

        compras.remove(cpf);

        System.out.println("Compra cancelada com sucesso!");
    }

    static void consultarSituacao() {
        System.out.println("\n===== SITUAÇÃO =====");
        System.out.println("Vendidos: " + vendidos);
        System.out.println("Inteiras: " + inteira);
        System.out.println("Meias: " + meia);
        System.out.println("Disponíveis: " + (LIMITE - vendidos));
    }

    static void mostrarArrecadado() {
        System.out.println("\nTotal arrecadado: R$ " + valorArrecadado);
    }

    // MÉTODOS AUXILIARES

    static int tipoIngresso() {
        System.out.println("1 - Inteira");
        System.out.println("2 - Meia");
        System.out.print("Tipo de ingresso: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();
        return tipo;
    }

    static boolean validarMeia(int idade) {
        System.out.print("É estudante? (s/n): ");
        String estudante = scanner.nextLine();

        return estudante.equalsIgnoreCase("s") || idade <= 21 || idade >= 60;
    }


}
