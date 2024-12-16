import java.util.Scanner;
import java.lang.Math;

public class Driver{
    public static void main(String[] args){
        int score = 0;
        int round = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What class");
        String classs = scan.nextLine();
        System.out.println("What name");
        String name = scan.nextLine();
        Adventurer main = createChar(classs, name, 0);
        Adventurer opp = createChar("Warrior", "enemy", 1);
        while(main.isAlive()){
            round++;
            if(opp.isAlive()){
              System.out.println("Round" + round);
            }
            else {
              score++;
              System.out.println("You killed someone");
              opp = createChar("null", "opptimus prime", (int) Math.random() * 3 + 1);
            }
            turn(main, opp, scan);
        }
        System.out.println("You lose. Round Number: " + round + "Score: " + score);
    }
    public static Adventurer createChar(String classs, String name, int x){

        if(classs.equals("Warrior") || x == 1){
            System.out.println("Created warrior with 100 health and 30 attack damage");
            return new Warrior(name, 100, 30, 5);
        } else if(classs.equals("Archer") || x == 2){
            System.out.println("Created archer with 60 health and 40 attack damage");
            return new Archer(name, 60, 40, 5);
        } else if(classs.equals("Tank") || x == 3){
            System.out.println("Created tank with 150 health and 20 attack damage");
            return new Tank(name, 150, 20, 5);
        } else if(classs.equals("Mage") || x == 4){
            System.out.println("Created mage with 100 health and 25 attack damage");
            return new Mage(name, 100, 25, 5);
        } else {
          System.out.println("Created warrior with 1000 health and 300 attack damage");
          return new Warrior(name, 1000, 300, 5);
        }

    }

    public static void turn(Adventurer main, Adventurer opp, Scanner scan){
      System.out.println("What is your move? Attack, SpecialAttack, Support");
      String move = scan.nextLine();
      if(move.equals("Attack")){
          System.out.println(main.attack(opp));
      } else if(move.equals("SpecialAttack")){
        System.out.println(main.specialAttack(opp));
      } else {
        System.out.println(main.support());
      }
      int botMove = (int) Math.random() * 3 + 1;
      if(botMove == 1){
        System.out.println(opp.attack(main));
        System.out.println("Opp attacked you");
      } else if(botMove == 2){
        System.out.println(opp.specialAttack(main));
        System.out.println("Opp special attacked you");
      } else if(botMove == 3){
        System.out.println(opp.support());
        System.out.println("Opp supported itself");
      }
    }
}
