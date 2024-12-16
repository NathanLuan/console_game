public class Tank extends Adventurer{
    private int buff;



    public Tank(String name, int hp, int attackDMG, int buff){
        super(name, hp, attackDMG);

        this.buff = buff;
    }

    public String getSpecialName(){
        return "buff";
    }
  //accessor methods
    public int getSpecial(){
        return buff;
    }
    public void setSpecial(int n){
        this.buff = n;
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
            if(buff > 0){
                buff--;
                other.applyDamage((int) 0.5 * this.getAttack());
                this.setmaxHP(2 * this.getmaxHP());
                this.setHP(this.getmaxHP());
                if(other.isAlive()){
                    this.applyDamage(other.getAttack());
                }
                return "Your health: " + this.getHP() + "Opp's health: " + other.getHP();
            } else {
                return "NO MORE BUFFS";
            }
      }
      public String support(Adventurer other){
        return "TANK CANNOT SUPPORT";
       }

  //heall or buff self
    public String support(){
        return "TANK CANNOT SUPPORT";
    }


    public int getSpecialMax(){
        return 0;
    }

}
