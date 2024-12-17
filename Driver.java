import java.util.Scanner;
import java.lang.Math;

public class Driver{
    public static void main(String[] args){
        int score = 0;
        int round = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your \u001b[35mclass\u001b[0m");
        String classs = scan.nextLine();
        System.out.println("What's your name");
        String name = scan.nextLine();
        Adventurer main = createChar(classs, name, 0);
        Adventurer opp = createChar("Warrior", "enemy", 1);
        while(main.isAlive()){
            round++;
            if(opp.isAlive()){
              System.out.println("\u001b[34m");
              System.out.print("Round ");
              System.out.print("\u001b[0m");
              System.out.println(round);
            }
            else {
              score++;
              System.out.print("You ");
              System.out.print("\u001b[31m");
              System.out.print("killed ");
              System.out.print("\u001b[0m");
              System.out.println("someone");
              opp = createChar("null", "opptimus prime", (int) Math.random() * 3 + 1);
            }
            turn(main, opp, scan);
        }
        System.out.println("You lose. ");
        System.out.print("\u001b[34m");
        System.out.print("Round Number: " + round);
        System.out.print("\u001b[33m");
        System.out.print(" Score: " + score);
        System.out.print("\u001b[0m");
    }
    public static Adventurer createChar(String classs, String name, int x){

        if(classs.equals("Warrior") || x == 1){
            System.out.println("Created \u001b[35mwarrior\u001b[0m with \u001b[32m100 health \u001b[0mand \u001b[31m30 attack damage \u001b[0m");
            return new Warrior(name, 100, 30, 5);
        } else if(classs.equals("Archer") || x == 2){
            System.out.println("Created \u001b[35marcher\u001b[0m with \u001b[32m60 health \u001b[0mand \u001b[31m40 attack damage \u001b[0m");
            return new Archer(name, 60, 40, 5);
        } else if(classs.equals("Tank") || x == 3){
            System.out.println("Created \u001b[35mtank\u001b[0m with \u001b[32m150 health \u001b[0mand \u001b[31m20 attack damage \u001b[0m");
            return new Tank(name, 150, 20, 5);
        } else if(classs.equals("Mage") || x == 4){
            System.out.println("Created \u001b[35mmage\u001b[0m with \u001b[32m100 health \u001b[0mand \u001b[31m25 attack damage \u001b[0m");
            return new Mage(name, 100, 25, 5);
        } else {
          System.out.println("Created \u001b[35mboss\u001b[0m with 1000 health and 300 attack damage");
          return new Warrior(name, 1000, 300, 5);
        }

    }

    public static void turn(Adventurer main, Adventurer opp, Scanner scan){
      System.out.println("What is your \u001b[34mmove\u001b[0m? (Attack, SpecialAttack, Support)");
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
        System.out.println("Opp \u001b[31mattacked\u001b[0m you");
      } else if(botMove == 2){
        System.out.println(opp.specialAttack(main));
        System.out.println("Opp \u001b[31mspecial attacked\u001b[0m you");
      } else if(botMove == 3){
        System.out.println(opp.support());
        System.out.println("Opp \u001b[31msupported\u001b[0m itself");
      }
    }
}
