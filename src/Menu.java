public class Menu {
    static Player player = new Player("Fred the tiny mouse", 150, 20, 15, 0);

    public static void startMenu() {
        while (true) {
            printMenuOptions();
            switch (Helper.integerInput(4)) {
                case 1 -> {
                    System.out.println("You leave home to search for danger..");
                    Fight fight = new Fight(player);
                    player = fight.fightMenu();
                }
                case 2 -> {
                    Shop shop = new Shop(player);
                    player = shop.shopMenu();
                }
                case 3 -> player.printStats();
                case 4 -> {
                    System.out.println("The birds are laughing in the distance, they've won" +
                            "\nExiting...");
                    System.exit(0);
                }
            }
        }
    }
    public static void printMenuOptions() {
        System.out.println("1. Leave your safe home in search for danger, all birds must perish" +
                "\n2. Visit Mama Yama's Amulet Shop" +
                "\n3. Show Fred the little mouse's statistical attributes" +
                "\n4. Quit the game in shame.");
    }
}

