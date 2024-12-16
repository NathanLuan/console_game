import java.util.Scanner;

public class Driver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What class, name");
        String classs = scan.next();
        String name = scan.next();
        Adventurer main = createChar(classs, name);
        while(main.)        
    }
    public Adventurer createChar(String classs, String name){
        if(classs.equals("Warrior")){
            return new Warrior(name, 100, 30, 5);
        } else if(classs.equals("Archer")){
            return new Archer(name, 60, 40, 5);
        } else if(classs.equals("Tank")){
            return new Tank(name, 150, 20, 5);
        } else {
            return new Mage(name, 100, 25, 5);
        }
        
    }

}
