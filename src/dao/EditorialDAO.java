package dao;

import enumerator.Pais;
import model.Autor;
import model.Editorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que gestiona la información del archivo autores.txt
 */
public class EditorialDAO {
    private static String RUTA_EDITORIALES = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\editoriales.txt";

    public EditorialDAO() {
    }

    public String existeArchivoEditoriales() {
        String respuesta = "";
        Path path = Paths.get(RUTA_EDITORIALES);
        respuesta = Files.exists(path) ? "El archivo de editoriales cargado :)" : "El archivo de editoriales no encontrado :(";
        return respuesta;
    }
    /**
     * Método que permite leer el contenido del archivo editoriales.txt
     *
     */
    public List<Editorial> obtenerEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        Path archivo = Paths.get(RUTA_EDITORIALES);
        if(Files.exists(archivo)) {
            try {
                System.out.println("-------- LEYENDO CONTENIDO CON SCANNER -----------");
                Scanner lineasArchivo = new Scanner(archivo);
                while (lineasArchivo.hasNextLine()) {
                    String linea = lineasArchivo.nextLine();
                    System.out.println(linea);
                    String[] datosEditorial = linea.split(";");

                    Editorial editorial = new Editorial();
                    editorial.setEditorialId(Integer.parseInt(datosEditorial[0]));
                    editorial.setNombreEditorial(datosEditorial[1]);
                    System.out.println(editorial);

                    editoriales.add(editorial);
                }
                System.out.println("---------------------------------------------------");
                return editoriales;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return List.of(); // retornar lista vacia
    }

    public Editorial findByNombre(String nombreEditorial) {
        List<Editorial> editorialList = obtenerEditoriales();
        return editorialList.stream()
                .filter(editorial -> editorial.getNombreEditorial().equals(nombreEditorial))
                .findFirst().orElse(null);
    }
}
