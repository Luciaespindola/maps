import domain.Customer;
import domain.Persona;
import service.CustomerService;
import util.DniComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class App {
    public static final void main(String[] args) {
        Scanner leer = new Scanner(System.in);

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
        }
    }
}