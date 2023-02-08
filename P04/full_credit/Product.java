public abstract class Product{
    public abstract double price();
}
@Override
public String toString(){
    return "" + name + "" + cost + "" + price();
}