public class BigBird extends Bird{
    private final int experience = 80;
    public BigBird(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }
    public int getExperience(){
        return experience;
    }
}
