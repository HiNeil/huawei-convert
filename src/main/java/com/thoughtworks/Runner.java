package com.thoughtworks;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        Scanner input = new Scanner(System.in);
        System.out.println("输入'true'继续，输入'false'停止");
        Boolean go = input.nextBoolean();
        while (go) {
            System.out.println("请输入币种 EUR/USD/CNY/HKD/JPY");
            String currency = input.next();
            System.out.println("请输入额度");
            Integer amount = input.nextInt();
            System.out.println("请输入转换类型 0：向面额小方向转换，1：相面额大方向转换");
            Integer type = input.nextInt();
            try {
                convertor.convert(currency, amount, type);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("输入'true'继续，输入'false'停止");
            go = input.nextBoolean();
        }
    }
}
