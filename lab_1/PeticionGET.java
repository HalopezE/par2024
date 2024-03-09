/*
    Autor: Claudia Palacios
    Date: 02-2024
 */
import java.io.*;
import java.net.*;

public class PeticionGET {

    public static void main(String[] args) {
        try {
            System.out.print("test");
            String var_url = "https://www.google.com/";
            URL url = new URL(var_url);

            URLConnection conexion = url.openConnection();

            // LEER DE LA URL
            InputStreamReader input_str = new InputStreamReader(conexion.getInputStream());
            BufferedReader reader = new BufferedReader(input_str);

            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();// cerrar flujo

        } catch (MalformedURLException me) {

            System.err.println("MalformedURLException: " + me);

        } catch (IOException ioe) {

            System.err.println("IOException:  " + ioe);
        }
    }// main
}