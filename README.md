Sistema de Biblioteca (CLI)

👥 Dupla 1 — Módulo de Livros: Responsáveis (Jordana e Diego)

Entrega:

model/Livro.java

id, titulo, autor, ano, disponivel

service/LivroService.java

cadastrarLivro()

listarLivros()

buscarPorId(int id)

buscarPorTitulo(String termo) (simples)

Branch: feature/livros

---

👥 Dupla 2 — Módulo de Usuários: Responsáveis (Caio e Isaias)

Entrega:

model/Usuario.java

id, nome, cpf ou email

service/UsuarioService.java

cadastrarUsuario()

listarUsuarios()

buscarPorId(int id)

Branch: feature/usuarios

---

👥 Dupla 3 — Módulo de Empréstimos (Regras): Responsáveis (Cauan e Kauan)

Entrega:

model/Emprestimo.java

id, idUsuario, idLivro, dataEmprestimo, dataDevolucao (opcional)

service/EmprestimoService.java

emprestarLivro(idUsuario, idLivro)

não deixa emprestar se livro indisponível

valida usuário e livro existentes

devolverLivro(idEmprestimo)

marca devolução

torna livro disponível

listarEmprestimos()

listarEmprestimosAbertos()

Branch: feature/emprestimos

---

👥 Dupla 4 — Interface (Menu) + Integração Final: Responsáveis (Mikael e Danilo)

Essa dupla é a “cola” do sistema.

Entrega:

menu/MenuPrincipal.java com opções:

Cadastrar livro

Listar livros

Cadastrar usuário

Listar usuários

Emprestar livro

Devolver livro

Listar empréstimos

Sair

Main.java chamando o menu

Integração usando os Services das outras duplas

Branch: feature/menu-integracao

---

Critérios de aceite

Dá pra cadastrar e listar livros/usuários

Empréstimo só acontece se:

usuário existe

livro existe

livro está disponível

Ao devolver, livro volta a ficar disponível

Menu funcionando sem crash (tratando entrada inválida)

