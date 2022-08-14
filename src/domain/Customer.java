package domain;

import java.util.Objects;

public class Customer {
    private String codigoDeRegistro;
    private String razonSocial;
    private String direccion;

    public Customer(String codigoDeRegistro, String razonSocial, String direccion) {
        this.codigoDeRegistro = codigoDeRegistro;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    public String getCodigoDeRegistro() {
        return codigoDeRegistro;
    }

    public void setCodigoDeRegistro(String codigoDeRegistro) {
        this.codigoDeRegistro = codigoDeRegistro;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "Codigo de registro: " + codigoDeRegistro + ", Razón Social: " + razonSocial + ", Sede Legal: " + direccion + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return codigoDeRegistro == customer.codigoDeRegistro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDeRegistro, razonSocial, direccion);
    }
}