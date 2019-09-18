package usuario;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.text.MessageFormat.format;

public class Conversa {
    private final String contato;
    private final List<Mensagem> mensagens = new LinkedList<>();

    public Conversa(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        StringBuilder todasMensagens = new StringBuilder();
        for (Mensagem mensagen : mensagens) {
            todasMensagens.append("    ").append(mensagen.toString()).append(lineSeparator());
        }
        return format("Conversa com \"{0}\"\n{1}",
                contato, todasMensagens.toString());
    }

    public void adicionarMensagem(String mensagem, boolean enviada) {
        mensagens.add(new Mensagem(enviada, mensagem));
    }

    public List<Mensagem> getMensagens() {
        return Collections.unmodifiableList(mensagens);
    }
}
