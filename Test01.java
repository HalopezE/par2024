/*
    Autor: Claudia Palacios
    Date: 02-2024
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Test01 {
    public static void main(String[] args) {
        String url = "https://www.datos.gov.py/dataset/proyectos-adjudicados-hackathon";
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(url);
            //Se imprime el resultado del request.
            System.out.println("La respuesta es:\n" + respuesta);
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
    }

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlParaVisitar);

        //Se crea la instancia del objecto que realizara el request
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        //Se setea el metodo con el cual se hará el request
        conexion.setRequestMethod("GET");
        //Se realiza el request a la par que construye un buffer con la información obtenida del request.
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        //Se itera, linea por linea hasta que el valor de la siguiente linea sea null.
        while ((linea = rd.readLine()) != null) {
            //Se va agregando linea por linea al objeto StringBuilder resultado.
            resultado.append(linea);
        }

        rd.close();
        return resultado.toString();
    }
}