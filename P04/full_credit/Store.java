import java.util.ArrayList;
import java.util.Scanner;

public class Store{
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<Product> shoppingCart = new ArrayList<>();
            
            //Taxed items
            products.add(new Taxed(0.98, "Cheese",0));
            products.add(new Taxed(12.94, "Ale",1));
            products.add(new Taxed(4.71, "Candy",2));
            //Non-taxed items
            products.add(new Taxfree(3.29, "Tissue Box",3));
            products.add(new Taxfree(2.17, "Croissants",4));
            products.add(new Taxfree(5.62, "Nuts",5));

            Taxed.setTaxRate(0.0765);
            System.out.println("========================");
            System.out.println("  Welcome to the Store  ");
            System.out.println("========================");

            for(Product p : products){
                System.out.print(p);
            }
            System.out.println("\n\n" + "Current Order" + "\n" + "-------------");
                    
            try{
                while(true){
                    System.out.print("\n\nWhich product would you like to buy?\n");
                        if(in.nextInt() >= 0){
                            shoppingCart.add(products.get(in.nextInt()));
                            System.out.println("========================");
                            System.out.println("  Welcome to the Store  ");
                            System.out.println("========================");

                            for(Product p : products){
                            System.out.print(p);
                            }
                            System.out.println("\n\n" + "Current Order" + "\n" + "-------------");
                            for(Product s : shoppingCart){
                            System.out.print(s);
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
    
