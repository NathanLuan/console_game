public class Archer extends Adventurer{
    private int snipe;



    public Archer(String name, int hp, int attackDMG, int snipe){
        super(name, hp, attackDMG);

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
        this.snipe = n;
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
            if(snipe > 0){
                other.applyDamage(2 * this.getAttack());
                if(other.isAlive()){
                    this.applyDamage(other.getAttack());
                }
                snipe--;
                return "Your health: " + this.getHP() + "Opp's health: " + other.getHP();
            } else {
                return "NO MORE SNIPES";
            }
      }
      public String support(Adventurer other){
        return "sup2";
       }

  //heall or buff self
    public String support(){
        return "sup";
    }


    public int getSpecialMax(){
        return 0;
    }

}
