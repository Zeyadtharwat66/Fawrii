//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                Product cheese = new Product("Cheese", 100, 10, "28/10/2025",true, 200,15);
                Product biscuits = new Product("Biscuits", 150, 5, "24/9/2025", true,700,15);
                Product tv = new Product("Television", 22590, 9, false);
                Customer customer = new Customer("Zeyad",22,"Ziad@1298");
                customer.addBalance(5200);
                customer.addProduct(cheese, 2);
                customer.addProduct(biscuits, 1);
                String receipt = customer.checkOut();
                System.out.println(receipt);
            }
        }