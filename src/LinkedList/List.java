package LinkedList;

import Goods.Goods;

import java.util.Scanner;

/**
 * n:链表节点数量（仓库货物数量）
 */
public class List {


    public int n;


    /**
     * @paramn 尾插法建表，这样可以实现物理顺序和逻辑顺序相同
     * 一个头节点head,一个尾节点last
     */
    public List(Node head) {


//        声明尾指针
        Node last;

//        尾指针指向头指针(尾指针保存头指针的地址)，此时头指针为旧节点，即”尾指针指向的节点“
        last = head;

        Scanner in = new Scanner(System.in);

        System.out.print("放入几个货物：");
        n = in.nextInt();
//        防止输入出错
        while (n <= 0) {
            System.out.println();
            System.out.print("输入错误，请重新输入:");
            n = in.nextInt();
        }


//        建表
        for (int i = 1; i <= n; i++) {

//            实例化货物goods，输入货物信息
            Goods goods = new Goods();

//            存入节点node
            Node node = new Node(goods);

            // last连接新节点，连接好之后该节点就是旧节点了
            // 此时要插入一个新节点，则旧节点为"尾指针指向的节点"，即last
            //先旧节点next连接新节点,再尾节点next连接
            node.next = null;
            last.next = node;
            last = node;

            System.out.println();
            System.out.println("第" + i + "个货物已放入！");
            System.out.println();


        }


        System.out.println("完成！");
        System.out.println();

    }


    /**
     * @param head 哪个链表
     *             展示链表
     */
    public void showList(Node head) {

        System.out.println("----------货物清单-------------");

        Node s = head;
        while (s.next != null) {
            s = s.next;
            s.data.showGoods();
        }

        System.out.println("------------------------------");

    }


    /**
     * @param head 哪个链表
     */
    public void insertList(Node head) {

        n++;

        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("请输入放入位置：");
        int index = in.nextInt();

        Node s = head;
//        注意这里要定位到插入点前一个节点
        for (int i = 0; i < index - 1; i++) {
            s = s.next;
        }

//        先新节点连后继节点，防止丢失,再前驱节点连新节点
        Goods goods = new Goods();
        Node node = new Node(goods);

        node.next = s.next;
        s.next = node;

        System.out.println("成功放入！");
        System.out.println();

    }

    /**
     * @param head 哪条链表
     */
    public void delList(Node head) {

        n--;

        Scanner in = new Scanner(System.in);

        System.out.print("请输入拿出位置：");
        int index = in.nextInt();

//        while (index <= 0) {
//            System.out.println();
//            System.out.print("输入错误，请重新输入:");
//            index = in.nextInt();
//        }

        Node s = head;
//        注意这里要定位到插入点前一个节点
        for (int i = 0; i < index - 1; i++) {
            s = s.next;
        }

//        待删除的节点
        Node delNode = s.next;

        s.next = s.next.next;

        delNode.data.showGoods();
        System.out.println("出仓时间为："+delNode.data.outTime());

        delNode.next = null;
//      怎么销毁来着？

        System.out.println("成功拿出！");
        System.out.println();


    }


    /**
     * @param head 哪条链表
     */
    public void searchList(Node head) {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入查找位置：");
        int index = in.nextInt();

        Node s = head;
        for (int i = 0; i < index; i++) {
            s = s.next;
        }

        s.data.showGoods();
        System.out.println();

    }

    /**
     * 按值查找位置
     *
     * @param head 哪条链表
     */
    public void locateList(Node head) {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入货物名：");
        String name = in.nextLine();

        //这里注意要从第一个节点开始！！！
        int index = 1;
        Node s = head.next;
        while (s.next != null & !(s.data.name.equals(name))) {
            s = s.next;
            index++;
        }
        if (s.next == null) {
            System.out.println("仓库里并没有该货物！");
        } else {
            System.out.println("找到了！在第" + index + "个");
        }
    }

    /**
     * @param head 哪条链表
     *             表长
     */
    public void listLength(Node head) {
        System.out.println("仓库里有" + n + "个货物");
    }


    /**
     * @param head 到达链表的指定位置模板
     */
    public void forTraversal(Node head) {

        Scanner in = new Scanner(System.in);

        System.out.println("请输入位置：");
        int index = in.nextInt();

        Node s = head;
        for (int i = 0; i < index; i++) {
            s = s.next;
        }

    }

    /**
     * @param head 链表的遍历
     */
    public void whileTraversal(Node head) {

        Node s = head;
        while (s.next != null) {
            s = s.next;
        }
    }

    public void showN(){
        System.out.println("仓库中有"+n+"件货物");
    }

}


//可能会出现输入的错误try……catch
//不能在最后插入
//最后一个节点，删除不一样