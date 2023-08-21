package meuservidorudp;

import dominio.Cliente;
import dominio.Filme;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {

    private ArrayList lista = null;
    List<Cliente> listaCliente = new ArrayList();

    private int idClienteAtual;

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public int buscarClienteParecido(int idConvertido) {
        int tamanho = listaCliente.get(0).getFilmes().size();
        double valorTotal = 0;
        double menorValor = 9999;
        int idCliente = 0;
        int j = 0;
        for (int i = 0; i < listaCliente.size(); i++) {
            valorTotal = 0;
            if (i != idConvertido) {
                for (j = 0; j < tamanho; j++) {
                    int primeiroIndice = listaCliente.get(idConvertido).getFilmes().get(j).getAvaliacao();
                    int segundoIndice = listaCliente.get(i).getFilmes().get(j).getAvaliacao();
                    double valorParcial = primeiroIndice - segundoIndice;
                    valorTotal += Math.pow(valorParcial, 2);
                }
                
                System.out.println("O menor valor é: " + menorValor);
                if (valorTotal <= menorValor && valorTotal != 0) {
                    idCliente = i;
                    menorValor = valorTotal;
                }
            }

        }

        if (menorValor == 9999) {
            return -1;
        } else {
            System.out.println("To printando no id: " + idCliente);
            return idCliente;

        }

    }

    public String recomendar(String id) {
        int idConvertido = Integer.parseInt(id.trim());
        int idClienteParecido;
        idClienteParecido = buscarClienteParecido(idConvertido);
        System.out.println("O cliente parecido é do id: " + idClienteParecido);
                
        int tamanho = listaCliente.get(0).getFilmes().size();
        if (idClienteParecido == -1) {
            return "-1";
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (listaCliente.get(idConvertido).getFilmes().get(i).getAvaliacao() == 0 && listaCliente.get(idClienteParecido).getFilmes().get(i).getAvaliacao() != 0
                        && listaCliente.get(idClienteParecido).getFilmes().get(i).getAvaliacao() != 1) {
                    return listaCliente.get(idClienteParecido).getFilmes().get(i).getTitulo();
                }
            }
            return "-1";
        }
    }

    public String validarNome(String nome) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNome().equals(nome)) {
                idClienteAtual = i;
                return "1";
            }
        }
        return "-1";

    }

    public String avaliar(String indiceFilme, String avaliacao) {
        int indiceConvertido = Integer.parseInt(indiceFilme);
        int avaliacaoConvertida = Integer.parseInt(avaliacao);

        listaCliente.get(idClienteAtual).getFilmes().get(indiceConvertido).setAvaliacao(avaliacaoConvertida);

        return "1";
    }

    public String pegarId() {
        return String.valueOf(idClienteAtual);
    }

    public ArrayList<String> listar(String id) {
        int idConvertido = Integer.parseInt(id.trim());
        ArrayList<String> filmesAvaliados = new ArrayList();
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(idConvertido).getFilmes().get(i).getAvaliacao() != 0) {
                filmesAvaliados.add(listaCliente.get(idConvertido).getFilmes().get(i).getTitulo());
                filmesAvaliados.add(String.valueOf(listaCliente.get(idConvertido).getFilmes().get(i).getAvaliacao()));
            }
        }
        return filmesAvaliados;
    }

    public BaseDeDados() {
        lista = new ArrayList();
    }

    public void criarMatriz() {

        Cliente a = new Cliente("ASDRUBAL", 0);
        Cliente b = new Cliente("BRUNO", 1);
        Cliente c = new Cliente("CADU", 2);
        Cliente d = new Cliente("BRENO", 3);
        Cliente e = new Cliente("FILIPE", 4);
        Cliente f = new Cliente("FERNANDA", 5);
        Cliente g = new Cliente("JULIO", 6);
        Cliente h = new Cliente("PEDRO", 7);
        Cliente i = new Cliente("GEOVANA", 8);
        Cliente j = new Cliente("FILOMENA", 9);

        listaCliente.add(a);
        listaCliente.add(b);
        listaCliente.add(c);
        listaCliente.add(d);
        listaCliente.add(e);
        listaCliente.add(f);
        listaCliente.add(g);
        listaCliente.add(h);
        listaCliente.add(i);
        listaCliente.add(j);

    }

}
