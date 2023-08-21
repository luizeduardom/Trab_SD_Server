package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Filme> filmes = new ArrayList();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente(String nome, int id) {
        this.filmes = setarFilmes();
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public final List<Filme> setarFilmes() {
        Filme filme0 = new Filme("Cronicas de Narnia");
        Filme filme1 = new Filme("Bambi");
        Filme filme2 = new Filme("Ursinho Pool");
        Filme filme3 = new Filme("Barbie");
        Filme filme4 = new Filme("Stuart Liro");
        Filme filme5 = new Filme("Liro stiti");
        Filme filme6 = new Filme("Mickey mousse");
        Filme filme7 = new Filme("Pequeno sereio");
        Filme filme8 = new Filme("Nata goiaba");
        Filme filme9 = new Filme("Floquis");
        Filme filme10 = new Filme("Pluto");
        Filme filme11 = new Filme("Pateta");
        Filme filme12 = new Filme("Scooby doo");
        Filme filme13 = new Filme("Monstros SA");
        Filme filme14 = new Filme("Kick buttowisk");
        Filme filme15 = new Filme("Atirador");
        Filme filme16 = new Filme("Justiceiro");
        Filme filme17 = new Filme("Flash");
        Filme filme18 = new Filme("Homem de ferro");
        Filme filme19 = new Filme("Planeta dos macacos");

        filmes.add(filme0);
        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);
        filmes.add(filme5);
        filmes.add(filme6);
        filmes.add(filme7);
        filmes.add(filme8);
        filmes.add(filme9);
        filmes.add(filme10);
        filmes.add(filme11);
        filmes.add(filme12);
        filmes.add(filme13);
        filmes.add(filme14);
        filmes.add(filme15);
        filmes.add(filme16);
        filmes.add(filme17);
        filmes.add(filme18);
        filmes.add(filme19);

        return filmes;

    }

}
