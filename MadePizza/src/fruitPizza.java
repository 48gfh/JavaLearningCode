public class fruitPizza extends FatherPizza{

    private String dosing;



    public String getDosing() {
        return dosing;
    }

    public void setDosing(String dosing) {
        this.dosing = dosing;
    }


    @Override
    public void display() {
        System.out.println("您订购的Pizza是"+getpizzaName()+"价格是："+getPrice()+"大小"+getSize()+"");
    }

    public fruitPizza(double price, int size, String pizzaName, String dosing) {
        super(price, size, pizzaName);
        this.dosing = dosing;
    }
}
