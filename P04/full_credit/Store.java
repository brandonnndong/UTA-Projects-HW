


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;

public class Store{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> shoppingCart = new ArrayList<>();

        products.add(new Taxed(0.98, "Cheese"));

        products.add(new Taxfree(3.29, "Tissue Box"));


        System.out.println("========================");
        System.out.println("  Welcome to the Store  ");
        System.out.println("========================");
        //prints all products
        //prints items in shopping cart
        //prints a question asking which product you want to buy(if number is negative exit)
        for(Product p : products){
            System.out.print(p);
        }

        System.out.println("\n");
        System.out.println("Current Order" + "\n" + "-------------" + "\n");

        for(Product s : shoppingCart){
            System.out.print(s);
        }
        
        
            try{
               // for(Integer k : in.hasNext()){
                   // shoppingCart.add(in.nextInt(k));
                //}
            
                while(true){
                    System.out.println("\n" + "Which product would you like to buy?");
                    shoppingCart.add(in.nextInt());
                }

            }
            catch(IllegalArgumentException e){
                System.exit(-1);
            }
            in.close();
        }
    
}