/*
    Autor: Claudia Palacios
    Date: 02-2024
    Referencia: https://docs.oracle.com/javase/10/docs/api/java/net/URL.html
 */
import java.io.IOException;
import java.net.URL;

public class EjemploURL {
    public static void main(String[] args) throws IOException {
        String test_url= "http://www.pol.una.py";
        URL pagina1 = new URL(test_url);
        URL pagina2 = new URL("http","grado.pol.una.py",80,"index.html");

        //Primera Prueba
        System.out.println("***** Primera pagina");
        System.out.println("Protocolo: "+pagina1.getProtocol());
        System.out.println("Puerto: "+pagina1.getPort());
        System.out.println("Host: "+pagina1.getHost());
        System.out.println("Archivo: "+pagina1.getFile());
        System.out.println("External form: "+pagina1.toExternalForm());

        //Segunda prueba
        System.out.println("***** Segunda pagina");
        System.out.println("Protocolo: "+pagina2.getProtocol());
        System.out.println("Puerto: "+pagina2.getPort());
        System.out.println("Host: "+pagina2.getHost());
        System.out.println("Archivo: "+pagina2.getFile());
        System.out.println("External form: "+pagina2.toExternalForm());

    } //fin main

} //fin EjemploURL