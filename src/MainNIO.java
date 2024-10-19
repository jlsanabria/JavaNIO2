import form.FormLibro;
import service.ManagerNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainNIO {
    public static void main(String[] args) {
//        String ruta = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\";
//
//        System.out.println("¿El archivo existe? --> " + ManagerNIO.existeArchivo(ruta + "datos.txt"));
//
//        System.out.println("Crear archivo -->  "+ ManagerNIO.createFile(ruta, "clases.backup"));
//
//        System.out.println("Crear directorio --> " + ManagerNIO.createDirectorio(ruta, "pruebas"));
//
//        System.out.println("Crear directorios --> " + ManagerNIO.crearDirectorios(ruta, "level1/one/chapter/examples"));
//
//        Path path = Paths.get(ruta);
//        try {
//            Files
//                    .list(path)
//                    .filter(f -> f.getFileName().toString().matches("^(l|p).*$"))
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        ManagerNIO.leerArchivo(ruta, "datos.txt");
//
//        System.out.println("Agregar contenido --> " + ManagerNIO.escribrir(ruta, "datos.txt", "Otro contenido :)"));
//
//        ManagerNIO.leerArchivo(ruta, "datos.txt");

        FormLibro formLibro = new FormLibro();
        formLibro.setVisible(true);

    }
}
