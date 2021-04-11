package com.array;
import java.util.ArrayList;

public class MobilePhone {
    private  ArrayList <Contacts> contact= new ArrayList<>();

    public MobilePhone(){

    }
    public MobilePhone(ArrayList<Contacts> contact) {
        this.contact = contact;

    }
    public boolean  addContact(Contacts contacts ){
        if (search(contacts.getName()) >= 0 ) {
            return false;
        }
        contact.add(contacts);
        return true;

    }
    public int search(String name){

        for (int i = 0; i < contact.size(); i++) {
            Contacts myContact=this.contact.get(i);
            if (myContact.getName().equals(name)){
                return i;
            }
        }

        return -1;
    }
    public void printContact(String name){
        int index=search(name);
        if (index >=0) {
            Contacts searched=contact.get(index);
            System.out.println("Contact name is: " +searched.getName()+" and his/her phone number is: "+ searched.getNumber());
        }
        else{
            System.out.println("The contact you want doesn't exist");

        }
    }
    public void update(String oldName,String newName,String number){
        int indexToBeUpdated=search(oldName);
        if (indexToBeUpdated >=0) {
            Contacts updated=Contacts.createContact(newName,number);
            contact.set(indexToBeUpdated,updated);
            System.out.println("Contact" +oldName+"updated to " +newName);
        }else {
            System.out.println("The contact you want to update doesn't exist");
        }
    }
    public void remove(Contacts contacts){
        int indexToBeRemoved=search(contacts.getName());
        if ( indexToBeRemoved >=0 ) {
            contact.remove(indexToBeRemoved);
            System.out.println("Contact"+contacts.getName()+" is removed");
        }
    }
    public  void printList(){
        System.out.println("Contacts :");
        for (int i = 0; i < this.contact.size(); i++) {
            System.out.println(i+"."+this.contact.get(i).getName()+"----"+this.contact.get(i).getNumber());
        }
    }
    public  int find(Contacts contact){
        return this.contact.indexOf(contact);
    }
    public Contacts getContactByName(String name){
        if (search(name)>=0) {
            return this.contact.get(search(name));
        }
        return null;
    }

}
