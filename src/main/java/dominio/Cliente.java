package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Filme> filmesAvaliados;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Cliente() {
        this.filmesAvaliados = new ArrayList();
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmesAvaliados() {
        return filmesAvaliados;
    }

    public void setFilmesAvaliados(List<Filme> filmesAvaliados) {
        this.filmesAvaliados = filmesAvaliados;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", filmesAvaliados=" + filmesAvaliados +'}' + "\n";
    }
    
    
    

}
