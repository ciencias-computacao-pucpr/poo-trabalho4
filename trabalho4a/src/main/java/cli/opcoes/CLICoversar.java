package cli.opcoes;

import usuario.Repositorio;
import usuario.Usuario;

import java.util.Scanner;

public class CLICoversar implements Runnable {
    @Override
    public void run() {
        if (!existemUsuariosCadastrados()) {
            System.out.println("Não existem usuário para conversar");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes dos usuários, ou 0 para voltar");
        System.out.print("Nome do usuário remetente: ");

        Usuario rementente = perguntarRemetente(scanner);
        if (rementente == null) return;

        Usuario destino = perguntarDestino(scanner);
        if (destino == null) return;

        iniciarConversa(scanner, rementente, destino);
    }

    private boolean existemUsuariosCadastrados() {
        return !Repositorio.instancia().todos().isEmpty();
    }

    private void iniciarConversa(Scanner scanner, Usuario rementente, Usuario destino) {
        System.out.println("Digite uma mensagem ou mensagem em branco para finalizar");
        String mensagem;

        System.out.print(">> ");
        while (!(mensagem = scanner.nextLine().trim()).isEmpty()) {
            System.out.print(">> ");
            rementente.enviarMensagem(destino, mensagem);
        }
    }

    private Usuario perguntarDestino(Scanner scanner) {
        Usuario destino = null;
        while (destino == null) {
            try {
                System.out.print("Nome do usuário destino: ");
                String usuario = scanner.nextLine().trim();
                if ("0".equals(usuario)) return null;
                destino = Repositorio.instancia().buscar(usuario);
            } catch (Repositorio.UsuarioInexistenteException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return destino;
    }

    private Usuario perguntarRemetente(Scanner scanner) {
        Usuario rementente = null;
        while (rementente == null) {
            try {
                String usuario = scanner.nextLine().trim();
                if ("0".equals(usuario)) return null;
                rementente = Repositorio.instancia().buscar(usuario);
            } catch (Repositorio.UsuarioInexistenteException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rementente;
    }
}
