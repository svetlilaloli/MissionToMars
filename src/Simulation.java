import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    //should read the text file line by line and create an Item object for each and then add it to
    // an ArrayList of Items. The method should then return that ArrayList.
    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList<Item> allItems = new ArrayList<>();
        Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Item currentItem = new Item();
                String [] currentLine = new String[2];
                currentLine = scanner.nextLine().split("=");
                currentItem.item = currentLine[0];
                currentItem.weight = currentLine[1];
                allItems.add(currentItem);
            }

        return allItems;
    }
    //loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    // It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    // and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets
    // that are fully loaded.
    public ArrayList<U1> loadU1(ArrayList<Item> items){
        ArrayList<U1> rockets = new ArrayList<>();
        U1 rocket = new U1();

        for (Item item: items){
            if (rocket.canCarry(item)){
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U1();
            }
        }
        return rockets;
    }

    //loadU2: this method also takes the ArrayList of Items and starts creating U2 rockets and filling them
    // with those items the same way as with U1 until all items are loaded. The method then returns the ArrayList of
    // those U2 rockets that are fully loaded.
    public ArrayList<U2> loadU2(ArrayList<Item> items){
        ArrayList<U2> rockets = new ArrayList<>();
        U2 rocket = new U2();

        for (Item item: items){
            if (rocket.canCarry(item)){
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2();
            }
        }
        return rockets;
    }
    //runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets
    // in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send
    // that rocket again. All while keeping track of the total budget required to send each rocket safely to Mars.
    // runSimulation then returns the total budget required to send all rockets (including the crashed ones).
    public int runSimulator(ArrayList<Rocket> rockets){
        int budget = 0;
        for (Rocket rocket: rockets){
            budget += rocket.cost;
            if (!(rocket.launch() || rocket.land())){
                budget += rocket.cost;
            }
        }
        return budget;
    }
}
