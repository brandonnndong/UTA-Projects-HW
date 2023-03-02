import java.util.ArrayList;
import java.util.Scanner;
/*
 * things to fix -
 * add total price -- make total price add the whole sum of prices and not print after each item printed
 */

 public class Store{
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Product> shoppingCart = new ArrayList<>();
            
            //Taxed items
            products.add(new Taxed(3.29, "Tissue Box",0));
            products.add(new Taxed(12.94, "Ale",1));
            products.add(new Taxed(4.71, "Candy",2));
            //Non-taxed items
            products.add(new Taxfree(0.98, "Cheese",3));
            products.add(new Taxfree(2.17, "Croissants",4));
            products.add(new Taxfree(5.62, "Nuts",5));

            System.out.println("========================");
            System.out.println("  Welcome to the Store  ");
            System.out.println("========================");

            for(Product p : products){
                System.out.printf(p + "$%2.2f",p.price());
            }
            System.out.println("\n\n" + "Current Order" + "\n" + "-------------");
                    
            try{
                while(true){
                    System.out.print("\n\nWhich product would you like to buy?\n");
                    int item = in.nextInt();
                        if(item >= 0){
                            shoppingCart.add(products.get(item));
                            System.out.println("========================");
                            System.out.println("  Welcome to the Store  ");
                            System.out.println("========================");

                            for(Product p : products){
                                System.out.printf(p + "$%2.2f",p.price());
                            }
                            System.out.println("\n\n" + "Current Order" + "\n" + "-------------");
                            for(Product s : shoppingCart){
                                System.out.printf(s + "$%2.2f" + "\n" + "total price: $%2.2f",s.price(),s.price());
                            }        
                            }else{
                                System.exit(-1);
                            }
                        }                     
                    }catch(IllegalArgumentException e){
                        System.err.println(e.getMessage());
                        System.exit(-1);
                    }
        }
                    
    }
                
}
    
