public class Archer extends Range{
    private int snipe;

    
    public Archer(String name, int hp, snipe){
        super(name, hp);
        attackDMG = 0;
        this.snipe = snipe;
    }
    public String getSpecialName(){
        return "snipe";
    }
  //accessor methods
    public int getSpecial(){
        return snipe;
    }
    public void setSpecial(int n){
        this.snipe = snipe;
    }
 
    
  /*
    all adventurers must have a way to attack enemies and
    support their allys
  */
      //hurt or hinder the target adventurer
      public String attack(Adventurer other){
            if(other.getSpecialName.equals("rage")){
                other.applyDamage(this.getAttackDamage());
                if(other.isAlive()){
                    this.applyDamage(other.getAttackDamage());
                }
            }
            else {

                if(this.getRange() < other.getRange()){
                    this.applyDamage(other.getAttackDamage());
                    if(this.isAlive()){
                        other.applyDamage(this.getAttackDamage());
                    }
                } else {
                    other.applyDamage(this.getAttackDamage());
                    if(other.isAlive()){
                        this.applyDamage(other.getAttackDamage());
                    }
                }
            }   
      }

      //hurt or hinder the target adventurer, consume some special resource
      public abstract String specialAttack(Adventurer other){
            if(other.getSpecialName.equals("rage")){
                other.applyDamage(this.getAttackDamage());
                if(other.isAlive()){
                    this.applyDamage(other.getAttackDamage());
                }
            }
            else {

                if(this.getRange() * 1.1 < other.getRange()){
                    this.applyDamage(other.getAttackDamage());
                    if(this.isAlive()){
                        other.applyDamage(2 * this.getAttackDamage());
                    }
                } else {
                    other.applyDamage(2 * this.getAttackDamage());
                    if(other.isAlive()){
                        this.applyDamage(other.getAttackDamage());
                    }
                }
            }  
      }

    
    
}
