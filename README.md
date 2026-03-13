package br.com;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefa {

    private static final int LIMITE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> tarefas = new ArrayList<>();
    private static ArrayList<Boolean> concluidas = new ArrayList<>();

    static void main() {
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
                    System.out.println("\nEncerrando... até mais!\n");
                } else {
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                }

            } catch (Exception e) {
                System.out.println("\nErro: digite apenas NÚMEROS.\n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    static void adicionarTarefa(){

        if (tarefas.size() >= LIMITE){
            System.out.println("\nLimite de tarefas atingido!\n");
            return;
        }

        System.out.println("\nDigite sua tarefa: \n");
        tarefas.add(scanner.nextLine());
        concluidas.add(false);
        System.out.println("\nTarefa Adicionada!\n");
    }

    static void listarTarefas() {
        if (validarListaVazia()) return;

        System.out.println("\n----- LISTA DE TAREFAS -----\n");

        for (int posicao = 0; posicao < tarefas.size(); posicao++) {
            System.out.println((posicao+1) + " - " + tarefas.get(posicao) + " - " + selecionarConcluida(concluidas.get(posicao)));
        }
    }

    static void marcarConcluida() {
        if (validarListaVazia())
            return;

        listarTarefas();

        System.out.println("\nQual tarefa deseja concluir? \n");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        if (posicao > 0 || posicao < tarefas.size()) {
            concluidas.set(posicao-1,true);
            System.out.println("\nTarefa concluída!\n");
        }
        else {
            System.out.println("\nTarefa inválida.\n");
        }
    }

    static void removerTarefa(){
        if (validarListaVazia()) return;

        listarTarefas();

        System.out.println("\nQual tarefa deseja remover? \n");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        if (posicao <= tarefas.size()){
            tarefas.remove(posicao-1);
            concluidas.remove(posicao-1);
            System.out.println("\nTarefa removida!\n");
        } else {
            System.out.println("\nTarefa inválida.\n");
        }

    }

    // MÉTODOS AUXILIARES

    static boolean validarListaVazia(){
        if (tarefas.isEmpty()){
            System.out.println("\nNunhuma tarefa adicionada!\n");
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
