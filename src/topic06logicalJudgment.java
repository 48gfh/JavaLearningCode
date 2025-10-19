public class topic06logicalJudgment {
    public static void main(String[] args) {
    /*    已知小红同学有25元，她攒了几天钱之后发现自己的现在的钱比原来的2倍还多出10块。
        而小蓝同学有30元，他攒了几天钱之后发现自己的钱正好是原来的2倍。于是小胖说：小红和小蓝现在的钱一样多，请问，他说的对吗？*/

        int xiaoRed = 25;
        int xiaoBlue = 30;

        xiaoRed = (25*2)+10;
        xiaoBlue = 30*2;
        if(xiaoRed==xiaoBlue){
            System.out.println("小红攒的钱和小蓝一样多，说法正确");
        }else {
            System.out.println("小红攒的钱与小蓝不一样,说法错误");
        }


    }
}
