public class U2 extends Rocket{
    public U2(){
        maxWeight = 29;
        carry = maxWeight - weight;
        cost = 120;
        weight = 18;
        currentWeight = 0 + weight;
    }

    public boolean launch(){
        double chanceOfExplosion = 0.04 * (currentWeight / maxWeight);
        if (chanceOfExplosion < Math.random() * chanceOfExplosion) {
            return true;
        }
        return false;
    }
    public boolean land(){
        double chanseOfCrash = 0.08 * (currentWeight / maxWeight);
        if (chanseOfCrash < Math.random() * chanseOfCrash) {
            return true;
        }
        return false;
    }
}
