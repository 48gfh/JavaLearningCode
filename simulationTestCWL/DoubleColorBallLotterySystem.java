package com.learning.simulationTestCWL;

import java.util.*;


public class DoubleColorBallLotterySystem {
    public static void main(String[] args) {
        int count=0;
        Scanner sc = new Scanner(System.in);
        //定义彩票数组
        int[] arrNumber = new int[7];
        out1:
        while (true) {
            System.out.println("-------------欢迎进入双色球彩票系统-----------------");
            System.out.println("1.购买彩票");
            System.out.println("2.查看开奖");
            System.out.println("3.退出");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("双色球彩票系统>>>>购买彩票");
                    System.out.println("请录入你需要购买几张彩票");
                    count = sc.nextInt();
                    for (int i = 0; i < arrNumber.length; i++) {
                        if (i <= 5) {
                            System.out.println("请输入第" + (i + 1) + "红球的号码：（红球的数字为1-33）");
                            int redBallData = sc.nextInt();
                            arrNumber[i] = redBallData;
                        } else {
                            System.out.println("请输入蓝球的号码：（篮球的数字为1-16）");
                            int redBallData = sc.nextInt();
                            arrNumber[i] = redBallData;
                        }
                    }
                    System.out.println("您购买了"+count+"注，共消费"+(count*2)+"您购买的号码是"+Arrays.toString(arrNumber));
                    break;
                case 2:
                    System.out.println("双色球彩票系统>>>>查看开奖");
                    //中奖彩票号码
                    int[] luckData = getLuckBall();
                    //购买彩票号码
                    int level = getLevel(arrNumber, luckData);
                    //中奖号码与彩票号码进行比较
                    switch (level) {
                        default:
                            System.out.println("感谢你为中国福利彩票做出的贡献");
                            break;
                        case 1:
                            System.out.println("恭喜你，中了一等奖，每注中奖金额是100万元，您的奖金是： "+count*100+"万元");
                            break;
                        case 2:
                            System.out.println("恭喜你，中了二等奖，每注中奖金额是30万元，您的奖金是： "+count*30+"万元");
                            break;
                        case 3:
                            System.out.println("恭喜你，中了三等奖，每注中奖金额是10万元，您的奖金是： "+count*10+"万元");
                            break;
                        case 4:
                            System.out.println("恭喜你，中了四等奖，每注中奖金额是2万元，您的奖金是： "+count*2+"万元");
                            break;
                        case 5:
                            System.out.println("恭喜你，中了五等奖，每注中奖金额是3000元，您的奖金是： "+count*3000+"元");
                            break;
                        case 6:
                            System.out.println("恭喜你，中了一等奖，每注中奖金额是5元，您的奖金是： "+count*5+"元");
                            break;
                    }

                    break;
                case 3:
                    System.out.println("双色球彩票系统>>>>退出");
                    break out1;
            }
        }
    }

    //获取中将号码 将获取中奖号码的逻辑抽取为一个方法
    public static int[] getLuckBall() {
        int[] luckData = new int[7];
        for (int i = 0; i < 7; i++) {
            if (i < 6) {
                //生成6个红色号码范围是：（1-33）
                Random rd = new Random();
                int fillRedData = rd.nextInt(1, 33) + 1;
                luckData[i] = fillRedData;
            } else {
                Random rd = new Random();
                int fillBlueData = rd.nextInt(1, 16) + 1;
                luckData[i] = fillBlueData;
            }
        }
        System.out.println("中奖号码为：" + Arrays.toString(luckData));
        return luckData;
    }

    //比较的逻辑单独抽取为一个方法
    public static int getLevel(int[] balls, int[] luckBall) {
        /**定义计数器，计红球有几个相等的、篮球有几个相等的
         将购买的球号一一与中奖号码进行对比*/
        int redCount = 0;
        int blueCount = 0;
        int level=0;
        for (int i = 0; i < balls.length - 1; i++) {
            //对红色数字部分进行比较
            if (i <= 5) {
                for (int i1 = 0; i1 <= 5; i1++) {
                    if (balls[i1] == luckBall[i1]) {
                        redCount++;
                    }
                }
            } else {
                //对蓝色部分进行比较
                if (balls[i] == luckBall[i]) {
                    blueCount++;
                }
            }
        }
        if (redCount == 6 && blueCount == 1) {
            level=1;
        } else if (redCount==6 && blueCount==0) {
            level=2;
        } else if (redCount==5 && blueCount==1) {
            level=3;
        } else if (redCount==5 || (redCount==4&&blueCount==1)) {
            level=4;
        } else if (redCount==4 || (redCount==3&&blueCount==1)) {
            level=5;
        } else if (blueCount==1) {
            level=6;
        }

        return level;
    }

}
