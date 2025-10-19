public class topic07optimalChoice {
    public static void main(String[] args) {
        /*某小伙想定一份外卖，商家的优惠方式如下：鱼香肉丝单点24元，油炸花生米单点8元，米饭单点3元。
        订单满30元8折优惠。鱼香肉丝优惠价16元，但是优惠价和折扣不能同时使用。那么这个小伙要点这三样东西，最少要花多少钱？*/
        double dish01 = 24.0;
        double dish02 = 8.0;
        double dish03 = 3.0;

        double  project01 = (dish01 + dish02 + dish03)*0.8;
        double project02 = (dish01 + 16 + dish03);

        if (project01 > project02) {
            System.out.println("选择方案2，方案2大概需要"+project02);
            System.out.println("最终花费"+project02);
        }else{
            System.out.println("选择方案1，方案1大概需要"+project01);
            System.out.println("最终花费"+project01);
        }


    }
}
