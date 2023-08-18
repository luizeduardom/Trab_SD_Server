package meuservidorudp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class MeuServidorUDP {

    private static BaseDeDados bd = null;

    public static void main(String[] args) {
        bd = new BaseDeDados();
        bd.criarMatriz();

        for (int i = 0; i < bd.listaCliente.size(); i++) {
            System.out.println("==========================");
            System.out.println("\nNome: " + bd.listaCliente.get(i).getNome());
            for (int j = 0; j < bd.getListaFilmes().size(); j++) {
                System.out.println(bd.listaCliente.get(i).getFilmesAvaliados().get(j).getTitulo() + "\t" + "nota:" + bd.listaCliente.get(i).getFilmesAvaliados().get(j).getAvaliacao());
            }
            System.out.println("==========================");

        }

        DatagramSocket aSocket = null;

        try {
            aSocket = new DatagramSocket(6789);

            while (true) {

                byte[] buffer = new byte[600];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                byte[] receivedData = request.getData();
                int receivedLenght = request.getLength();

                String receivedString = new String(receivedData, 0, receivedLenght, StandardCharsets.UTF_8);

                byte[] todasMsg = receivedString.getBytes();

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
