import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer{
    private String name;
    private int age;
    private String password;
    private double subTotal;
    private double shippingCost;
    private double balance;
    private HashMap<Product,Integer> cart;
    Customer(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.subTotal=0;
        this.shippingCost=0;
        this.balance=0;
        this.cart = new HashMap<>();
    }
    public void addBalance(double balance) {
        this.balance+=balance;
    }
    public void addProduct(Product product,int quantity) {
        if (product.getQuantity() > quantity) {
            cart.put(product,quantity);
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("The product has already been added to the cart");
        }
        else {
            System.out.println("The product has no sufficient quantity.please select less quantity");
        }
    }
    public void removeProduct(Product product) {
        if (cart.containsKey(product)) {
            product.setQuantity(product.getQuantity() + cart.get(product));
            cart.remove(product);
            System.out.println("The product has already been removed to the cart");
        }
        else {
            System.out.println("Failed to remove product,may be you donot have this product");
        }
    }

    public String checkOut() {
        StringBuilder shipmentNotice = new StringBuilder();
        StringBuilder receipt = new StringBuilder();
        shipmentNotice.append("** Shipment notice **\n");
        receipt.append("** Checkout receipt **\n");
        if (cart.size() == 0) {
            throw new IllegalStateException("Cart is empty");
        }
        double totalWeight = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getQuantity() < quantity) {
                throw new IllegalStateException("Not enough stock for product: " + product.getProductName());
            }
            double itemTotal = product.getPrice() * quantity;
            subTotal += itemTotal;
            receipt.append(quantity + "x " + product.getProductName() + "\t\t" + (int)itemTotal + "\n");
            if (product.getShipping()==true) {
                shipmentNotice.append(quantity + "x " + product.getProductName() + "\t\t" + product.getWeight()*quantity + "g\n");
                totalWeight += product.getWeight() * quantity;
                shippingCost += product.getShippingFees();
            }
        }
        double paidAmount = subTotal + shippingCost;
        if (this.balance >= paidAmount) {
            balance -= paidAmount;
        } else {
            throw new IllegalStateException("Insufficient balance.");
        }
        shipmentNotice.append(String.format("Total package weight %.1fkg\n", totalWeight / 1000));
        receipt.append("----------------------\n");
        receipt.append("Subtotal \t\t" + (int)subTotal + "\n");
        receipt.append("Shipping \t\t" + (int)shippingCost + "\n");
        receipt.append("Amount   \t\t" + (int)paidAmount + "\n");
        return   shipmentNotice.toString() +"\n"+receipt.toString();
    }
}