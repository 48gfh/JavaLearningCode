public class topic12optimalChoice {
   /* 小蓝同学想买一个价值8888元的新手机，她的旧手机在二手市场能卖1880元，
    而手机专卖店推出以旧换新的优惠，把她的旧手机交给店家，新手机就能够打7.5折优惠。为了更省钱，小蓝要不要以旧换新？*/
    public static void main(String[] args) {

        double planA= 8888*0.75;
        double planB= 8888-1880;
        if(planA>planB){
            System.out.println("依旧换新更省钱");
        }else {
            System.out.println("旧手机买了更值钱");
        }

    }
}
