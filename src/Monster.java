public class Monster {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int experience;

    public Monster(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
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

    public void takeDamage(int damage) {
        damage = damage - defense;
        if (damage > 0) {
            this.health -= damage;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getExperience() {
        return experience;
    }

    public void setDifficulty(int level) {
        for (int i = 0; i <= level ; i++) {
            health = Helper.tenPercentStatIncrease(health);
            attack = Helper.tenPercentStatIncrease(attack);
            defense = Helper.tenPercentStatIncrease(defense);
        }
        System.out.println(health);
    }
}