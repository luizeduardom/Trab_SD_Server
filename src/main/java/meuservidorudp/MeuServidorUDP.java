package meuservidorudp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MeuServidorUDP {

    private static BaseDeDados bd = null;
    private static byte[] todasMsg;
    private static int flag = 0;

    public static void main(String[] args) {
        bd = new BaseDeDados();
        bd.criarMatriz();

        for (int i = 0; i < bd.listaCliente.size(); i++) {
            System.out.println("==========================");
            System.out.println("\n" + bd.listaCliente.get(i).getNome());
            for (int j = 0; j < bd.listaCliente.get(i).getFilmes().size(); j++) {
                System.out.println(bd.listaCliente.get(i).getFilmes().get(j).getTitulo() + "\t" + "\nNota: " + bd.listaCliente.get(i).getFilmes().get(j).getAvaliacao() + "\n");
            }
            System.out.println("==========================");

        }

        DatagramSocket aSocket = null;

        try {
            aSocket = new DatagramSocket(6789);

            while (true) {

                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request); //Servidor esta em modo espera, esperando a requisição de algum cliente

                String[] respostaConvertida;

                byte[] receivedData = request.getData();//Servidor recebendo a mensagem
                int receivedLenght = request.getLength();//Servidor recebendo o tamanho da mensagem

                String receivedString = new String(receivedData, 0, receivedLenght, StandardCharsets.UTF_8); //É guardado a mensagem e o tamanho dela em uma string

                respostaConvertida = receivedString.split(";"); //A mensagem e o tamanho dela é guardado no vetor de Strings "respostaConvertida"
                String retorno = "";
                ArrayList<String> retornoListagem = null;
                StringBuilder str = new StringBuilder();

                switch (respostaConvertida[1]) {
                    case "validarNome":
                        retorno = bd.validarNome(respostaConvertida[0]);
                        break;
                    case "avaliar":
                        retorno = bd.avaliar(respostaConvertida[2], respostaConvertida[3]);
                        break;
                    case "pegarId":
                        retorno = bd.pegarId();
                        break;
                    case "listar":
                        retornoListagem = bd.listar(respostaConvertida[0]);
                        System.out.println(retornoListagem.toString());
                        flag = 1;
                        break;
                }
                if (flag == 1) {
                    if (!retornoListagem.isEmpty()) {
                        for (String lista : retornoListagem) {
                            str.append(lista);
                            str.append(" ");
                        }
                        String retornavel = str.toString();
                        todasMsg = retornavel.getBytes();
                        flag = 0;
                    } else {
                        retorno = "-1";
                        System.out.println(retorno);
                        todasMsg = retorno.getBytes();
                    }
                } else {
                    todasMsg = retorno.getBytes();
                }

                DatagramPacket reply = new DatagramPacket(todasMsg, todasMsg.length, request.getAddress(), request.getPort());

                aSocket.send(reply);

            }

        } catch (SocketException zz) {
            System.out.println("SERVIDOR - Socket: " + zz.getMessage());
        } catch (IOException zz) {
            System.out.println("SERVIDOR: Input Output: " + zz.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
