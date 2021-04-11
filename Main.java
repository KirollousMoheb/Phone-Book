package com.array;

import java.util.Scanner;

public class Main {
    private static Scanner input=new Scanner(System.in);
    private static MobilePhone mobilePhone=new MobilePhone();

    private static void printOptions(){
        System.out.println("Welcome to my Phone Book");
        System.out.println("Enter the Number of the Option You Want to perform");
        System.out.println("1)Add new Contact");
        System.out.println("2)Show Lists of Contacts");
        System.out.println("3)Update Existing Contact");
        System.out.println("4)Search By name");
        System.out.println("5)Remove Existing Contact");
        System.out.println("6)EXIT");


    }
    private static void addContact(){

        System.out.println("Enter the name");
        String name=input.next();

        System.out.println("Enter the number");
        String number=input.next();

        Contacts person=Contacts.createContact(name,number);

        if (mobilePhone.addContact(person)){
            System.out.println("New contact added: name = " + name + ", phone = " + number);

        }
        else {
            System.out.println("Contact Already Exists");
        }


    }

    private static void showContacts(){
        mobilePhone.printContacts();

    }
    private static void updateContact(){
        System.out.println("Enter the name of the contact you want to change");
        String name=input.next();
        System.out.println("Enter the new name of the contact ");
        String newName=input.next();
        System.out.println("Enter the new number of the contact ");
        String number=input.next();


        mobilePhone.update(name,newName,number);




    }
    private static void searchContact(){

    }
    private static void removeContact(){
        System.out.println("Enter the name");
        String name=input.next();
        if (mobilePhone.getContactByName(name) == null) {
            System.out.println("Contact doesn't exists");
            return;
        }
        mobilePhone.remove(mobilePhone.getContactByName(name));

    }


    public static void main(String[] args) {




        printOptions();
        boolean quit=false;
        while (!quit){
            int option=input.nextInt()-1;

            switch (option){
                case 0:
                    addContact();
                    break;
                case 1:
                    showContacts();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    quit=true;
                    System.out.println("Shut Down");
                    break;
            }
        }



    }
}
