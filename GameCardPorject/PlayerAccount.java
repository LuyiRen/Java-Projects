public class PlayerAccount {
    private double money;
    private static String name;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addmoney(double money){
        this.money = this.money+money;
    }
    public void lostmoney(double money){
        this.money = this.money-money;
    }
}
