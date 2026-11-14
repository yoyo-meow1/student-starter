package edu.starter;

import java.util.Scanner;
/** Student-owned game entry point; replace this message with your own implementation. */

public final class Main {
    public static void main(String[] args){
        /**lets start writing our game */
        Scanner console = new Scanner(System.in);
        Player player = new Player("player", 100, 5, false, 10);
        Enemy enemy1 = new Enemy("enemy", 30);
        Enemy enemy2 = new Enemy("enemy", 45);
        Enemy[] enemies = {enemy1, enemy2};
        int enemyCount = 0;
        for (Enemy enemy : enemies){
            enemyCount++;
            boolean enemyisalive = true;
            System.out.println("A wild " + enemy.getName() + " appears with " + enemy.getHP() + " HP!");
            player.changeDefense(false);
            while (enemyisalive){
                System.out.println("What would you like to do?");
                System.out.println("1 - Attack");
                System.out.println("2 - Special Attack");
                System.out.println("3 - Defend");
                System.out.println("4 - Recover");
                int action = ConsoleChoice.read(console, 1, 4);
                while (true){   
                    if (action == 1 || action == 2||action == 3||action == 4)
                        break;
                    else{
                        System.out.println("Invalid action. Please choose 1, 2, 3, or 4.");
                        action = ConsoleChoice.read(console, 1, 4);
                    }
                }
                boolean resourceBreak = false;
                switch (action){
                    case 1:
                        player.attak(enemy);
                        break;
                    case 2:
                        resourceBreak = player.Special(enemy);
                        break;
                    case 3:
                        player.changeDefense(true);
                        break;
                    case 4:
                        player.recover();
                        break;
                    default:
                        System.out.println("Invalid action. Please choose 1, 2, 3, or 4.");
                }
                if (!(resourceBreak)){
                    enemyisalive = enemy.Counterattack(player);
                }
                if (!player.isAlive()){
                    System.out.println("You have been defeated! Game Over.");
                    return;
                }
            }
            if (enemyCount < enemies.length){
                System.out.println("as you defeat the " + enemy.getName() + " hear a wisper in the wind, ");
                System.out.println("it's saying 'choose your reward, 1 for recovery and 2 for more power'");
                int choice = ConsoleChoice.read(console, 1, 2);
                while (true){   
                    if (choice == 1 || choice == 2)
                        break;
                    else{
                        System.out.println("Invalid action. Please choose 1 or 2.");
                        choice = ConsoleChoice.read(console, 1, 2);
                    }
                }
                Reward selectedReward = null;

                if (choice == 1) {
                    selectedReward = Reward.RECOVERY;
                } else if (choice == 2) {
                    selectedReward = Reward.POWER;
                }

                // עכשיו אפשר להשתמש ב-switch אלגנטי ונקי לפי ה-enum
                if (selectedReward != null) {
                    switch (selectedReward) {
                        case RECOVERY:
                            player.changeHP(25);
                            break;
                        case POWER:
                            player.changePower(12);
                            break;
                    }
                }
            }
        }
        console.close();
        System.out.println("You look around and see that all the enemies have been brutally defeated. You have won the game! but at the cost of your humanity. you don't deserve to be called by the name of "+player.getName()+" anymore. You are now a monster.");
    }
}