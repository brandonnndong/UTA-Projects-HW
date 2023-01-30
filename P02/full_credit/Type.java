// Each enumerated value calls the constructor below with its parameter
public enum Type {Koda(13,"dog"),     Louis(2,"cat"),  
                   Kenai(73,"turtle"),   Johnson(9,"bunny");
    
    // Attribute for the integer representing this month               
    private final double age;
    private final String name;
    
    // Constructor for setting the attribute
    private Type(double age, String name) {
        this.age = age;
        this.name = name;
    }
    
    // Method that returns the associated month ID for a month
    public double asDouble() {
        return age;
    }
    
    // Method that returns the associated month's gemstone
    public String asName() {
        return name;
    }
    
    @Override
    public String toString() {
        return this.name() + " is a " + name + " age " + age;
    }
}
           
