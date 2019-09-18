import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.text.MessageFormat.format;

public class Conversa {
    private final String nomeContato;
    private final List<Mensagem> mensagens = new LinkedList<>();

    public Conversa(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    @Override
    public String toString() {
        StringBuilder todasMensagens = new StringBuilder();
        for (Mensagem mensagen : mensagens) {
            todasMensagens.append("    ").append(mensagen.toString()).append(lineSeparator());
        }
        return format("Conversa com \"{0}\"\n{1}",
                nomeContato, todasMensagens.toString());
    }

    void adicionarMensagem(String mensagem, boolean enviada) {
        mensagens.add(new Mensagem(enviada, mensagem));
    }

    List<Mensagem> getMensagens() {
        return Collections.unmodifiableList(mensagens);
    }

    String getNomeContato() {
        return nomeContato;
    }
}
