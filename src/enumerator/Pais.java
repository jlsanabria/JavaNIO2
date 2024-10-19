package enumerator;

public enum Pais {
    ARGENTINA("AR","Argentina"), BOLIVIA("BO","Bolivia"),
    CHILE("CL", "Chile"), COLOMBIA("CO", "Colombia"),
    ESTADOS_UNIDOS("USA", "Estados Unidos"), INGLATERRA("EN", "Inglaterra"),
    FRANCIA("FR", "Francia"), BIELORUSIA("BE", "Bielorusia");

    private String codigo;
    private String nombre;

    Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public static Pais obtenerPais(String nombrePais) {
        for (Pais pais : Pais.values()) {
            if (pais.getNombre().equalsIgnoreCase(nombrePais)) {
                return pais;
            }
        }
        return Pais.BOLIVIA;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
