/**
 * 定义一个Pizza父类包括所有pizza共同的属性和方法
 * */
public abstract class FatherPizza {
    //pizza 的基本属性
    private String pizzaName;
    private int size;
    private double price;

   //展示pizza信息
   public abstract void display();


   //构造器
    public FatherPizza(double price, int size, String pizzaName) {
        this.price = price;
        this.size = size;
        this.pizzaName = pizzaName;
    }

    //设置get和set方法
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getpizzaName() {
        return pizzaName;
    }

    public void setpizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
