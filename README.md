package br.com;

import java.util.Arrays;
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
//                    removerTarefa();
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
        if (listaVazia()) return;

        for (int i = 0; i < quantidade; i++)
            System.out.println((i+1) + " - "+ tarefas[i]);

    }

    static void marcarConcluida(){
        if (listaVazia()) return;
        listarTarefas();

        System.out.println("Qual tarefa deseja concluir? ");

        int posicaoTarefaConcluida = scanner.nextInt();
        scanner.nextLine();



        concluidas[posicaoTarefaConcluida] = true;





    }

    static boolean listaVazia(){
        if (quantidade == 0){
            System.out.println("Nunhuma tarefa adicionada!");
            return true;
        }
        return false;
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

