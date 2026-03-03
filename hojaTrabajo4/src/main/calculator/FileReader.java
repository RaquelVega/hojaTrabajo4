package calculator;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Utilidad para leer expresiones desde un archivo de texto.
 */
public class FileReader {

    /**
     * Lee la primera línea de un archivo de texto.
     * @param filename Nombre del archivo.
     * @return Contenido de la primera línea (la expresión).
     */
    public static String readExpression(String filename) {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filename))) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                throw new RuntimeException("El archivo está vacío o no contiene una expresión válida.");
            }
            return line.trim();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
    }
}