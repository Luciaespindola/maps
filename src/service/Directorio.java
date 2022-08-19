package service;

import domain.Contacto;
import domain.Telefono;
import domain.TipoTelefono;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Directorio {
    private Map<String, Contacto> contactos;

    public Directorio() {
        this.contactos = new TreeMap<>();
    }
    public void registrarContacto(String nombre, String apellido){
        Contacto auxiliar  = new Contacto(nombre, apellido); //sabemos que no se repiten porque el mapa no admite dos llaves iguales
        contactos.put(auxiliar.getNombreCompleto(), auxiliar);
    }
    public void registrarContacto(String nombre, String apellido, Set<Telefono> numeros){
        Contacto auxiliar = new Contacto(nombre, apellido, numeros);
        contactos.put(auxiliar.getNombreCompleto(), auxiliar);


    }
    public void removerContacto(String nombre, String apellido){
        contactos.remove(nombre + " " + apellido); //si no existe, me va a dar null, si no, me devuelve el contacto eliminado

    }
    public void registrarTelefono (String nombre, String apellido, TipoTelefono tipo,
                                   String codigoPais, String numeroTelefono){
        Contacto contactoExistente = contactos.get(nombre + " " + apellido);
        //si el contacto no existe
        if (contactoExistente == null) {
            //primera opcion es:
             //instancio un contacto con una lista de tel. vacia
            /*Contacto nuevoContacto = new Contacto(nombre, apellido);
            nuevoContacto.getTelefonos().add(new Telefono(tipoTelefono, codigoPais, numeroTelefono));
            contactos.put(nuevoContacto.getNombreCompleto(),nuevoContacto);*/

            //segunda opcion es:
            //instanciar la nueva coleccion de tel. e instanciar un nuevo contacto
            Set<Telefono> telefonos = new HashSet<>();
            telefonos.add(new Telefono(tipo, codigoPais, numeroTelefono));
            Contacto nuevoContacto = new Contacto(nombre, apellido, telefonos);
            contactos.put(nuevoContacto.getNombreCompleto(), nuevoContacto);
        } else { //si el contacto existe instancio el telefono nuevo
            Telefono nuevoTelefono = new Telefono(tipo, codigoPais, numeroTelefono);
            //a la coleccion de tel. agrego un nuevo telefono
            contactoExistente.getTelefonos().add(nuevoTelefono);
        }

    }
    public void removerTelefono( String nombre, String apellido, String codigoPais, String numeroTelefono){
        //si en el mapa de contactos existe el contacto con la llave ,
        //el containsKey devuelve un verdadero si existe, si no un falso.
        if (contactos.containsKey(nombre + " "+ apellido)) {
            Contacto contactoExistente = contactos.get(nombre + " " + apellido);
            //recorremos la coleccion de tel. del contactoExistente
            boolean seEncontroTelefono = false;
            for (Telefono telefono: contactoExistente.getTelefonos()) {
                if (telefono.getIndicativoPais().equals(codigoPais) && telefono.getNumero().equals(numeroTelefono)) {
                    seEncontroTelefono = true;
                    contactoExistente.getTelefonos().remove(telefono);
                    break;
                }
            }
            //si el valor tiene un falso, con un sout imprimo
            if (!seEncontroTelefono) {
                System.out.println("El número de teléfono " + codigoPais + " " + numeroTelefono +
                        " no está registrado para " + nombre + " " + apellido + ".");
            }
        } else {
            System.out.println("El contacto " + nombre + " " + apellido + " no existe en el directorio.");
        }
    }
    public Map<String, Contacto> obtenerContacto(){
        //me retorna un mapa de contactos
        return contactos; // es igual al get
    }
}
