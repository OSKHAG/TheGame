import java.util.logging.Level;

public class Player {
    private String name;
    private int health;
    private int fullHealth;
    private int attack;
    private int defense;
    private int experience;
    private int level;
    private int gold;

    public Player(String name, int health, int attack, int defense, int experience) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        fullHealth = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setExperience(int experience) {
        this.experience = experience;

        if (experience >= 100) {
            levelUp();
            this.experience = experience - 100;
        }
    }

    private void levelUp() {
        rest();
        level += 1;
        health = Helper.tenPercentStatIncrease(health);
        attack = Helper.tenPercentStatIncrease(attack);
        defense = Helper.tenPercentStatIncrease(defense);
        fullHealth = health;
        win();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void takeDamage(int damage) {
        damage = damage - defense;
        if (damage > 0) {
            this.health -= damage;
        }
    }
    public boolean isAlive() {
        return health > 0;
    }

    public void printStats() {
        System.out.println("Name : " + name +
                "\nHealth : " + health +
                "\nAttack : " + attack +
                "\nDefense : " + defense +
                "\nLevel : " + level +
                "\nExperience : " + experience +
                "\nGold : " + gold);
    }

    public void rest(){
        health = fullHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void gainGold(int goldGained){
        gold += goldGained;
    }
    public void win(){
        if(level == 10){
            System.out.println("You are now the strongest little mouse in the entire world, all birds will bow before you" +
                    "\nCongratulations and thank you for playing");
            System.exit(0);
        }
    }
}
