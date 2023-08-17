package meuservidorudp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MeuServidorUDP {

    private static BaseDeDados bd = null;

    public static void main(String[] args) {
        bd = new BaseDeDados();
        bd.criarMatriz();
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


                String retorno = "";
                System.out.println(receivedString);
                String[] mensagem = receivedString.split(".");
                System.out.println(mensagem[0]);
                System.out.println(mensagem[1]);
                switch (mensagem[1]) {
                    case "mostrar":
                        retorno = bd.listar(mensagem[0]);
                        break;
                    case "validar":
                        retorno = bd.validar(mensagem[0]);

                }

                byte[] todasMsg = retorno.getBytes();

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
