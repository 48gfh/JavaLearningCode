public class baconPizza extends FatherPizza{


    public baconPizza(double price, int size, String pizzaName, double weight) {
        super(price, size, pizzaName);
        this.weight = weight;
    }



    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;




    @Override
    public void display() {
        System.out.println("您订购的Pizza是"+getpizzaName()+"价格是："+getPrice()+"大小"+getSize()+"培根克数"+getWeight());
    }


}
