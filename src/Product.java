public class Product {
    private String productName;
    private double price;
    private int quantity;
    private String expiryDate;
    private Boolean shipping;
    private double shippingFees;
    private float weight;
    Product(String productName, double price, int quantity, String expiryDate, Boolean shipping, float weight,double shippingFees) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.shipping = shipping;
        this.weight = weight;
        this.shippingFees = shippingFees;
    }
    Product(String productName, double price, int quantity, Boolean shipping) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.shipping = shipping;
    }
    Product(String productName, double price, int quantity, String expiryDate, Boolean shipping) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.shipping = shipping;
    }
    Product(String productName, double price, int quantity, Boolean shipping, float weight,double shippingFees) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.shipping = shipping;
        this.weight = weight;
        this.shippingFees = shippingFees;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public Boolean getShipping() {
        return shipping;
    }
    public void setShipping(Boolean shipping) {
        this.shipping = shipping;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getShippingFees() {
        return shippingFees;
    }
    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

}
