public class Customer extends Store{
    public Customer(String name, String email){
        super(name);
        Customer.email = email;
        String char1 = new String("@");
        String char2 = new String(".");
        int checkEmail1 = email.indexOf(char1);
        int checkEmail2 = email.indexOf(char2);
        if(checkEmail1 == -1 && checkEmail2 == -1){
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public String toString(){
        return name + " (" + email + ")";
    }

    public boolean equals(Object o){
        return name == email;
    }

    private String name;
    static String email;
}