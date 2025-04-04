import java.util.Scanner;

public class Game {
    Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);

    int playerHP;
    String playerName;
    String playerWeapon;
    int choice;
    int monsterHP;
    int silverRing;
    public static void main(String[] args){

        Game dublin;
        dublin = new Game();

        dublin.plyerSetUp(); // dublin's playerSetUp method
        dublin.townGate();
    }
    public void plyerSetUp(){
        playerHP = 10;
        monsterHP = 15;

        playerWeapon = "Knife";

        System.out.println("Your HP: " + playerHP);
        System.out.println("Your Weapon: " + playerWeapon);

        System.out.println("Please Enter your name: ");

        playerName = myScanner.nextLine();

        System.out.println("Hello "+ playerName + ", let's start the game");
    }

    public void townGate(){
//        Scanner myScanner = new Scanner(System.in);

        System.out.println("\n.....................................\n");
        System.out.println("You are at the gate of the town.");
        System.out.println("A guard is standing in front of you.");
        System.out.println("");
        System.out.println("What do you want to do.");
        System.out.println("");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack to the guard");
        System.out.println("3: Leave");
        System.out.println("\n.....................................\n");

//        int choice;
        choice =  myScanner.nextInt();

        if(choice == 1){
            if(silverRing==1){
                ending();
            }
            else {
                System.out.println("Guard: Hello there, stranger.So your name is " + playerName + "?\n Sorry but we cannot let stranger enter our town.");
                enterScanner.nextLine();
                townGate();
            }
        }
        else if(choice == 2){
            playerHP = playerHP-1 ;
            System.out.println("Guard: Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You receive 1 damage)\n");
            System.out.println("Your HP: "+ playerHP);
            enterScanner.nextLine();
            townGate();
        }
        if(choice == 3){
            crossRoad();
        }
        else {
            townGate();
        }

    }

    public void crossRoad(){
        System.out.println("\n.....................................\n");
        System.out.println("You are at a crossroad.If you go south, you will go back to the town.\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n.....................................\n");

        choice = myScanner.nextInt();

        if(choice==1){
            north();
        }
        if(choice==2){
            east();
        }
        if(choice==3){
            townGate();
        }
        if(choice==4){
            west();
        }
        else {
            crossRoad();
        }
    }

    public void north(){
        System.out.println("\n.....................................\n");
        System.out.println("There is a river. you drink water and rest at riverside.");
        System.out.println("You HP is recovered.");
        playerHP = playerHP + 1;
        System.out.println("Your HP: " + playerHP);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n.....................................\n");

        choice = myScanner.nextInt();

        if(choice==1){
            crossRoad();
        }
        else {
            north();
        }
    }
    public void east(){
        System.out.println("\n.....................................\n");
        System.out.println("You walked into a forest and you found a Long Sword!");
        playerWeapon = "Long Sword";
        System.out.println("Your Weapon: "+ playerWeapon);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n.....................................\n");

        choice = myScanner.nextInt();

        if(choice==1){
            crossRoad();
        }
        else {
            north();
        }
    }
    public void west(){
        System.out.println("\n.....................................\n");
        System.out.println("You encountered a goblin!");
        System.out.println("1: Fight");
        System.out.println("2: Run!");
        System.out.println("\n.....................................\n");

        choice = myScanner.nextInt();

        if(choice==1){
            fight();
        }
        if(choice==2){
            crossRoad();
        }
        else{
            west();
        }
    }

    public void fight(){
        System.out.println("\n.....................................\n");
        System.out.println("Your HP: "+ playerHP);
        System.out.println("Monster HP: "+ monsterHP);
        System.out.println("\n1: Attack");
        System.out.println("2: Run");
        System.out.println("\n.....................................\n");

        choice = myScanner.nextInt();

        if(choice==1){
            attack();
        }
        if(choice==2){
            crossRoad();
        }
        else {
            fight();
        }
    }

    public void attack(){
        int playerDamage =0;

        if(playerWeapon.equals("Knife")){
            playerDamage = new java.util.Random().nextInt(5);
        }
        if(playerWeapon.equals("Long Sword")){
            playerDamage = new java.util.Random().nextInt(8);
        }

        System.out.println("You attacked the monster and gave "+ playerDamage + "damage!");

        monsterHP = monsterHP - playerDamage;

        System.out.println("Monster HP: "+ monsterHP);

        if(monsterHP<1){
            win();
        }
        if(monsterHP>0){
            int monsterDamage = 0;

            monsterDamage = new java.util.Random().nextInt(4);

            System.out.println("The monster attacked you and gave "+ monsterDamage + " damage!");

            playerHP = playerHP - monsterDamage;

            System.out.println("Player HP: "+ playerHP);

            if(playerHP<1){
                dead();
            }
             else if(playerHP>0){
                fight();
            }
        }

    }

    public void dead(){
        System.out.println("\n.....................................\n");
        System.out.println("You are dead!!!");
        System.out.println("\nGAME OVER!");
        System.out.println("\n.....................................\n");
    }

    public void win(){
        System.out.println("\n.....................................\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You obtained a silver ring!\n");
        System.out.println("1: Go east");
        System.out.println("\n.....................................\n");

        silverRing = 1;

        choice = myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else {
            win();
        }
    }

    public void ending(){
        System.out.println("\n.....................................\n");
        System.out.println("Guard: Oh you killed that goblin?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy.Welcome to our town!");
        System.out.println("\n\n.............THE END...............");
        System.out.println("\n.....................................\n");
    }

}
