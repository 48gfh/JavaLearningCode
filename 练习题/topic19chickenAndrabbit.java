public class topic19chickenAndrabbit {
    public static void main(String[] args) {
        /*已知:鸡兔共35只,共94只脚,那么鸡和兔各几只?*/
        int num=35;
        int feet = 94;
        for (int i = 0; i < num; i++) {
            int rabbit = num-i;
            if (i * 2 + rabbit * 4 == feet) {
                System.out.println("鸡的数量是" + i + "，兔子的数量是" + rabbit);
            }


        }
    }
}
