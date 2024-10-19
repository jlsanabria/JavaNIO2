package model;

import enumerator.Pais;

public class Autor {
    private String codAutor;
    private String nombres;
    private String apellidos;
    private Pais pais;

    public Autor() {
    }

    public Autor(String codAutor, String nombres, String apellidos, Pais pais) {
        this.codAutor = codAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "codAutor='" + codAutor + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", pais=" + pais +
                '}';
    }
}
