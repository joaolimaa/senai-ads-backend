package br.com;


import java.util.Scanner;


public class GerenciadorDeTarefas {


   private static final int LIMITE = 10;
   private static Scanner scanner = new Scanner(System.in);
   private static String[] tarefas = new String[LIMITE];
   private static boolean[] concluidas = new boolean[LIMITE];
   private static int quantidade = 0;




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
               1 - Adicionar tarefa
               2 - Listar tarefas
               3 - Marcar tarefa como concluída
               4 - Remover tarefa
               5 - Sair
               Escolha uma opção:
               """);
   }


   static void adicionarTarefa() {
       if (quantidade > LIMITE) {
           System.out.println("O limite de tarefas foi atingido");
           scanner.nextLine();
           return;
       }


       System.out.println("Digite a sua tarefa: ");
       String tarefa = scanner.nextLine().trim();
       tarefas[quantidade] = tarefa;
       quantidade++;
   }


   static void listarTarefas() {
       if (listaVazia()) return;
       System.out.println("\nTarefas salvas:");
       for (int i = 0; i < quantidade; i++) {
               System.out.println((i + 1) + "° tarefa: " + tarefas[i] + " " + tarefaFinalizada(concluidas[i]));
       }
   }


   static void marcarConcluida() {
       System.out.println("Qual tarefa deseja marcar como concluída?");
       try {
           int posicao = scanner.nextInt();


           if (posicao <1 || posicao > quantidade){
               System.out.println("Essa tarefa é inexistente!!");
               return;
           }


           if (concluidas[posicao - 1] == true) {
               System.out.println("Tarefa já estava marcada como concluída!");
               return;
           }


           concluidas[posicao - 1] = true;
           System.out.println("Tarefa marcada como concluída!");


       } catch (Exception e) {
           System.out.println("Digite apenas números!");
           scanner.nextLine();
       }
   }


   static void removerTarefa(){
       if (listaVazia()) return;
       System.out.println("Qual tarefa deseja remover?");
       int posicao = scanner.nextInt();


       if (posicao <1 || posicao > quantidade){
           System.out.println("Essa tarefa é inexistente!!");
           return;
       }


       for (int i = posicao - 1; i < quantidade - 1; i++) {
           tarefas[i] = tarefas[i + 1];
           concluidas[i] = concluidas[i + 1];
       }


       quantidade--;
       System.out.println("Tarefa removida com sucesso!");
   }


   static String tarefaFinalizada(boolean finalizado){
       if (finalizado == true){
           return "[OK]";
       }
       return "[]";
   }


   static boolean listaVazia(){
       if (quantidade == 0){
           System.out.println("Lista vazia!");
           return true;
       }
       return false;
   }
}
