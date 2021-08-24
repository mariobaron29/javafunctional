package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal Java function
        greetCustomer(new Customer("Maria", "99999"));

        // Normal Java function
        greetCustomerV2(new Customer("Maria", "99999"), false);

        // consumer Functional interface
        greetCustomerConsumer.accept(new Customer("Maria", "99999"));

        // BiConsumer Functional interface
        greetCustomerConsumerV2.accept(new Customer("Maria", "99999"), false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello "+ customer.customerName + ", thanks for registering your phone number " + customer.customerphoneNumber );

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out.println("Hello "+ customer.customerName + ", thanks for registering your phone number " + (showPhoneNumber ? customer.customerphoneNumber: "*******") );

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName + ", thanks for registering your phone number " + customer.customerphoneNumber );
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber ){
        System.out.println("Hello "+ customer.customerName + ", thanks for registering your phone number " + (showPhoneNumber ? customer.customerphoneNumber: "*******") );
    }

    static class Customer{
        private final String customerName;
        private final String customerphoneNumber;

        Customer(String customerName, String customerphoneNumber) {
            this.customerName = customerName;
            this.customerphoneNumber = customerphoneNumber;
        }
    }
}
