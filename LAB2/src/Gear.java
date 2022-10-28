public interface Gear {
    //GearType getGearType();
    String getGearName();
    String getGearAdjective();
    String getGearNoun();
    Gear combineGear(Gear g);
    int getGearAttackPoints();
    int getGearDefensePoints();
}
