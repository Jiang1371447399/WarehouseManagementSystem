//package WareHouse;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//
//import Goods.*;
//
//
//public class WareHouse {
//
//
//    public double allVolume;
//    public double usedVolume;
//    public double usableVolume;
//    public static int houseNum;
//    public int inNum;
//    public WareHouse[] houseList;
//
//    //    每个仓库最多只能放50个货物
//    public Goods[] goodsList = new Goods[50];
//
//    //    实例化数组
//    public void goodsList() {
//        for (int i = 0; i < goodsList.length; i++) {
//            goodsList[i] = new Goods();
//        }
//    }
//
//
////        建造单个仓库
//
//    public WareHouse() {
//
//        inNum = 0;
//
//        goodsList();
//
//        Scanner in = new Scanner(System.in);
//
//        allVolume = in.nextDouble();
//        usableVolume = allVolume;
//        usedVolume = 0;
//
//    }
//
////        建造多个仓库
//
//    public WareHouse(int houseNum) {
//
//        WareHouse.houseNum = houseNum;
//        houseList = new WareHouse[houseNum];
//
////        实例化数组
//        for (int i = 0; i < houseNum; i++) {
//
//            System.out.print("开始建仓，请输入第" + (i + 1) + "个仓库仓库的容积（立方米）：");
//            houseList[i] = new WareHouse();
//            System.out.println("第" + (i + 1) + "个仓库已建好");
//
//        }
//
//
//    }
//
//    //            入仓
//    public void inHouse(Goods goods, int no) {
//
//        int index = houseList[no].inNum;
//
//
//        if (isFull(goods, no)) {
//
//            System.out.println("货物太大，无法放入该仓库");
//
//        } else {
//
//            houseList[no].goodsList[index] = goods;
//            System.out.println("成功放入！");
//
//            houseList[no].inNum++;
//
//        }
//
//
//    }
//
//
//    //        判断仓是否已经满了
//    public boolean isFull(Goods goods, int no) {
//
//
//        if (goods.volume > houseList[no].usableVolume) {
//            return true;
//
//        } else {
//
//            houseList[no].usedVolume += goods.volume;
//            houseList[no].usableVolume = houseList[no].allVolume - houseList[no].usedVolume;
//
//            return false;
//        }
//
//
//    }
//
//
////        生成货物清单
//
//    public void makeList() {
//
////        仓库编号
//        int no = 0;
//
//        Scanner in = new Scanner(System.in);
//        System.out.print("生成哪个仓库的清单：");
//        no = in.nextInt();
//
////        仓库文件夹
//        File file1 = new File("d:\\WareHouse", "仓库" + no + "货物清单");
//
////        货物文件
//        File file2 = new File("d:\\WareHouse\\仓库" + no + "货物清单", "1.txt");
//
//        try {
//
//            if (!file1.exists()) {
//                file1.mkdir();
//            }
//
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("清单已生成！");
//
//    }
//
////    查看仓库数量
//
//    public int showHouse() {
//
//        return houseNum;
//
//    }
//
//    //    查看清单
//    public void showList() {
//
//        Scanner in = new Scanner(System.in);
//
//
//        File file = new File("d:\\WareHouse\\仓库" + in.nextInt() + "货物清单");
//    }
//}
