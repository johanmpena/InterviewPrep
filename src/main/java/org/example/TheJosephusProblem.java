package org.example;
import java.util.Scanner;

public class TheJosephusProblem {
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        Link one = new Link("Apollo");
        list.insertFirst(one);
        Link two = new Link("Zeus");
        list.insertFirst(two);
        Link three = new Link("Hermes");
        list.insertFirst(three);
        Link four = new Link("Nike");
        list.insertFirst(four);
        Link five = new Link("Atlas");
        list.insertFirst(five);
        Link six = new Link("Poseidon");
        list.insertFirst(six);
        Link seven = new Link("Josephus");
        list.insertFirst(seven);
        Link eight = new Link("Ajax");
        list.insertFirst(eight);
        Link nine = new Link("Homer");
        list.insertFirst(nine);
        Link ten = new Link("Odysseys");
        list.insertFirst(ten);
        Link eleven = new Link("Achilles");
        list.insertFirst(eleven);
        Link twelve = new Link("Hera");
        list.insertFirst(twelve);
        Link thirteen = new Link("Demeter");
        list.insertFirst(thirteen);
        Link fourteen = new Link("Hades");
        list.insertFirst(fourteen);
        Link fifteen = new Link("Agamemnon");
        list.insertFirst(fifteen);

        ListIterator iterator = new ListIterator(list);

        System.out.println("Welcome!");
        System.out.println("Josephus needs your help.");
        System.out.println("He and his friends are about to be capture by the Romans.");
        System.out.println("Rather then be enslaved, they will commit suicide.");
        System.out.println("..... Only problem is Josephus does not want to do that.");
        System.out.println("Make sure Josephus is the last one, so he can escape.");

        while(iterator.getCurrent() != null )
        {
            System.out.print(iterator.getCurrent().getData() + ", ");
            if(iterator.getCurrent() == list.last)
                break;
            iterator.nextLink();
        }

        System.out.println(" ");

        iterator.reset();

        System.out.println("Please pick a number: ");
        Scanner userInput = new Scanner(System.in);
        int value = userInput.nextInt();
        String check = "Josephus";

        for(int i = 0; i < 14; i++){
            for(int j = 0; j < value; j++){
                iterator.nextLink();
            }
            System.out.println(iterator.getCurrent().data + " has died...");
            if(iterator.getCurrent().data == check){
                System.out.println("Sorry you lose.");
                iterator.deleteCurrent();
                break;
            }
            iterator.deleteCurrent();
        }

        if(iterator.getCurrent().data == check){
            System.out.println("You manage to keep Josephus alive.");
        }


    }
}
