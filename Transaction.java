
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
public class Transaction {
    private ArrayList<Document> products;
    private long cardNumber;
    private double totalPrice;
    private String customerName;
    private Date date;
    private String billingInfo;

    public Transaction(ArrayList<Document> products, long cardNumber, double totalPrice, String customerName, String billingInfo) {
        this.products = products;
        this.cardNumber = cardNumber;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        Calendar cal = Calendar.getInstance();
        this.date = cal.getTime();
        this.billingInfo = billingInfo;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(String billingInfo) {
        this.billingInfo = billingInfo;
    }
    
    public void display(){
        System.out.println("\nProducts: \n");
        for(Document d : products){
            d.display();
            System.out.print("\n");
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Customer name: " + customerName);
        System.out.println("Date of transaction: " + date.toString());
        System.out.println("Biling info of customer: " + billingInfo);
    }
}
