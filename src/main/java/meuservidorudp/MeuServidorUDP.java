package meuservidorudp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MeuServidorUDP {

    private static BaseDeDados bd = null;
    private static String retorno = "";
    private static ArrayList<String> retornoLista;
    private static int flag = 0;

    public static void main(String[] args) {
        bd = new BaseDeDados();
        bd.criarMatriz();
        bd.listaCliente.get(0).getFilmesAvaliados().get(0).setAvaliacao(1);
        bd.listaCliente.get(0).getFilmesAvaliados().get(1).setAvaliacao(3);
        bd.listaCliente.get(0).getFilmesAvaliados().get(3).setAvaliacao(2);
        bd.listaCliente.get(0).getFilmesAvaliados().get(6).setAvaliacao(1);
        DatagramSocket aSocket = null;
        String[] mensagem;

        try {
            aSocket = new DatagramSocket(6789);

            while (true) {

                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                byte[] receivedData = request.getData();
                int receivedLenght = request.getLength();

                String receivedString = new String(receivedData, 0, receivedLenght, StandardCharsets.UTF_8);

                System.out.println(receivedString);
                mensagem = receivedString.split(";");
                System.out.println(mensagem[0]);
                System.out.println(mensagem[1]);
                switch (mensagem[1]) {
                    case "listar":
                        retornoLista = bd.listar(mensagem[0]);
                        flag = 1;
                        break;
                    case "validar":
                        retorno = bd.validar(mensagem[0]);
                        break;

                }

                System.out.println("retornei: " + retorno);
                byte[] todasMsg;
                if (flag == 1) {
                    String responseString = String.join(",", retornoLista);
                    System.out.println(responseString);
                    todasMsg = responseString.getBytes();
                    flag = 0;

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
