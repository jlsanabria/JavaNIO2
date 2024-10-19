package model;

public class Editorial {
    private Integer editorialId;
    private String nombreEditorial;

    public Editorial() {
    }

    public Editorial(Integer editorialId, String nombreEditorial) {
        this.editorialId = editorialId;
        this.nombreEditorial = nombreEditorial;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "editorialId=" + editorialId +
                ", nombreEditorial='" + nombreEditorial + '\'' +
                '}';
    }
}
