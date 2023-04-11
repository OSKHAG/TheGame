import java.util.NoSuchElementException;

public class Fight {

    final Player p;
    final Bird bird = new Bird("Small Bird", 50, 15, 10);
    final BigBird bigBird = new BigBird("Big Bird", 75, 15, 12);

    final Monster enemy;

    public Fight(Player p) {
        this.p = p;
        if (Helper.diceRoll()) {
            enemy = bird;
        } else {
            enemy = bigBird;
        }
        enemy.setDifficulty(p.getLevel());
    }

    public Player fightMenu() {
        boolean endFight = false;
        System.out.println("You run into a " + enemy.getName());
        while (!endFight) {
            try {
                printFightOptions();
                int val = Helper.integerInput(2);
                switch (val) {
                    case 1 -> {
                        attack();
                        if (!enemy.isAlive()) {
                            System.out.println(enemy.getName() + " is dead");
                            returningHome();
                            rewards();
                            endFight = true;
                        }
                        if (!p.isAlive()) {
                            System.out.println("You're dead, better luck next time");
                            System.exit(0);
                        }
                    }
                    case 2 -> {
                        returningHome();
                        endFight = true;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Something went wrong try again");
            }
        }
        return p;
    }

    public void attack() {
        if (Helper.diceRoll()) {
            System.out.println("You hit " + enemy.getName() + " really hard");
            enemy.takeDamage(p.getAttack());
        } else {
            System.out.println("You hit " + enemy.getName());
            enemy.setHealth(enemy.getHealth() - ((p.getAttack() / 2) - (enemy.getDefense() / 2)));
            enemy.takeDamage(p.getAttack() / 2);
        }
        if (Helper.diceRoll()) {
            System.out.println("You get hit by " + enemy.getName() + " really hard");
            p.takeDamage(enemy.getAttack());
        } else {
            System.out.println("You get hit by " + enemy.getName());
            p.takeDamage(enemy.getAttack() / 2);
        }

    }

    public void rewards() {
        getGold();
        getExperience();
    }

    public void getExperience() {
        p.setExperience(p.getExperience() + enemy.getExperience());
    }

    public void getGold() {
        p.gainGold(enemy.getAttack());
    }

    public void printFightOptions(){
        System.out.println("1. Attack" +
                "\n2. Run away, like a coward");
    }

    public void returningHome(){
        System.out.println("Returning home..");
        System.out.println("You rest and your health regenerates");
        p.rest();
    }
}
