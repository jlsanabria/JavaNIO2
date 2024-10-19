package dao;

import enumerator.Pais;
import model.Autor;

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
public class AutorDAO {
    private static String RUTA_AUTORES = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\autores.txt";

    public AutorDAO() {
    }

    public String existeArchivoAutores() {
        String respuesta = "";
        Path path = Paths.get(RUTA_AUTORES);
        respuesta = Files.exists(path) ? "El archivo de autores cargado :)" : "El archivo de autores no encontrado :(";
        return respuesta;
    }
    /**
     * Método que permite leer el contenido del archivo autores.txt
     *
     */
    public List<Autor> leerArchivoAutores() {
        List<Autor> autores = new ArrayList<>();
        Path archivo = Paths.get(RUTA_AUTORES);
        if(Files.exists(archivo)) {
            try {
                System.out.println("-------- LEYENDO CONTENIDO CON SCANNER -----------");
                Scanner lineasArchivo = new Scanner(archivo);
                while (lineasArchivo.hasNextLine()) {
                    String linea = lineasArchivo.nextLine();
                    System.out.println(linea);
                    String[] datosAutor = linea.split(";");
                    Autor autor = new Autor();
                    autor.setCodAutor(datosAutor[0]);
                    autor.setNombres(datosAutor[1]);
                    autor.setApellidos(datosAutor[2]);
                    autor.setPais(Pais.obtenerPais(datosAutor[3]));
                    System.out.println(autor);
                    autores.add(autor);
                }
                System.out.println("---------------------------------------------------");
                return autores;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return List.of(); // retornar lista vacia
    }

    public boolean existenAutores() {
        Path pathAutor = Paths.get(RUTA_AUTORES);
        if(Files.exists(pathAutor)) {
            try {
                long cantidad = Files.lines(pathAutor).count();
                System.out.println("Número autores --> " + cantidad);
                return cantidad > 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public Autor findByNombreApellido(String nombres, String apellidos) {
        List<Autor> autoresList = leerArchivoAutores();
        return autoresList.stream()
                .filter(autor -> autor.getNombres().equals(nombres) && autor.getApellidos().equals(apellidos))
                .findFirst().orElse(null);
    }
}
