public class Warrior extends Adventurer{
    private int rage;
 
    
     
    public Warrior(String name, int hp, int attackDMG, int rage){
        super(name, hp, attackDMG);
        
        this.rage = rage;
    }
    
    public String getSpecialName(){
        return "rage";
    }
  //accessor methods
    public int getSpecial(){
        return rage;
    }
    public void setSpecial(int n){
        this.rage = n;
    }
 
    
  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
      //hurt or hinder the target adventurer
      public String attack(Adventurer other){
    
        other.applyDamage(this.getAttack());
        if(other.isAlive()){
            this.applyDamage(other.getAttack());
        }
        return "Your health: " + this.getHP() + "Opp's health: " + other.getHP();
         
      }

      //hurt or hinder the target adventurer, consume some special resource
      public String specialAttack(Adventurer other){
            if(rage > 0){
                other.applyDamage(3 * this.getAttack());
                if(other.isAlive()){
                    this.applyDamage(other.getAttack());
                }
                rage--;
                return "Your health: " + this.getHP() + "Opp's health: " + other.getHP();
            } else {
                return "NO MORE SNIPES";
            }
      }
      public String support(Adventurer other){
        return "WARRIOR CANNOT SUPPORT";
       }

  //heall or buff self
    public String support(){
        return "WARRIOR CANNOT SUPPORT";
    }


    public int getSpecialMax(){
        return 0;
    }
    
}
