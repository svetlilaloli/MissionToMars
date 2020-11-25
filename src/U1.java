import java.math.BigDecimal;

public class U1 extends Rocket{
    public U1(){
        maxWeight = 18;
        carry = maxWeight - weight;
        cost = 100;
        weight = 10;
        currentWeight = 0 + weight;
    }

    public boolean launch(){
        double chanceOfExplosion = 0.05 * (currentWeight / maxWeight);
        if (chanceOfExplosion < Math.random() * chanceOfExplosion) {
            return true;
        }
        return false;
    }
    public boolean land(){
        double chanseOfCrash = 0.01 * (currentWeight / maxWeight);
        if (chanseOfCrash < Math.random() * chanseOfCrash) {
            return true;
        }
        return false;
    }
}
