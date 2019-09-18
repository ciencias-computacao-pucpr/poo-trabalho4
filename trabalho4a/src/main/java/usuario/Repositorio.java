package usuario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Repositorio {
    private static Repositorio instancia;
    private final List<Usuario> usuarios;
    private Repositorio() {
        usuarios = new LinkedList<>();
    }

    public Usuario buscar(String nome) {
        return usuarios.stream()
                .filter(u -> isEquals(nome, u.getNome()))
                .findFirst()
                .orElseThrow(UsuarioInexistenteException::new);
    }

    private boolean isEquals(String nome, String u) {
        return cleanLowerCase(nome).equals(cleanLowerCase(u));
    }

    private String cleanLowerCase(String nome) {
        return nome.toLowerCase().trim();
    }


    public void cadastrar(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new UsuarioInvalidoException();
        try {
            buscar(nome);
            throw new UsuarioJaExisteException();
        } catch (UsuarioInexistenteException ex) {
            usuarios.add(new Usuario(nome));
        }
    }

    public static Repositorio instancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    public List<Usuario> todos() {
        return new ArrayList<>(usuarios);
    }


    public static class UsuarioInexistenteException extends IllegalArgumentException {
        public UsuarioInexistenteException() {
            super("usuário não existe");
        }
    }
    public static class UsuarioJaExisteException extends IllegalArgumentException {
        public UsuarioJaExisteException() {
            super("usuário já existe");
        }
    }
    public class UsuarioInvalidoException extends IllegalArgumentException {
        public UsuarioInvalidoException() {
            super("usuário digitado não é valido");
        }
    }
}
