package org.ayushanand;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          Passenger passenger = new Passenger("Ayush",24,Gender.MALE,BerthPreference.UPPER); //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
          System.out.println("Name :" + passenger.getName());
          System.out.println("Age :" + passenger.getAge());
          System.out.println("Gender :" + passenger.getGender());
          System.out.println("Berth Preference :" + passenger.getBerthPreference());
          passenger.setName("Ayush Anand");
          System.out.println("Name :" + passenger.getName());
          try {
              passenger.setAge(-10);
          }catch(IllegalArgumentException e) {
              System.out.println("Error Message :" + e.getMessage());
          }

        // to see how IntelliJ IDEA suggests fixing it.

    }
}