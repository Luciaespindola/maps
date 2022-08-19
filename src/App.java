import domain.Contacto;
import domain.Customer;
import domain.Persona;
import domain.Telefono;
import service.CustomerService;
import service.Directorio;
import util.DniComparator;
import domain.TipoTelefono;

import java.util.*;

public class App {
    public static final void main(String[] args) {
       /* Scanner leer = new Scanner(System.in);

        Customer customer1 = new Customer("AS611", "Motorola", "Lavalle 1700");
        Customer customer2 = new Customer("WF121", "Arcos Dorados S.A.", "Alem 700");
        Customer customer3 = new Customer("BD311", "Aerolineas Argentina S.A.", "Mitre 900");
        Customer customer4 = new Customer("US844", "Mappa Studios", "Okinawa 342");
        Customer customer5 = new Customer("F43S2", "Wit Studio", "Corrientes 1231");

        Map<String, Customer> customers = new HashMap<>();
        customers.put(customer1.getCodigoDeRegistro(), customer1);
        customers.put(customer2.getCodigoDeRegistro(), customer2);
        customers.put(customer3.getCodigoDeRegistro(), customer3);
        customers.put(customer4.getCodigoDeRegistro(), customer4);
        customers.put(customer5.getCodigoDeRegistro(), customer5);

        for (Map.Entry<String, Customer> customersAux: customers.entrySet()) {
            System.out.println(customersAux.toString());
        }

        System.out.println("-----------------------------------------------");

        System.out.println("Ingrese el codigo de registro a buscar:");
        String aux = leer.next();

        if (CustomerService.getCustomerByKey(customers, aux) == null) {
            System.out.println("El elemento buscado no se encuentra registrado.");
        } else {
            System.out.println(CustomerService.getCustomerByKey(customers, aux).toString());
        } */

        //creando telefonos
        Telefono tel1 = new Telefono(TipoTelefono.MÓVIL, "+54", "01156561212");
        Telefono tel2 = new Telefono(TipoTelefono.MÓVIL, "+39", "016578456598");
        Telefono tel3 = new Telefono(TipoTelefono.MÓVIL, "+1", "3476966917");
        Telefono tel4 = new Telefono(TipoTelefono.MÓVIL, "+44", "212245778");

        //creando set de telefonos
        Set<Telefono> set1 = new HashSet<>();
        set1.add(tel3);
        set1.add(tel4);

        Set<Telefono> set2 = new HashSet<>();
        set2.add(tel2);
        set2.add(tel3);

        Set<Telefono> set3 = new HashSet<>();
        set3.add(tel1);

        Set<Telefono> set4 = new HashSet<>();
        set4.add(tel1);
        set4.add(tel2);
        set4.add(tel3);

        //creando contactos
        Contacto contacto1 = new Contacto("Brenda", "Zattera");
        Contacto contacto2 = new Contacto("Lucía", "Pérez");
        Contacto contacto3 = new Contacto("Juan", "Fernández", set3);
        Contacto contacto4 = new Contacto("Marcos", "González", set1);

        //creando directorio
        Directorio directorioBrenda = new Directorio();

        //llamando métodos
        directorioBrenda.registrarContacto(contacto1.getNombre(), contacto1.getApellido(), set2);
        directorioBrenda.registrarContacto(contacto3.getNombre(), contacto3.getApellido(), set3);
        directorioBrenda.registrarContacto(contacto2.getNombre(), contacto3.getApellido(), set1);
        directorioBrenda.registrarContacto(contacto4.getNombre(), contacto4.getApellido(), set1);


        System.out.println("----------------------");

        directorioBrenda.registrarTelefono("Pedro", "Sanchez", TipoTelefono.FIJO, "+39", "3461547765");
        directorioBrenda.registrarTelefono("Lucía", "Pérez", TipoTelefono.OFICINA, "+54", "2213659852");

        System.out.println("----------------------");

        directorioBrenda.removerContacto("Marcos", "González");
        directorioBrenda.removerContacto("Marcos", "De La Torre");

        System.out.println("----------------------");

        directorioBrenda.removerTelefono("Juan", "Fernández", "+54", "01156561212");
        directorioBrenda.removerTelefono("Juan", "Fernández", "+23", "123456789");

        System.out.println("----------------------");

        System.out.println(directorioBrenda.obtenerContacto());

    }
}