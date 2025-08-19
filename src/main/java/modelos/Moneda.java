package modelos;

public class Moneda {
    private String codigo;
    private String nombre;
    private double tasaCambio;

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Moneda(String codigo, String nombre, double tasaCambio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tasaCambio = tasaCambio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}