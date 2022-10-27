public class HandGear extends AbstractGear {
    public HandGear(String Adjective, String noun, int attackValue) {
        super(Adjective, noun, attackValue, 0);
    }

    @Override
    protected Gear returnNewGear(String adj, String noun, int attack, int defense) {
        return new HandGear(adj, noun, attack);
    }

    @Override
    boolean checkType(Gear o) {
        if(o instanceof HandGear){
            return true;
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "Type: " + this.getType() + " "+
//                "name='" + name + '\'' +
//                ", attackStrength=" + attackStrength +
//                ", defenseStrength=" + defenseStrength;
//    }
}
