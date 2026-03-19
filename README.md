```bash
package br.com;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private static final int LIMITE = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> tarefas = new ArrayList<>();
    private static ArrayList<Boolean> concluidas = new ArrayList<>();

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
                    5- Sair
                    Escolha uma opção:  
                    """);
        }
            static void adicionarTarefa() {
                if (tarefas.size() >= LIMITE) {
                    System.out.println("Quantidade Excedida");
                    return;
                }
                System.out.println("Adicione sua tarefa:");
                tarefas.add(scanner.nextLine());
                concluidas.add(false);
                System.out.println("Tarefa Adicionada!");

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
                            System.out.println("Qual tarefa deseja remover? ");
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
                        }
