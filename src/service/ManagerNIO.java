package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * API NIO.2 New Input Ouput 2 para trabajar con archivos
 */
public final class ManagerNIO {
    public static String existeArchivo(String ruta) {
        String respuesta = "";
        Path path = Paths.get(ruta);
        respuesta = Files.exists(path) ? "El archivo existe :)" : "El archivo no existe :(";
        return respuesta;
    }

    public static String createFile(String ruta, String nombre) {
        String respuesta = "";
        Path path = Paths.get(ruta + nombre);
        try {
            Files.createFile(path);
            respuesta = "Archivo creado exitósamente";
        } catch (IOException e) {
            respuesta = "Error al crear el archivo";
        }
        return respuesta;
    }

    public static String createDirectorio(String ruta, String nombre) {
        String respuesta = "";
        Path path = Paths.get(ruta + nombre);
        try {
            Files.createDirectory(path);
            respuesta = "Directorio creado exitósamente";
        } catch (IOException e) {
            respuesta = "Error al crear el directorio";
        }
        return respuesta;
    }

    public static String crearDirectorios(String ruta, String directorios) {
        String respuesta = "";
        Path path = Paths.get(ruta + directorios);
        try {
            Files.createDirectories(path);
            respuesta = "Directorios creado exitósamente";
        } catch (IOException e) {
            respuesta = "Error al crear los directorios";
        }
        return respuesta;
    }

    /**
     * Escribir contenido con FileWriter
     *
     * @param nombre
     * @param contenido
     * @return
     */
    public static String escribrir(String ruta, String nombre, String contenido) {
        String respuesta = "";
        Path archivo = Paths.get(ruta + nombre);
        try {
            Files.write(archivo, (contenido + "\n").getBytes(), StandardOpenOption.APPEND);
            respuesta = "Files --> contenido guardado con éxito :)";
        } catch (IOException e) {
            respuesta = "Files --> no se pudo guardar el contenido :(";
        }
        return respuesta;
    }

    /**
     * Método que permite leer el contenido de un archivo
     *
     * @param nombre
     */
    public static void leerArchivo(String ruta, String nombre) {
        String respuesta = "";
        Path archivo = Paths.get(ruta + nombre);
        try {
            System.out.println("-------- LEYENDO CONTENIDO CON SCANNER -----------");
            Scanner lineasArchivo = new Scanner(archivo);
            while (lineasArchivo.hasNextLine()) {
                System.out.println(lineasArchivo.nextLine());
            }
            System.out.println("---------------------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
