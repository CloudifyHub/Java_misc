package com.sample;

/*
public class Car {
    String make = "BMV";
    String model = "i5";
    int year = 2020;
    String color = "blue";
    double price = 89000.00;

    void drive(){
        System.out.println("You are the driving the "+make);
    }

    void brake(){
        System.out.println("You step on the brakes");
    }
}
*/

/*
//inheritance for Vehicle Class
public class Car extends Vehicle{
 int doors = 4;
 int wheels = 4;

}

 */

//encapsulation - getter

public class Car {

            private String make;
            private String model;
            private int year;

       Car(String make, String model, int year){
          //this.make = make;
           // this.model = model;
         //this.year = year;

           this.setMake(make);
           this.setModel(model);
           this.setYear(year);
       }

       public String getMake(){
        return make;
       }

       public String getModel(){
        return model;
       }

       public int getYear(){
        return year;
       }



       public void setMake(String make){
           this.make = make;
       }

       public void setModel(String model){
           this.model = model;
       }

       public void setYear(int year){
           this.year = year;
       }

}