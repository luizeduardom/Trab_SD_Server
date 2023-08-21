package dominio;

public class Filme {

    private String titulo;
    private int avaliacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Filme(String titulo) {
        this.titulo = titulo;
        this.avaliacao = 0;
    }

    @Override
    public String toString() {
        return titulo;
    }

}
