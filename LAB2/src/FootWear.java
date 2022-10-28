public class FootWear extends AbstractGear{

  public FootWear(String Adjective, String noun, int attackValue, int defenseValue) {
    super(Adjective, noun, attackValue, defenseValue);
  }

  @Override
  protected Gear returnNewGear(String adj, String noun, int attack, int defense) {
    return new FootWear(adj, noun, attack, defense);
  }

  @Override
  boolean checkType(Gear o) {
    if(o instanceof FootWear){
      return true;
    }
    return false;
  }


  @Override
  public String toString() {
    return  "FootWear"  + " " +
            "Name = '" + getGearName() + '\'' +
            ", AttackStrength = " + getGearAttackPoints() +
            ", DefenseStrength = " + getGearDefensePoints();
  }
}
