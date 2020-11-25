import static java.lang.Integer.parseInt;

public abstract class Rocket implements SpaceShip{
    int maxWeight;
    int carry;
    int cost;
    int weight;
    int currentWeight;

    // When U1 and U2 classes extend the Rocket class they will override these methods to return true or false
    // based on the actual probability of each type.
    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }
    public boolean canCarry(Item item){
        if (this.currentWeight + parseInt(item.weight.toString()) > this.maxWeight) {
            return false;
        }
        return true;
    }
    public void carry (Item item){
        this.currentWeight += (int)item.weight;
    }
}
