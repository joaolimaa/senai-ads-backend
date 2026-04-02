Atividade 1 - Gerenciador de tarefas (Concluída com sucesso)

Atividade 2 - Sistema de Gerenciamento para vendas de ingresso

package br.com;

import java.util.Scanner; import java.util.HashMap;

public class SistemaIngressos {
    private String teste;

    static Scanner scanner = new Scanner(System.in);

    static final int LIMITE = 100;

    static int vendidos = 0;
    static int ingressosMeiaVendidos = 0;
    static int ingressosInteirosVendidos = 0;

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
        System.out.println("""
        ==== MENU =====
        1 - Comprar ingressos
        2 - Cancelar compra
        3 - Consultar situação
        4 - Valor arrecadado
        5 - Sair
    
        Escolha:
        """);
    }

    static void comprarIngressos() {
        try {
            System.out.print("Digite seu CPF: ");
            String cpf = scanner.nextLine();

            System.out.println(compras);

            if (compras.containsKey(cpf)) {
                System.out.println("Já existe compra para esse CPF.");
                return;
            }

            System.out.print("Digite seu Nome: ");
            String nome = scanner.nextLine();

            int idade = validarInteiro("Digite sua Idade: ");
            int qtd =  validarInteiro("Digite a quantidade de ingressos que você deseja comprar: ");
                    
            if (qtd <= 0 || qtd > 5) {
                System.out.println("Quantidade inválida!");
                return;
            }
            
            int ingressosDisponiveis = vendidos + qtd;

            if (ingressosDisponiveis > LIMITE) {
                System.out.println("Quantidade indisponível! Disponíveis: " + (LIMITE - vendidos));
                return;
            }

            int tipoIngresso = tipoIngresso();

            double valor;

            if (tipoIngresso == 1) {
                valor = qtd * precoInteira;
                ingressosInteirosVendidos += qtd;

            } else if (tipoIngresso == 2) {
                if (validarMeia(idade)) {
                    valor = qtd * precoMeia;
                    ingressosMeiaVendidos += qtd;
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
            dados[3] = tipoIngresso;
            dados[4] = valor;

            compras.put(cpf, dados);

            System.out.println("Compra realizada para " + nome);
            System.out.println("Valor: R$ " + valor);

        } catch (Exception e) {
            System.out.println("Erro na compra.");
            scanner.nextLine();
        }
    }

    static int validarInteiro(String mensagem) {
        try {
            System.out.println(mensagem);
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (Exception e) {
            throw new NumberFormatException("Valor inválido. Digite um número inteiro.");
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
            ingressosInteirosVendidos -= qtd;
        } else {
            ingressosMeiaVendidos -= qtd;
        }

        compras.remove(cpf);

        System.out.println("Compra cancelada com sucesso!");
    }

    static void consultarSituacao() {
        System.out.println("\n===== SITUAÇÃO =====");
        System.out.println("Vendidos: " + vendidos);
        System.out.println("Inteiras: " + ingressosInteirosVendidos);
        System.out.println("Meias: " + ingressosMeiaVendidos);
        System.out.println("Disponíveis: " + (LIMITE - vendidos));
    }

    static void mostrarArrecadado() {
        System.out.println("\nTotal arrecadado: R$ " + valorArrecadado);
    }

    static int tipoIngresso() {
        System.out.println("1 - Inteira");
        System.out.println("2 - Meia");
        return validarInteiro("Digite o tipo do ingresso (1 ou 2): ");
    }

    static boolean validarMeia(int idade) {
        System.out.print("É estudante? (s/n): ");
        String estudante = scanner.nextLine();

        return estudante.equalsIgnoreCase("s") || idade <= 21 || idade >= 60;
    }
}
