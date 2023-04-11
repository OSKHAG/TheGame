public class Shop {

    final Player p;

    private final int price = 50;


    public Shop(Player p) {
        this.p = p;
    }


    public Player shopMenu() {
        System.out.println("Welcome to Mama Yama's shop, Amulets cost 50 gold");
        boolean leave = false;
        while (!leave) {
            printShopMenuOptions();
            switch (Helper.integerInput(3)) {
                case 1 -> buyAttackAmulet();
                case 2 -> buyDefenseAmulet();
                case 3 -> leave = true;
            }
        }
        System.out.println("You leave the shop...");
        return p;

    }

    public void printShopMenuOptions() {
        System.out.println(
                "\nYou have " + p.getGold() + " Gold" +
                        "\n1. Buy an Attack Amulet" +
                        "\n2. Buy a Defense Amulet" +
                        "\n3. Leave Shop");
    }

    public boolean verifyGold(int gold) {
        return gold > price;
    }

    public void buyAttackAmulet() {
        boolean goldStatus = verifyGold(p.getGold());
        if (!goldStatus) {
            notEnoughGold();
        }
        if (goldStatus) {
            enoughGold();
            transaction();
            getAttackAmulet();
        }
    }

    public void buyDefenseAmulet() {
        boolean goldStatus = verifyGold(p.getGold());
        if (!goldStatus) {
            notEnoughGold();
        }
        if (goldStatus) {
            enoughGold();
            transaction();
            getDefenseAmulet();
        }
    }

    public void notEnoughGold() {
        System.out.println("Not enough gold good sir" +
                "\nAnything else?");
    }

    public void enoughGold() {
        System.out.println("Thank you for your purchase" +
                "\nAnything else?");
    }

    public void transaction() {
        p.setGold(p.getGold() - price);
    }

    public void getAttackAmulet() {
        p.setAttack(p.getAttack() + 10);
    }

    public void getDefenseAmulet() {
        p.setDefense(p.getDefense() + 10);
    }
}

