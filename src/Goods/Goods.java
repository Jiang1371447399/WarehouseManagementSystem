package Goods;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Goods {


    //    货物名，重量，体积，出仓时间，入仓时间
    public String name;
    public String weight;
    public String volume;


    public String inTime;
    public String outTime;


    public Goods() {


        Scanner in = new Scanner(System.in);


        System.out.print("货物名：");
        this.name = in.nextLine();

        System.out.print("重量（kg）：");
        this.weight = in.nextLine();

        System.out.print("体积(立方米)：");
        this.volume = in.nextLine();

//        获取系统时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        将系统时间赋给入仓时间
        inTime = format.format(date);

    }


    public void showGoods() {
        System.out.println("货物名：" + name);
        System.out.println("重量（kg）：" + weight);
        System.out.println("体积(立方米)：" + volume);
        System.out.println("入仓时间为：" + inTime);
        System.out.println();
    }

    public String outTime() {
        //        获取系统时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        将系统时间赋给出仓时间
        outTime = format.format(date);

        return outTime;
    }


}


