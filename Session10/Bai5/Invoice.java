package Session10.Bai5;

public class Invoice {
    private int invoiceID;
    private double price;
    // Constructor
    public  Invoice(int invoiceID, double price) {
        this.invoiceID = invoiceID;
        this.price = price;
    }
    // Getter and Setter

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID=" + invoiceID +
                ", price=" + price +
                '}';
    }
}
