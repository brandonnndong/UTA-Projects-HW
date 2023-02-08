public class Store{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> shoppingCart = new ArrayList<>();

        products.add(new Taxed("Cheese", 0.98));
        products.add(new Taxed("Cheese", 0.98));
        products.add(new Taxed("Cheese", 0.98));
        products.add(new Taxfree("Cheese", 0.98));
        products.add(new Taxfree("Cheese", 0.98));
        products.add(new Taxfree("Cheese", 0.98));

        System.out.println("========================");
        System.out.println("  Welcome to the Store  ");
        System.out.println("========================");
        //prints all products
        //prints items in shopping cart
        //prints a question asking which product you want to buy(if number is negative exit)
        for(Product p : products){
            for(Product s : shoppingCart){
            System.out.print("\n" + p + "Current Order" + "\n" + "-------------" + "\n" + s + "Which product would you like to buy?");
            try{
                if(in.nextInt() > 0){
                    shoppingCart.add(new (s));
                }
            }
            catch(IllegalArgumentException e){
                
                
            }
            }
        }

    }
}