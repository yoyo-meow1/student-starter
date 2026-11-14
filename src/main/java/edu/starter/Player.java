package  edu.starter;

public class Player{
        private final String name;
        private int HP = 100;
        private int resource = 5;
        private int attackpower = 10;
        private boolean defense = false;

        public Player(String name, int HP, int resource, boolean defense, int attackpower) {
            this.name = name;
            this.HP = HP;
            this.resource = resource;
            this.defense = defense;
            this.attackpower = attackpower;
        }

        int getHP(){
            return this.HP;
        }

        String getName(){
            return this.name;
        }

        void attak(Enemy enemy){
            enemy.changeHP(-this.attackpower);
            System.out.println("You attacked the enemy! Enemy HP is now: " + enemy.getHP());
        }
        boolean Special(Enemy enemy){
            if (this.resource >= 3){
                enemy.changeHP(-15);
                this.resource -= 3;
                System.out.println("You used a special attack! Enemy HP is now: " + enemy.getHP());
                return false;
            }
            else {
                System.out.println("Not enough resources to use special attack!");
                return true;
            }
        }
        void changeDefense(boolean defense){
            this.defense = defense;
        }
        void changeHP(int amount){
            this.HP += amount;
            if (this.HP < 0)
                this.HP = 0;
            if (amount < 0)
                System.out.println("The enemy attacked you! Your HP is now: " + this.HP);
            else{
                if (this.HP > 100)
                    this.HP = 100;
                System.out.println("You feel butterflys on your skin, you got healed! Your HP is now: " + this.HP);
            }
        }
        void changePower(int power){
            this.attackpower = power;
            System.out.println("You gained more power!");
        }
        boolean isDefending(){
            return this.defense;
        }
        void recover(){
            this.resource += 3;
            if (this.resource > 10)
                this.resource = 10;
            System.out.println("You recovered resources! Your resources are now: " + this.resource);
        }
        boolean isAlive(){
            return this.HP > 0;
        }

    }