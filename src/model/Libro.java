package model;

public class Libro {
    private String codLibro;
    private String titulo;
    private Integer nroPaginas;
    private Autor autor;
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String codLibro, String titulo, Integer nroPaginas, Autor autor, Editorial editorial) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.nroPaginas = nroPaginas;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(String codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(Integer nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codLibro='" + codLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", nroPaginas=" + nroPaginas +
                ", autor=" + autor +
                ", editorial=" + editorial +
                '}';
    }
}
