package cli.opcoes;

import usuario.Mensagem;
import usuario.Repositorio;
import usuario.Usuario;

public class CLIListarMensagens implements Runnable {

    @Override
    public void run() {
        Repositorio.instancia().todos().forEach(this::listarMensagemDoUsuario);
    }

    private void listarMensagemDoUsuario(Usuario usuario) {
        usuario.getConversas().forEach((nomeContato, conversa) -> {
            System.out.printf("%s mensagem com %s%n", usuario, nomeContato);
            conversa.getMensagens().stream().map(Mensagem::toString).forEach(System.out::println);
        });
    }

}
