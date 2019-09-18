package cli.opcoes;

import cli.CLI;
import usuario.Repositorio;
import usuario.Usuario;

import java.util.Scanner;

public class CLICadastrarUsuario implements Runnable {
    public CLICadastrarUsuario() {

    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Digite 0 para voltar.");
            System.out.print("Digite um nome de usuário: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.nextLine().trim();

            if ("0".equals(nome)) {
                return;
            }

            try {
                Repositorio.instancia().cadastrar(nome);
                System.out.printf("usuário %s cadastrado com sucesso%n", nome);
            } catch (Repositorio.UsuarioJaExisteException | Repositorio.UsuarioInvalidoException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
