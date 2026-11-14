package edu.starter;

public class Enemy{
    private final String name;
    private int HP = 30;

    public Enemy(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }
    
    int getHP(){
        return this.HP;
    }

    String getName(){
        return this.name;
    }

    void changeHP(int amount){
        this.HP += amount;
        if (this.HP < 0)
            this.HP = 0;
    }

    boolean Counterattack(Player player){
        if (this.HP <= 0){
            System.out.println("The enemy is defeated!");
        return false;
        }
            if (player.isDefending()){
            System.out.println("You are defending! The enemy's attack was !");
            player.changeDefense(false);
            player.changeHP(-5);
        }
        else
            player.changeHP(-10);
        return true;
    }
}
