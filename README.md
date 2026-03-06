package br.com;

import java.util.Scanner;

public class GerenciadorTarefa {

    private static final int LIMITE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static String[] tarefas = new String[LIMITE];
    private static boolean[] concluidas = new boolean[LIMITE];
    private static int quantidade = 0;

    static void main() {
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

    static void adicionarTarefa(){

        if (quantidade >= tarefas.length){
            System.out.println("Limite de tarefas atingido!");
            return;
        }

        System.out.println("Digite sua tarefa: ");
        tarefas[quantidade] = scanner.nextLine();
        quantidade++;
        System.out.println("Tarefa Adicionada!");
    }

    static void listarTarefas(){
        if (validarListaVazia()) return;

        for (int i = 0; i < quantidade; i++) {

            if (tarefas[i] != null && i == 0) {
                System.out.println((i) + " - " + tarefas[i] + " - " + selecionarConcluida(concluidas[i]));
            } else if (tarefas[i] != null) {
                System.out.println((i - 1) + " - " + tarefas[i] + " - " + selecionarConcluida(concluidas[i]));
            }
        }
    }

    static void marcarConcluida() {
        if (validarListaVazia())
            return;

        listarTarefas();

        System.out.println("Qual tarefa deseja concluir? ");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        if (posicao >= 0 || posicao < quantidade) {
            concluidas[posicao - 1] = true;
            System.out.println("Tarefa concluída!");
        }
        else {
            System.out.println("Tarefa inválida.");
        }
    }

    static void removerTarefa(){
        if (validarListaVazia()) return;

        listarTarefas();
        System.out.println("Qual tarefa deseja remover? ");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        tarefas[posicao -1] = null;
        System.out.println("Tarefa removida!");
    }

    // MÉTODOS AUXILIARES

    static boolean validarListaVazia(){
        if (quantidade == 0){
            System.out.println("Nunhuma tarefa adicionada!");
            return true;
        }
        return false;
    }

    static String selecionarConcluida(boolean concluido){
        if (concluido)
           return "Concluida";
        else
            return "Pendente";
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
}
