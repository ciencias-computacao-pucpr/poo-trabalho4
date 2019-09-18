package cli;

import java.util.Objects;

public class OpcaoCLI {
    private String descricao;
    private Integer opcao;
    private Runnable acao;

    OpcaoCLI(String descricao, Integer opcao, Runnable acao) {
        this.descricao = descricao;
        this.opcao = opcao;
        this.acao = acao;
    }

    @Override
    public String toString() {
        return String.format("(%d): %s", this.opcao, this.descricao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpcaoCLI opcaoCLI = (OpcaoCLI) o;
        return opcao.equals(opcaoCLI.opcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opcao);
    }

    boolean isAcao(int acao) {
        return acao == this.opcao;
    }

    void executa() {
        acao.run();
    }
}
