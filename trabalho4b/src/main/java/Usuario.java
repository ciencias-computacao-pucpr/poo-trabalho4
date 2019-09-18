import java.util.*;

public class Usuario {
    private final String nome;
    private final List<Conversa> conversas = new ArrayList<>();

    Usuario(String nome) {
        this.nome = nome;
    }

    private Conversa iniciarConversa(String nomeContato) {
        Conversa conversa = procurarCoversaPorNome(nomeContato);
        if (conversa != null)
            return conversa;

        return criarNovaConversa(nomeContato);
    }

    private Conversa criarNovaConversa(String nomeContato) {
        Usuario usuario = Inicio.procurarUsuarioCadastrado(nomeContato);
        if (usuario == null)
            return null;

        Conversa conversa = new Conversa(nomeContato);
        this.conversas.add(conversa);
        usuario.conversas.add(new Conversa(nome));
        return conversa;
    }

    private Conversa procurarCoversaPorNome(String nomeContato) {
        for (Conversa conversa : conversas) {
            if (conversa.getNomeContato().equals(nomeContato))
                return conversa;
        }

        return null;
    }

    void enviarMensagem(String nomeContato, String mensagem) {
        Usuario usuario = Inicio.procurarUsuarioCadastrado(nomeContato);

        if (usuario == null)
            return;

        Conversa conversa = iniciarConversa(nomeContato);
        conversa.adicionarMensagem(mensagem, Mensagem.ENVIADA);

        usuario.receberMensagem(nome, mensagem);
    }

    private void receberMensagem(String nomeContato, String mensagem) {
        Usuario usuario = Inicio.procurarUsuarioCadastrado(nomeContato);

        if (usuario == null)
            return;

        Conversa conversa = iniciarConversa(nomeContato);
        if (conversa == null)
            return;

        conversa.adicionarMensagem(mensagem, Mensagem.RECEBIDA);
    }

    List<Conversa> getConversas() {
        return Collections.unmodifiableList(conversas);
    }

    @Override
    public String toString() {
        return nome;
    }

    String getNome() {
        return nome;
    }


}
