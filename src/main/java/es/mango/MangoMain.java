package es.mango;

public class MangoMain {
    public static void main(String[] args) {
        MangoGossips mg;
        try {
            //int minuts = 480;
            //int max_persons = 4;
            //int max_routes = 4;

            mg = new MangoGossips(480, 3, 4);
            String result = mg.start();
            System.out.println(result);
            mg.persons.forEach(it -> System.out.println(it));
        } catch(Exception ex){
            ex.printStackTrace(); //logger
        }
    }
}