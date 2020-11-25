import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        File phase1 = new File("C:\\Users\\Sony Vaio\\Desktop\\Java\\MissionToMars\\src\\phase-1.txt");
        File phase2 = new File("C:\\Users\\Sony Vaio\\Desktop\\Java\\MissionToMars\\src\\phase-2.txt");
        Simulation simulation = new Simulation();
        ArrayList<Item> itemsPhase1 = new ArrayList<>();
        itemsPhase1 = simulation.loadItems(phase1);
        ArrayList<Item> itemsPhase2 = new ArrayList<>();
        itemsPhase2 = simulation.loadItems(phase2);

        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        for(U1 u1Rocket : simulation.loadU1(itemsPhase1)){
            u1Rockets.add(u1Rocket);
        }
        for(U1 u1Rocket : simulation.loadU1(itemsPhase2)){
            u1Rockets.add(u1Rocket);
        }

        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        for(U2 u2Rocket : simulation.loadU2(itemsPhase1)){
            u2Rockets.add(u2Rocket);
        }
        for(U2 u2Rocket : simulation.loadU2(itemsPhase2)){
            u2Rockets.add(u2Rocket);
        }

        int budgetU1 = simulation.runSimulator(u1Rockets);
        System.out.println(budgetU1);
        int budgetU2 = simulation.runSimulator(u2Rockets);
        System.out.println(budgetU2);
    }
}
