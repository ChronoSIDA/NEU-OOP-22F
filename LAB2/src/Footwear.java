public class Footwear extends AbstractGear{

    public Footwear(String Adjective, String noun, int attackValue, int defenseValue) {
        super(Adjective, noun, attackValue, defenseValue);
    }

    @Override
    protected Gear returnNewGear(String adj, String noun, int attack, int defense) {
        return new Footwear(adj, noun, attack, defense);
    }

    @Override
    boolean checkType(Gear o) {
        if(o instanceof Footwear){
            return true;
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return  "Type: " + this.getType() + " "+
//                "name='" + name + '\'' +
//                ", attackStrength=" + attackStrength +
//                ", defenseStrength=" + defenseStrength;
//    }
}
