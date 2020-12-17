package machine;

public enum Coffee_Type {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    int WaterNeeded;
    int MilkNeeded;
    int BeansNeeded;
    int CupPrice;

    Coffee_Type(int waterNeeded, int milkNeeded, int beansNeeded, int cupPrice) {
        WaterNeeded = waterNeeded;
        MilkNeeded = milkNeeded;
        BeansNeeded = beansNeeded;
        CupPrice = cupPrice;
    }

    public int getWaterNeeded() {
        return WaterNeeded;
    }

    public int getMilkNeeded() {
        return MilkNeeded;
    }

    public int getBeansNeeded() {
        return BeansNeeded;
    }

    public int getCupPrice() {
        return CupPrice;
    }
}
