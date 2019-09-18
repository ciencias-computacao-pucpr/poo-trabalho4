package usuario;

public class Mensagem {
    private boolean enviada;
    private String textoDaMensagem;

    public static final boolean ENVIADA = true;
    public static final boolean RECEBIDA = false;

    public Mensagem(boolean enviada, String textoDaMensagem) {
        this.enviada = enviada;
        this.textoDaMensagem = textoDaMensagem;
    }


    @Override
    public String toString() {
        if (enviada) {
            return "ENVIADA: " + textoDaMensagem;
        }

        return "RECEBIDA: " + textoDaMensagem;
    }
}
