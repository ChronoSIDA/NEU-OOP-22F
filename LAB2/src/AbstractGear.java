public abstract class AbstractGear implements Gear{

     String gearName;
     String gearAdjective;
     String gearNoun;
     final int attackStrength;
     final int defenseStrength;
    public AbstractGear(String Adjective, String noun, int attackValue, int defenseValue) {
        if (Adjective.split(",").length != 1 || noun.split(",").length != 1) throw new IllegalArgumentException("There should be only one adjective and only one noun");
        if (attackValue < 0 || defenseValue < 0 ) throw new IllegalArgumentException("attackStrength or defense Strength should not < 0");
        this.gearAdjective = Adjective;
        this.gearNoun = noun;
        this.gearName = gearAdjective + ", "+ gearNoun;
        this.defenseStrength = defenseValue;
        this.attackStrength = attackValue;
    }
//    @Override
//    public abstract GearType getGearType();

    @Override
    public String getGearAdjective() {
        return this.gearAdjective;
    }

    @Override
    public String getGearNoun() {
        return this.gearNoun;
    }

    @Override
    public String getGearName() {
        return this.gearName;
    }

    protected abstract Gear returnNewGear(String adj, String noun, int attack, int defense);

    // check the type of thw gear
    abstract boolean checkType(Gear o);

    @Override
    public Gear combineGear(Gear g) {
        // System.out.println(this.getName())
        //System.out.println(g.getName());
        // System.out.println(this.getType() + "" + g.getType());
       // if (this.getType() != g.getType()) throw new IllegalArgumentException("While combining the gear type should be the same");
        // combine the name first then combine the attributes
        if(checkType(g) != true){
            throw new IllegalArgumentException("Wrong gear type!");
        }
        String newAdj = this.getGearAdjective() + " " + g.getGearAdjective();
        String newNoun = this.getGearNoun();

        //String newAdj = g.getAdjective();

        //System.out.println(newAdj + " " + newNoun);
        int newAttack = this.getGearAttackPoints() + g.getGearAttackPoints();
        int newDefense = this.getGearDefensePoints() + g.getGearDefensePoints();

       return returnNewGear(newAdj, newNoun, newAttack, newDefense);
    }

    @Override
    public int getGearAttackPoints() {
        return this.attackStrength;
    }

    @Override
    public int getGearDefensePoints() {
        return this.defenseStrength;
    }

    @Override
    public int compareTo(Gear o) {
        if (this.getGearAttackPoints() < o.getGearDefensePoints()){
            return -1;
        } else if(this.getGearAttackPoints() > o.getGearDefensePoints()){
            return 1;
        } else{
            return Integer.compare(this.getGearDefensePoints(), o.getGearDefensePoints());
        }
    }
}
