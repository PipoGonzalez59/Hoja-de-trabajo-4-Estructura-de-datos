import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector {

    String nombreArchivo;
    FileReader archivo;
    BufferedReader lector;

    // ahora retorna un String
    public String leerArchivo(String nombreArchivo){

        String contenido = "";

        try{
            archivo = new FileReader(nombreArchivo);
            lector = new BufferedReader(archivo);

            String cadena;

            // solo guardamos la primera linea
            while((cadena = lector.readLine()) != null){
                contenido = cadena;
            }

            lector.close();

        } catch(Exception e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return contenido;
    }
}