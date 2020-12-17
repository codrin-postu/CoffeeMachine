package machine;

import java.util.Scanner;


public class CoffeeMachine {
    Scanner scanner;
    int waterAmount;
    int milkAmount;
    int beanAmount;
    int cupsAmount;
    int moneyAmount;


    public CoffeeMachine() {
        scanner = new Scanner(System.in);
        this.waterAmount = 400;
        this.milkAmount = 540;
        this.beanAmount = 120;
        this.cupsAmount = 9;
        this.moneyAmount = 550;
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

    private void nextCommand() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        switch (scanner.next()) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                machineAmount();
                break;
            case "exit":
                return;
        }
        nextCommand();
    }

    public void buyCoffee() {
        int coffees = 0;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menu: ");
        String input = scanner.next();
        if (input.equals("back")) {
            return;
        }
        switch (Integer.parseInt(input)) {
            case 1:
                makeCoffee(1, Coffee_Type.ESPRESSO);
                break;
            case 2:
                makeCoffee(1, Coffee_Type.LATTE);
                break;
            case 3:
                makeCoffee(1, Coffee_Type.CAPPUCCINO);
        }

//        if (checkEnoughIngredients(coffees)) {
//            System.out.print("Yes, I can make that amount of coffee");
//            int maxCoffeeCups = getMaxCoffeeCups();
//            if (maxCoffeeCups > coffees) {
//                System.out.println(" (and even " + (maxCoffeeCups - coffees) + " more than that)");
//            }
//        } else {
//            System.out.println("No, I can make only " + getMaxCoffeeCups() + " of coffee");
//        }
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

    private boolean checkEnoughIngredients(int coffees, Coffee_Type type) {
        boolean enoughIngredients = true;

        if (coffees * type.getWaterNeeded() > waterAmount ||
                coffees * type.getMilkNeeded() > milkAmount ||
                coffees * type.getBeansNeeded() > beanAmount ||
                coffees > cupsAmount) {
            enoughIngredients = false;
        }

        return enoughIngredients;
    }

    public void machineAmount() {
        System.out.println("The coffee machine has:\n" +
                waterAmount + " of water\n" +
                milkAmount + " of milk\n" +
                beanAmount + " of coffee beans\n" +
                cupsAmount + " of disposable cups\n" +
                moneyAmount + " of money\n");
    }

    private void makeCoffee(int cupsToMake, Coffee_Type type) {
        if (checkEnoughIngredients(cupsToMake, type)) {
            System.out.println("I have enough resources, making you a coffee!");

            waterAmount -= type.getWaterNeeded();
            milkAmount -= type.getMilkNeeded();
            beanAmount -= type.getBeansNeeded();
            cupsAmount -= cupsToMake;
            moneyAmount += type.getCupPrice();
        } else {
            System.out.println("Sorry not enough resources!");
        }
    }

    public void takeMoney() {
        System.out.println("I gave you " + moneyAmount);
        moneyAmount = 0;
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        waterAmount += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milkAmount += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beanAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cupsAmount += scanner.nextInt();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.nextCommand();
    }
}
