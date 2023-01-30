public enum Type {Koda(13,"dog"),     Louis(2,"cat"),  
                   Kenai(73,"turtle"),   Johnson(9,"bunny");
                   
    private final double age;
    private final String name;
    
    private Type(double age, String name){
        this.age = age;
        this.name = name;
    }
    
    public double asDouble(){
        return age;
    }

    public String asName(){
        return name;
    }
    
    @Override
    public String toString(){
        return this.name() + " is a " + name + " age " + age;
    }
}
           
