package org.example;

public class DoublyLinkedList {
    Link first;
    Link last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }

    // isEmpty
    public boolean isEmpty(){
        return (first == null);
    }

    public Link getFirst(){
        return first;
    }

    // insertFirst
    public void insertFirst(Link newLink){
        if(isEmpty()){
            last = newLink;
        }
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
        last.next = first;
    }

    // insertLast
    public void insertLast(Link newLink){
        if(isEmpty()){
            first = newLink;
        }
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    // deleteFirst
    public Link deleteFirst(){
        Link temp = first;
        if(first.next == null){
            last = null;
        }
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    // deleteLast
    public Link deleteLast(){
        Link temp = last;
        if(first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    // insertAfter
    public boolean insertAfter(String key, String data){
        Link current = first;
        while(current.getData() != key){
            if(current.next == null)
                // Data not found.
                return false;
            else
                current = current.next;
        }
        // Create new link.
        Link newLink = new Link(data);

        // Check if current is on the link.
        if(current == last) {
            newLink.next = null;
            last = newLink;
        }
        else{
            newLink.next = current.next;
            newLink.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;

        // Insert was successful
        return true;
    }

    // deleteKey
    public Link deleteKey(String key){
        Link current = first;
        while(current.data != key){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        // Key was found
        if(current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if(current == last){
            last = current.previous;
            last.next = first;
        }
        else
            current.next.previous = current.previous;

        return current;
    }

    // displayForward
    public void displayForward(){
        Link current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    // displayBackward
    public void displayBackward(){
        Link current = last;
        while(current != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println(" ");
    }
}
