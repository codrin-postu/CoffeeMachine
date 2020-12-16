package machine;

import java.util.Scanner;


public class CoffeeMachine {
    Scanner scanner;
    int waterAmount;
    int milkAmount;
    int beanAmount;


    public CoffeeMachine() {
        scanner = new Scanner(System.in);
        this.waterAmount = 0;
        this.milkAmount = 0;
        this.beanAmount = 0;
    }


    private static void neededIngredients(int coffees) {
        int water = coffees * 200;
        int milk = coffees * 50;
        int beans = coffees * 15;
        System.out.println("For " + coffees + " cups of coffee you will need:\n" +
                +water + " ml of water\n" +
                +milk + " ml of milk\n" +
                +beans + "375 g of coffee beans");
    }

    public void requestCoffee() {
        Scanner scanner = new Scanner(System.in);
        int coffees = 0;

        System.out.println("Write how many cups of coffee you will need:");
        if (scanner.hasNextInt()) {
            coffees = scanner.nextInt();
        } else {
            System.out.println("Incorrect input!");
        }

        if (checkEnoughIngredients(coffees)) {
            System.out.print("Yes, I can make that amount of coffee");
            int maxCoffeeCups = getMaxCoffeeCups();
            if (maxCoffeeCups > coffees) {
                System.out.println(" (and even " + (maxCoffeeCups - coffees) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + getMaxCoffeeCups() + " of coffee");
        }
    }

    private int getMaxCoffeeCups() {
        int maxCoffeeCount = 0;

        maxCoffeeCount = waterAmount / 200;
        if (maxCoffeeCount > milkAmount / 50) {
            maxCoffeeCount = milkAmount / 50;
        }
        if (maxCoffeeCount > beanAmount / 15) {
            maxCoffeeCount = beanAmount / 15;
        }
        return maxCoffeeCount;
    }

    private boolean checkEnoughIngredients(int coffees) {
        boolean enoughIngredients = true;

        if (coffees * 200 > waterAmount || coffees * 50 > milkAmount || coffees * 15 > beanAmount) {
            enoughIngredients = false;
        }

        return enoughIngredients;
    }

    private void makingCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        beanAmount = scanner.nextInt();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.fillMachine();
        coffeeMachine.requestCoffee();
    }
}
