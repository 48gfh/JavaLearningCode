package com.GanBoss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 斗地主案列  按照斗地主的规则完成洗牌发牌的动作
 * - 准备牌：
 *   牌可以设计为一个ArrayList<String>,每个字符串为一张牌。
 *   每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
 *   牌由Collections类的shuffle方法进行随机排序。
 *
 * - 发牌 将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
 * - 看牌 直接打印每个集合。
 * */
public class demo01 {
    public static void main(String[] args) {
        ArrayList<String> color = new ArrayList<>(List.of("♠","♥","♣","♦"));//用于存储花色
        //System.out.println(color);
        ArrayList<String> number = new ArrayList<>(List.of("A","2","3","4","5","6","7","8","9","10","J","Q","k","大王","小王"));//存储牌号
        //System.out.println(number);
        ArrayList<String> poker = new ArrayList<>();//存储花色和牌号
        //玩家组
        ArrayList<String> player1 =new ArrayList<>();
        ArrayList<String> player2 =new ArrayList<>();
        ArrayList<String> player3 =new ArrayList<>();
        //特殊玩家
        ArrayList<String> player4 =new ArrayList<>();
        for (int i = 0; i < color.size(); i++) {
            for (int i1 = 0; i1 < number.size(); i1++) {
                String temp = color.get(i)+number.get(i1);
                poker.add(temp);
            }
        }
        //洗牌
        Collections.shuffle(poker);
        //System.out.println(poker);
        //发牌
        //System.out.println(poker.size());
        for (int i = 0; i < poker.size(); i++) {
            if(i>75){
                player4.add(poker.get(i));
            } else if (i%3==0) {
                player1.add(poker.get(i));
            } else if (i%3==1) {
                player2.add(poker.get(i));
            } else if (i%3==2){
                player3.add(poker.get(i));
            }
        }
        //遍历看牌
        System.out.println("player1的牌为"+player1);
        System.out.println("player2的牌为"+player2);
        System.out.println("player3的牌为"+player3);
        System.out.println("player4的牌为"+player4);


    }
}
