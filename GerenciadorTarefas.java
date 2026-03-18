package br.com;

import java.util.Scanner;

public class GerenciadorTarefa {

    private static final int LIMITE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static String[] tarefas = new String[LIMITE];
    private static boolean[] concluidas = new boolean[LIMITE];
    private static int quantidade = 0;

    public static void main(String[] args) {

        int opcoes = 0;

        while (opcoes != 5) {
            exibirMenu();

            try {
                opcoes = scanner.nextInt();
                scanner.nextLine();

                if (opcoes == 1) {
                    adicionarTarefa();
                } else if (opcoes == 2) {
                    listarTarefas();
                } else if (opcoes == 3) {
                    marcarConcluida();
                } else if (opcoes == 4) {
                    removerTarefa();
                } else if (opcoes == 5) {
                    System.out.println("Encerrando... até mais!");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Erro: digite apenas NÚMEROS.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    static void exibirMenu() {
        System.out.println("===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1- Adicionar tarefa");
        System.out.println("2- Listar tarefas");
        System.out.println("3- Marcar como concluídas");
        System.out.println("4- Remover tarefa");
        System.out.println("5- Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void adicionarTarefa() {
        if (quantidade > LIMITE) {
            System.out.println("Limite de tarefas atingido!");
            return;
        }

        System.out.print("Digite o nome da tarefa: ");
        String tarefa = scanner.nextLine();

        tarefas[quantidade] = tarefa;
        concluidas[quantidade] = false;

        quantidade++;
        System.out.println("Tarefa adicionada com sucesso!");
    }

    static void listarTarefas() {
        if (quantidade == 0) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("===== LISTA DE TAREFAS =====");

        for (int i = 0; i < quantidade; i++) {
            String status;

            if (concluidas[i]) {
                status = "[Concluída]";
            } else {
                status = "[Pendente]";
            }

            System.out.println((i + 1) + " - " + tarefas[i] + " " + status);
        }
    }

    static void marcarConcluida() {

        if (quantidade == 0) {
            System.out.println("Não há tarefas para marcar como concluída.");
            return;
        }

        listarTarefas();

        System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        int indice = numero - 1;

        if (indice < 0 || indice >= quantidade) {
            System.out.println("Número inválido.");
            return;
        }

        concluidas[indice] = true;

        System.out.println("Tarefa marcada como concluída!");
    }

    static void removerTarefa() {

        if (quantidade == 0) {
            System.out.println("Não há tarefas para remover.");
            return;
        }

        listarTarefas();

        System.out.print("Digite o número da tarefa que deseja remover: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        int indice = numero - 1;

        if (indice < 0 || indice > quantidade) {
            System.out.println("Número inválido.");
            return;
        }

        for (int i = indice; i < quantidade - 1; i++) {
            tarefas[i] = tarefas[i + 1];
            concluidas[i] = concluidas[i + 1];
        }

        quantidade--;

        System.out.println("Tarefa removida com sucesso!");
    }
}
