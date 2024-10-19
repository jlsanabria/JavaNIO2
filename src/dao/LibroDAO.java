package dao;

import model.Libro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LibroDAO {
    private static String RUTA_LIBROS = "D:\\DOCENCIA\\ICEI\\JAVA PROGRAMADOR\\Módulo IV\\Archivos\\libros.txt";

    public List<Libro> listaLibros() {
        List<Libro> libros = new ArrayList<Libro>();
        Path pathLibro = Path.of(RUTA_LIBROS);
        if (Files.exists(pathLibro)) {
            try {
                List<String> lineas = Files.readAllLines(pathLibro);
                lineas.forEach(System.out::println);
                lineas.forEach(line -> {
                    String datosLibro[] = line.split(";");
                    Libro libro = new Libro();
                    libro.setCodLibro(datosLibro[0]);
                    libro.setTitulo(datosLibro[1]);
                    libro.setNroPaginas(Integer.parseInt(datosLibro[2]));
                    // Implementar autor y editorial
                    libros.add(libro);
                });
                return libros;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return List.of();
    }

    public boolean existenLibros() {
        Path pathLibro = Path.of(RUTA_LIBROS);
        if (Files.exists(pathLibro)) {
            try {
                long cantidad = Files.lines(pathLibro).count();
                System.out.println("Número libros --> " + cantidad);
                return cantidad > 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public String guardarLibro(Libro libro) {
        String respuesta = "";
        Path pathLibro = Path.of(RUTA_LIBROS);
        if (Files.exists(pathLibro)) {
            try {
                String libroArchivo = libro.getCodLibro() + ";" + libro.getTitulo() + ";" + libro.getNroPaginas() +
                        ";" + libro.getAutor().getCodAutor() + ";" + libro.getEditorial().getEditorialId() + "\n";
                Files.write(pathLibro, libroArchivo.getBytes(), StandardOpenOption.APPEND);
                respuesta = "El libro se registro correctamente";
            } catch (IOException e) {
                respuesta = "Error el libro no se registro";
            }
        }
        return respuesta;
    }

    public String obtenerUltimoCodigo() {
        String ultimoCodigo = "";
        List<Libro> libros = new ArrayList<Libro>();
        Path pathLibro = Path.of(RUTA_LIBROS);
        if (Files.exists(pathLibro)) {
            try {
                List<String> lineas = Files.readAllLines(pathLibro);
                lineas.forEach(System.out::println);
                lineas.forEach(line -> {
                    String datosLibro[] = line.split(";");
                    Libro libro = new Libro();
                    libro.setCodLibro(datosLibro[0]);
                    libro.setTitulo(datosLibro[1]);
                    libro.setNroPaginas(Integer.parseInt(datosLibro[2]));
                    // Implementar autor y editorial
                    libros.add(libro);
                });
                ultimoCodigo = libros.stream()
                        .sorted(Comparator.comparing(Libro::getCodLibro).reversed())
                        .map(Libro::getCodLibro)
                        .findFirst().orElse("");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ultimoCodigo;
    }
}
