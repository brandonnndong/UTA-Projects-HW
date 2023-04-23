package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;

public class Customer implements Comparable<Customer>{
    public Customer(String name, String email) {
        int atIndex = email.indexOf('@', 0);
        int dotIndex = (atIndex >= 0) ? email.indexOf('@', 0) : -1;
        if(dotIndex < 0) 
            throw new IllegalArgumentException("Invalid email address: " + email);
        this.name = name;
        this.email = email;
    }
    public Customer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.email = br.readLine();
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(email + '\n');
    }
    
    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
    @Override
    public boolean equals(Object o) {
        try {
            if(this == o) return true;
            if(this.getClass() != o.getClass()) return false;
            Customer c = (Customer) o;
            return this.name.equals(c.name) && this.email.equals(c.email);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode(){
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(name);
        hash = 31 * hash + Objects.hashCode(email);
        return hash;
    }

    @Override
    public int compareTo(Customer o) {
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            return this.email.compareTo(o.email);
        }
    }

    private String name;
    private String email;
}
