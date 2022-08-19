package com.sample;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.undo.AbstractUndoableEdit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.charset.StandardCharsets;
import java.sql.PseudoColumnUsage;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.Date;
import java.util.Locale;


public class Main {
    public static void main(String[] args) throws IOException {

//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("https://kc.kobotoolbox.org/media/original?media_file=akwang%2Fattachments%2F1253e960974d468aa1d3f5ecea820d87%2Fc24a1909-83d1-48cb-aef0-e45b1e9aa60b%2F1657200115465.jpg")
//                .method("GET", null)
//                .addHeader("Authorization", "Basic YWt3YW5nOjV6TXJHU0whWEokSmpQdEc=")
//                .build();
//        Response response = client.newCall(request).execute();
//
//        System.out.println("RESPO:: "+ response.body().string());

        //System.out.println("Hello world!");
        //int number = 100;
        //String brand = "Richmond";
        // Date date = new Date();
        //System.out.println(date);
        //System.out.println(number);
        //LocalDate now = LocalDate.now();



        // System.out.println(name.toLowerCase());
        // System.out.println(now.getMonth());

        //String name = new String("RICHMOND ASAMOAH");
        // System.out.println(name.charAt(2));
        // System.out.println(name.contains("ASAMOAH"));



        //sendMsg("233546640723", "first sms from java app date", "Cloudify");
        //sendMsg();
        //useOperator();
        //useOperator();
        //ifStatement();
        //learnScanner();
        //expressions();
        //gui();
        //randomValues();
        //switches();
        //whileLoops();
       forLoops();
        //arrays();
        //arraysAd();
        //twoDArrays();
        //usefulMethods();
        //wrapperClass();
        //arrayList();
        //arrayList2d();
        //forEachLoop();

        //overload method
        //int x = add(1,3);
        //int x = add(2,3,2,2);
        //double x = add(2.3,4.2);
        //System.out.println(x);
        //finalDeclare();

        //OPP
        //Car myCars = new Car();
        //Car myCars1 = new Car();
        //System.out.println(myCars.make);
        //System.out.println(myCars1.price);
        //myCars.drive();

        //constructor
        //Human human = new Human("RICHMOND", 34, 34.23);
        //Human human1 = new Human("Darlington", 34,89.3);
        //System.out.println(human.age);
        //System.out.println(human1.name);
        //human1.eat();
        //human1.drink();

        //local and global variable
        //DiceRoller diceRoller = new DiceRoller();

        //Overloaded Constructor
        //Pizza pizza = new Pizza("Tea Bread", "Tomatoes", "Beef", "Turkey tigh");
        //Pizza pizza = new Pizza("Tea Bread", "Tomatoes");
        //System.out.println(pizza.bread);
        //System.out.println(pizza.sauce);
        //System.out.println(pizza.topping);
        //System.out.println(pizza.cheese);

        //sendData();

        //inheritance
        //Car car = new Car();
        //Bicycle bicycle = new Bicycle();
        //car.go("BMW");
        //car.brake("BMW");
        //System.out.println(car.doors);
        //System.out.println(bicycle.pedals);


        //method overidding
        //Dog dog = new Dog();
        //Animal animal = new Animal();
        //dog.speak();
        //animal.speak();



        //Super keyword
        //Hero hero = new Hero("Richmond",34, "Super");
        //System.out.println(hero.age);


        //encapsulation ----getter

        //Car car = new Car("Toyota","Nissan", 2022);
        //System.out.println(car.getMake());
        //System.out.println(car.getModel());
        //System.out.println(car.getYear());

        //car.setYear(2035);
        //System.out.println(car.getYear());


        //stressTest();


//        for (int i = 0 ; i < 100; i++){
//            Multithread myThing = new Multithread(i);
//            myThing.start();
//        }

    }



    public static void useOperator(){
        int richmondAge = 19;
        int asamoahAge = 20;
        boolean isRichmondOldThanAsamoah = richmondAge > asamoahAge;
        System.out.println(richmondAge == asamoahAge);
    }

    public static void isLogical(){
        boolean isAdult = false;
        boolean isStudent = true;
        System.out.println(!isAdult && isStudent);

    }

    public static void ifStatement(){
        // && and || or == equal  ! not equal b
        int age = 17;
        if (age > 19){
            System.out.println(age);
        } else if (age >= 16 || age < 19){
            System.out.println("Greater equal age");
        } else {
            System.out.println("Greater than age");
        }

    }


    public static void sendMsg()
    {
        LocalDate smsDate = LocalDate.now();
        String toTelephone = "233208424833";
        String msg = "Am super excited to send sms from Java adding util date to message. "+smsDate+"";
        String senderName = "Cloudify";

        OkHttpClient client = new OkHttpClient().newBuilder() .build();
        Request request = new Request.Builder()
                .get()
                .url("https://sms.arkesel.com/sms/api?action=send-sms&" +
                        "api_key=OkVyVmRab3pzNjlZbmJsbHE!=&" +
                        "to=" +toTelephone+
                        "&" +
                        "from="+senderName+"&" +
                        "sms="+msg.toUpperCase())
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String message = response.body().string();

            JSONObject jsonObject = new JSONObject(message);
            System.out.println(message);
            System.out.println(jsonObject.optString("code"));

            File f = new File("C:\\Users\\RICHMOND ASAMOAH\\Desktop\\test.json");

            if(f.exists()){
                f.delete();
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }
            else {
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void learnScanner (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("How old are you now?");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Whats your fav food?");
        String food = scanner.nextLine();

        System.out.println("Welcome " +name.toUpperCase()+ ", is great to have you. Hurry!! you are "+age+" years old now. You also like "+food.toUpperCase()+"...Hmmmm i see");
        scanner.close();
    }



    public static void expressions(){
        //expresions = operands + operators
        int friends = 10;
        friends++;
        System.out.println(friends);
    }


    public static void gui(){
        String name = JOptionPane.showInputDialog("Enter your name");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));

        JOptionPane.showMessageDialog(null, "Weclome "+name);
        JOptionPane.showMessageDialog(null, "You are" +age+ "years old");
        JOptionPane.showMessageDialog(null, "You are" +height+ "cm tall");


    }


    public static void randomValues() {
        Random random = new Random();
        long x = random.nextLong();
        long y = random.nextLong();
        System.out.println(y);

    }

    public static void switches(){
        String day = "Friday";
        switch (day){
            case "Sunday": System.out.println("Its sunday");
                break;
            case "Monday": System.out.println("Its Monday");
                break;
            case "Tuesday": System.out.println("Its Tuesday");
                break;
            case "Wednesday": System.out.println("Its Wed");
                break;
            case "Thursday": System.out.println("Its Thursday");
                break;
            case "Friday": System.out.println("Its Friday");
                //sendMsg();
                break;
            case "Saturday": System.out.println("Its Sat");
                break;
            default:System.out.println("Invalid Day");
        }
    }


    public static void whileLoops(){
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while(name.isBlank()){
            System.out.println("Enter the name");
            name = scanner.nextLine();
        }
        System.out.println("Hello" +name);

    }

    public static void forLoops(){
<<<<<<< HEAD
        for(int i = 0; i<=300; i++){
=======
        for(int i = 0; i<=200; i++){
>>>>>>> 880a6c9317869e630bc5c16b33d7af9f88a4ec9a
            System.out.println(i);
            //sendMsg();
            //sendData();
            stressTest();
        }

    }

    public static void arrays(){
        String[] cars = {"B.M.W", "BENZ", "TOYATO CAMRY"};
        cars[0] = "FORD";
        for(int i =0; i <=2; i++){
            System.out.println("I will one day drive " +cars[i]);
        }
        //System.out.println(cars[2]);
    }

    public static void arraysAd(){
        String[] car = new String[3];
        car[0] = "BMW";
        car[1] = "BENZ";
        car[2] = "AUDI";

        for(int i=0; i<car.length; i++){
            System.out.println(car[i]);
        }
    }

    public static void twoDArrays(){
        //2D ARRAYS
        String[][] cars = new String[3][3];
        cars[0][0] = "BMW";

    }


    public static void usefulMethods(){
        String name = "Richmond";
        //boolean result = name.equals("Richmond");
        //boolean result = name.equalsIgnoreCase("richmond");
        //int result = name.length();
        //char result = name.charAt(2);
        //boolean result = name.isEmpty();
        //String result = name.toLowerCase();
        //result = name.trim();
        String result = name.replace('i','a');
        System.out.println(result);
    }

    public static void wrapperClass(){
        Boolean a = true;
        Character b = '@';
        Integer c = 123;
        Double d = 3.12;
        String e = "Richmond";

        if(a==true){
            System.out.println("this is true");
        }
        if(b=='@'){
            System.out.println("this is @");
        }
    }

    public static void arrayList(){
        ArrayList<String > food = new ArrayList<String>();
        food.add("Jollof");
        food.add("Banku and Okro Soup");
        food.add("FuFu and Aponkye Krakra");

        food.set(0,"Omo Tuo and Groundsoup"); //replace a value in an array
        //food.remove(1);  //remove a value in and array
        //food.clear();  //clear values in an array

        for(int i=0; i<food.size(); i++){
            System.out.println(food.get(i));
        }
    }


    public static void arrayList2d(){
        //2d dimensional array
        ArrayList<ArrayList<String>> groceryList = new ArrayList();

        ArrayList<String> bakeryList = new ArrayList();
        bakeryList.add("Pizza");
        bakeryList.add("Garlic");
        bakeryList.add("Donut");

        ArrayList<String> produceList = new ArrayList();
        produceList.add("tomatoes");
        produceList.add("orange");
        produceList.add("ginger");

        ArrayList<String> drinkList = new ArrayList();
        drinkList.add("tomatoes");
        drinkList.add("orange");
        drinkList.add("ginger");

        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinkList);

        System.out.println(drinkList);
        System.out.println(groceryList.get(2).get(1));
    }

    public static void forEachLoop(){
        //for -each loop for array and collection  : each
        ArrayList<String> animals = new ArrayList<String>();

        //String[] animals = {"RICHMOND","DARLINGTON","ASAMOAH","NIGGA"};
        animals.add("RICHMOND");
        animals.add("TEYE");
        animals.add("MENSAH");
        animals.add("ASAMOAH");

        for(String i : animals){
            System.out.println(i);
        }
    }


    //overloaded methods
    static int add(int a, int b){
        System.out.println("This is overloaded method #1");
        return a + b;
    }

    static int add(int a, int b, int c){
        System.out.println("This is overloaded method #2");
        return a + b + c;
    }

    static int add(int a, int b, int c, int d){
        System.out.println("This is overloaded method #3");
        return a + b + c + d;
    }

    static double add(double a, double b){
        System.out.println("This is overloaded method #1");
        return a + b;
    }


    public static void finalDeclare(){

        double pi = 2.3432;
        pi = 3.22;
        //final cannot be changed

        final double PI = 34.24;
        System.out.println(PI);
    }


    public static void sendData() {


        OkHttpClient client = new OkHttpClient().newBuilder() .build();

        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");

        Request request = new Request.Builder()
                .post(body)
                .url("https://eywik85fpyrijct-nonproduction1.adb.uk-london-1.oraclecloudapps.com/ords/testing/TEST_JAVA/INSERT")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful());

            String message = "Success";


            System.out.println(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public static void stressTest()
    {

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        String toTelephone = "233546640723";
        String[] arrayList = {"BECE", "WASSCE", "MOH", "SHS"};
        String[] moneyList = {"BECE", "WASSCE", "MOH", "SHS"};

        Random random = new Random();
        int q = random.nextInt(arrayList.length);

//        JSONObject requestBody = new JSONObject();
//        requestBody.put("customerName", "RICHMOND");
//        requestBody.put("network", "MTN");
//        requestBody.put("accountRef", "Testing");
//        requestBody.put("paymentRef", arrayList[q]);
//        requestBody.put("amount", "70");
//        requestBody.put("transactionId", uuid);
//        requestBody.put("username", "0000000-2e57-4df3-8bb7-00000000");
//        requestBody.put("password", "00000000-6dce-4505-a0bd-00000000");

        String requestBody = "{\"CustomerMobile\": "+toTelephone+",\n" +
                "    \"customerName\": \"RICHMOND\",\n" +
                "    \"network\": \"MTN\",\n" +
                "    \"accountRef\": \"Testing\",\n" +
                "    \"paymentRef\": \""+arrayList[q]+"\",\n" +
                "    \"amount\": \"60\",\n" +
                "    \"transactionId\":\""+uuid+"\",\n" +
                "    \"username\": \"0000000-2e57-4df3-8bb7-00000000\",\n" +
                "    \"password\": \"00000000-6dce-4505-a0bd-00000000\"}";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
<<<<<<< HEAD
        //RequestBody body = RequestBody.create(mediaType, requestBody);
        requestBody.toString();
        RequestBody body = RequestBody.create(mediaType,requestBody.toString() );
=======
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
>>>>>>> 1626f02f41d275ebe2f022186ffde2e453c76a4a

        System.out.println("REQUEST : "+ requestBody);
        Request request = new Request.Builder()
                .url("https://eywik85fpyrijct-nonproduction1.adb.uk-london-1.oraclecloudapps.com/ords/mawulepe/momo/test/callback")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();


        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String message = response.body().string();

            JSONObject jsonObject = new JSONObject(message);
            System.out.println(message);
            System.out.println(jsonObject.optString("ResponseCode"));

            File f = new File("C:\\Users\\RICHMOND ASAMOAH\\Desktop\\Stress\\response.json");

            if(f.exists()){
                f.delete();
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }
            else {
                f.createNewFile();
                FileWriter myWriter = new FileWriter(f);
                myWriter.write(message);
                myWriter.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}


