package meuservidorudp;

import dominio.Cliente;
import dominio.Filme;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {

    private ArrayList lista = null;
    List<Cliente> listaCliente = new ArrayList();
    List<Filme> listaFilmes = new ArrayList();

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public ArrayList<String> listar(String id) {
        int aux = Integer.parseInt(id);
        ArrayList<String> retornoFilmes = new ArrayList();
        boolean validacao = true;
        
        for (int i = 0; i < listaFilmes.size(); i++) {
            if (listaCliente.get(aux).getFilmesAvaliados().get(i).getAvaliacao() != 0 ) {
                 retornoFilmes.add(listaCliente.get(aux).getFilmesAvaliados().get(i).getTitulo());
                 retornoFilmes.add(String.valueOf(listaCliente.get(aux).getFilmesAvaliados().get(i).getAvaliacao()));
                 validacao = false;
            }
        }
        if (validacao){
            retornoFilmes.add("-1");
        }
        return retornoFilmes;
    }

    public String validar(String nome) {
        System.out.println(nome);
        System.out.println(listaCliente.size());
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNome().equals(nome)) {
                System.out.println("nome");
                listaCliente.get(i).setId(i);
                return "1";
            }
        }
        return "-1";
    }

    public int adquirirId(String nome) {
        for (Cliente c : listaCliente) {
            if (c.getNome().equals(nome)) {
                return c.getId();
            }
        }
        return -1;
    }

    public BaseDeDados() {
        lista = new ArrayList();
    }

    public void criarMatriz() {
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

        listaFilmes.add(filme0);
        listaFilmes.add(filme1);
        listaFilmes.add(filme2);
        listaFilmes.add(filme3);
        listaFilmes.add(filme4);
        listaFilmes.add(filme5);
        listaFilmes.add(filme6);
        listaFilmes.add(filme7);
        listaFilmes.add(filme8);
        listaFilmes.add(filme9);
        listaFilmes.add(filme10);
        listaFilmes.add(filme11);
        listaFilmes.add(filme12);
        listaFilmes.add(filme13);
        listaFilmes.add(filme14);
        listaFilmes.add(filme15);
        listaFilmes.add(filme16);
        listaFilmes.add(filme17);
        listaFilmes.add(filme18);
        listaFilmes.add(filme19);

        Cliente a = new Cliente();
        Cliente b = new Cliente();
        Cliente c = new Cliente();
        Cliente d = new Cliente();
        Cliente e = new Cliente();
        Cliente f = new Cliente();
        Cliente g = new Cliente();
        Cliente h = new Cliente();
        Cliente i = new Cliente();
        Cliente j = new Cliente();

        listaCliente.add(a);
        listaCliente.get(0).setNome("ASDRUBAL");
        listaCliente.get(0).setFilmesAvaliados(listaFilmes);

        listaCliente.add(b);
        listaCliente.get(1).setNome("BRUNO");
        listaCliente.get(1).setFilmesAvaliados(listaFilmes);

        listaCliente.add(c);
        listaCliente.get(2).setNome("CADU");
        listaCliente.get(2).setFilmesAvaliados(listaFilmes);

        listaCliente.add(d);
        listaCliente.get(3).setNome("BRENO");
        listaCliente.get(3).setFilmesAvaliados(listaFilmes);

        listaCliente.add(e);
        listaCliente.get(4).setNome("FILIPE");
        listaCliente.get(4).setFilmesAvaliados(listaFilmes);

        listaCliente.add(f);
        listaCliente.get(5).setNome("FERNANDA");
        listaCliente.get(5).setFilmesAvaliados(listaFilmes);

        listaCliente.add(g);
        listaCliente.get(6).setNome("JULIO");
        listaCliente.get(6).setFilmesAvaliados(listaFilmes);

        listaCliente.add(h);
        listaCliente.get(7).setNome("PEDRO");
        listaCliente.get(7).setFilmesAvaliados(listaFilmes);

        listaCliente.add(i);
        listaCliente.get(8).setNome("GEOVANA");
        listaCliente.get(8).setFilmesAvaliados(listaFilmes);

        listaCliente.add(j);
        listaCliente.get(9).setNome("FILOMENA");
        listaCliente.get(9).setFilmesAvaliados(listaFilmes);
        

        System.out.println(listaCliente);
    }

    public void insere(String message) {
        lista.add(message.trim());
    }

    public String le() {
        String s = "\n";
        int fim = lista.size();

        for (int pos = 0; pos < fim; pos++) {
            s = s + "[" + (pos + 1) + "]" + (String) lista.get(pos) + "\n";
        }

        return s;
    }

    @Override
    public String toString() {
        return "BaseDeDados{" + "listaCliente=" + listaCliente + ", listaFilmes=" + listaFilmes + '}';
    }

}
