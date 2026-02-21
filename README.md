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
                    estatisticas();
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
        System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Marcar tarefa como concluída");
        System.out.println("4 - Remover tarefa");
        System.out.println("5 - Ver estatísticas");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }
