public class Mage extends Adventurer{
    private int heal;
 
    
     
    public Mage(String name, int hp, int attackDMG, int heal){
        super(name, hp, attackDMG);
        
        this.heal = heal;
    }
    
    public String getSpecialName(){
        return "heal";
    }
  //accessor methods
    public int getSpecial(){
        return heal;
    }
    public void setSpecial(int n){
        this.heal = n;
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
            other.applyDamage(2 * this.getAttack());
            if(other.isAlive()){
                this.applyDamage(other.getAttack());
            }
            return "Your health: " + this.getHP() + "Opp's health: " + other.getHP();
      }
      public String support(Adventurer other){
        if(heal > 0){
            other.setHP(other.getmaxHP());
            heal--;
            return "Yay you are healed";
            
        } else {
            return "NO MORE HEALS";
        }
      }

  //heall or buff self
    public String support(){
        if(heal > 0){
            this.setHP(this.getmaxHP());
            heal--;
            return "Yay i am healed";
            
        } else {
            return "NO MORE HEALS";
        }
    }
    


    public int getSpecialMax(){
        return 0;
    }
    
}
