public class Option extends Store{
    protected String name;
    protected long cost;

    public Option(String name, long cost){
        super(name);
        this.cost = cost;
        if(cost < 0)throw new RuntimeException("Invalid amount");
    }

    public long cost(){
        return cost;
    }

    @Override
    public String toString(){
        return name + " ($" + cost / 100.0 + ")";
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || name() != ((Store) o).name()) return false;
        return equals(o);//compares both name and cost
    }
    
}