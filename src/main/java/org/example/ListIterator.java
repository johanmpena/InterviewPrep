package org.example;

public class ListIterator {
    private Link current;
    private Link previous;
    private DoublyLinkedList list;

    public ListIterator(DoublyLinkedList list){
        this.list = list;
        reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }
    public Link getCurrent(){
        return current;
    }

    public void insertAfter(String data){
        Link newLink = new Link(data);
        if(list.isEmpty()){
            list.insertFirst(newLink);
            current = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String data){
        Link newLink = new Link(data);
        if(previous == null){
            newLink.next = list.getFirst();
            list.insertFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent(){
        String value = current.data;
        if(previous == null){
            list.deleteKey(current.data);
            reset();
        }
        else{
            previous.next = current.next;
            if(atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }
}
