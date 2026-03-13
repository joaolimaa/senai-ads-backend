package br.com;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private static final int LIMITE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static String[] tarefas = new String[LIMITE];
    private static boolean[] concluidas = new boolean[LIMITE];
    private static int quantidade = 0;

    public static void main(String[] args) {
        int opcoes = 0;

        while (opcoes != 6) {
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
//                    estatisticas();
                } else if (opcoes == 6) {
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
        System.out.println("""
                
                ===== GERENCIADOR DE TAREFAS =====
                1- Adicionar tarefa 
                2- Listar tarefas
                3- Marcar como concluídas
                4- Remover tarefa
                5- Estatísticas
                6- Sair
                Escolha uma opção:  
                """);
    }

    static void adicionarTarefa() {
        for (int i = 0; i < 1; i++) {

            if (quantidade < LIMITE) {

                System.out.print("Digite a sua tarefa: ");
                tarefas[quantidade] = scanner.nextLine();
                concluidas[quantidade] = false;
                quantidade++;

                System.out.println("Tarefa adicionada com êxito!");
            } else {

                System.out.println("Você atingiu o limite de tarefas.");
            }

        }
    }

    static void listarTarefas() {

        if (quantidade == 0) {
            System.out.println("Você não tem tarefas cadastradas!");
            return;
        }
        for (int i = 0; i < quantidade; i++) {
            System.out.println(i + 1 + " - " + tarefas[i] + " - " + verificarStatus(i));
        }
    }

    static String verificarStatus(int posicao) {
        if (concluidas[posicao] == true) {
            return "Tarefa concluída";
        } else {
            return "Tarefa pendente";
        }
    }

    static void marcarConcluida() {

        if (quantidade == 0) {
            System.out.println("Não há tarefas, então não tem como marcar como concluida!!!");
        }
        listarTarefas();
        System.out.print("Digite o número da tarefa concluida: ");
        int numero = scanner.nextInt();

        concluidas[numero - 1] = true;

        System.out.println("Tarefa concluida!");
    }

    static void removerTarefa() {
        if (quantidade == 0) {
            System.out.println("Não há tarefas para remover!");
            return;
        }

        listarTarefas();
        System.out.print("Digite a tarefa que deseja remover!");
        int numero = scanner.nextInt();

        int indice = numero - 1;

        if (indice < 0 || indice >= quantidade) {
            System.out.println("Número inválido!");
            return;
        }
        for (int i = indice; i < quantidade - 1; i++){

            tarefas[i] = tarefas[i + 1];
            concluidas[i] = concluidas[i + 1];
        }
        quantidade--;

        System.out.println("Tarefa removida!");

    }

}

