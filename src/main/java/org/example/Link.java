package org.example;

public class Link {
    Link next;
    Link previous;
    String data;

    public Link(String data){
        this.data = data;
    }

    public String getData(){
       return data;
    }

    public void displayLink(){
        System.out.print(data + " ");
    }
}
