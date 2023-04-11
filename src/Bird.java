public class Bird extends Monster{
    protected final int experience = 50;
    public Bird(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }
    public int getExperience(){
        return experience;
    }
}
