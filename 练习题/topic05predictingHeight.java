import java.util.Scanner;

public class topic05predictingHeight {
    public static void main(String[] args) {
       /* 其实我们可以通过父母的身高大致推断出子女的身高，假定父母与子女的身高遗传关系如下：
         儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
         女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2*/
        Scanner input = new Scanner(System.in);
        System.out.println("请输入孩子父亲身高为");
        float fatherHight = input.nextFloat();
        System.out.println("请输入孩子母亲的身高");
        float montherHight = input.nextFloat();


        float  sonHight =(float) ((fatherHight +montherHight)*1.08)/2;
        System.out.println("预测儿子的身高为"+sonHight );
        float daughterHight= (float) (((fatherHight * 0.923)+montherHight)/2);
        System.out.println("预测女儿的身高为"+daughterHight);


    }
}
