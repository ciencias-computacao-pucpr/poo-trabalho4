package usuario;

import java.util.*;

public class Usuario {
    private final String nome;
    private final Map<String , Conversa> conversas = new HashMap<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void iniciarConversa(String nomeContato) {
        if (conversas.containsKey(nomeContato))
            return;
        Usuario contato = Repositorio.instancia().buscar(nomeContato);

        this.conversas.put(nomeContato, new Conversa(nomeContato));
        contato.conversas.put(nome, new Conversa(nome));
    }

    public void enviarMensagem(Usuario contato, String mensagem) {
        iniciarConversa(contato.nome);
        Conversa conversa = conversas.get(contato.nome);
        conversa.adicionarMensagem(mensagem, Mensagem.ENVIADA);
        contato.receberMensagem(nome, mensagem);

    }

    public void receberMensagem(String nomeContato, String mensagem) {
        Conversa conversa = conversas.get(nomeContato);
        if (conversa != null) {
            conversa.adicionarMensagem(mensagem, Mensagem.RECEBIDA);
        }
    }

    public Map<String, Conversa> getConversas() {
        return Collections.unmodifiableMap(conversas);
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }


}
