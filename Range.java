public class Archer extends Adventurer{
    private int attackDMG;
    private int range;
    
    public Range(String name, int hp, int range, int attackDMG){
        super(name, hp);
        this.attackDMG = attackDMG;
        this.range = range;
    }
    
    
    public String specialAttack(Adventurer other){
        return "boop";
    }
    public String getSpecialName(){
        return "m";
    }
 
    public int getSpecial(){
        return 0;
    }
    public void setSpecial(int n){
        n = n;
    }
     public int getSpecialMax(){
        return 0;
    }

  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
  //hurt or hinder the target adventurer
  public String attack(Adventurer other){
        return "boop";
    }

  //heall or buff the target adventurer
  public String support(Adventurer other){
        return "sup2";
    }

  //heall or buff self
  public String support(){
        return "sup";
    }

    
    
    
}
