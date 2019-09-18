package cli.opcoes;

import usuario.Repositorio;

public class CLIListarUsuarios implements Runnable{
    @Override
    public void run() {
        System.out.println("Lista da todos os usuários:");
        Repositorio.instancia().todos().forEach(System.out::println);
        System.out.println();
    }
}
