/*
    Autor: Claudia Palacios
    Date: 02-2024
    Notas:
    -En este ejemplo el servidor TCP espera a que el cliente se conecte, luego recibe un mensaje del cliente, lo convierte a mayúsculas y lo envía de vuelta al cliente.
    -El cliente se conecta al servidor, envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    -Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    -Revisar que el puerto 9876 esté disponible y que no esté bloqueado o este en uso por otro programa.
 */

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 9876;

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Conectado al servidor: " + socket);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                System.out.print("Ingrese un mensaje para enviar al servidor: ");
                String message = userInput.readLine();
                out.println(message);

                String response = in.readLine();
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
