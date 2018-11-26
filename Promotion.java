/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHUCK
 */
import java.util.ArrayList;

public class Promotion{
    
    private ArrayList<Document> products;
    private double discount;

    public Promotion(ArrayList<Document> products, double discount) {
        this.products = products;
        this.discount = discount;
    }
    public ArrayList<Document> getProducts() {
        return products;
    }
    
    public void setProducts(ArrayList<Document> products) {
        this.products = products;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void display(){
        System.out.println("Information of Document(s) which are offered at " + discount * 100 + "% of their original price:\n");
        
        for(Document d : products){
            d.display();
        }
    }
}
