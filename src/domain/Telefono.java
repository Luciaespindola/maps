package domain;

import java.util.Objects;

public class Telefono {
    private TipoTelefono tipoTelefono;
    private String indicativoPais;
    private String numero;

    public Telefono(TipoTelefono tipo, String indicativoPais, String numero) {
        this.tipoTelefono = tipoTelefono;
        this.indicativoPais = indicativoPais;
        this.numero = numero;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public String getIndicativoPais() {
        return indicativoPais;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return tipoTelefono + ": " + indicativoPais + " " + numero + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(indicativoPais, telefono.indicativoPais) && Objects.equals(numero, telefono.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indicativoPais, numero);
    }
}