package LinkedList;

import Goods.*;



/**
 * 一个data域，一个指针next域
 * data域 存储货物goods，所以为Goods类
 * 指针next域 存储下一个节点的地址，所以为Node型
 */
public class Node {

    public Goods data;
    public Node next;


    /**
     * 默认无参数构造方法
     * 由于已经定义了有参的构造方法，所以系统不会再默认调用无参的构造方法
     * 因此我们要自己定义无参的构造方法，”方法体为空“即可，do nothing
     * <p>
     * data域为0，next域为空null
     * <p>
     * 给节点的next指针用于实例化
     */
    public Node() {
    }

    /**
     * @param data 对象实际上就是指针
     *             一个data域，一个指针next域
     *             data的数据类型为Goods类
     */
    public Node(Goods data) {

        this.data = data;
        next = new Node();

    }


    /**
     * @return 查
     * 获取节点中的data，获取货物
     */
    public Goods getData() {
        return data;
    }


    /**
     * @param goods
     */
    public void setData(Goods goods) {
        this.data = goods;
    }

    /**
     * @return 获取下一个节点，只需要返回指针next域即可
     */
    public Node getNode() {
        return next;
    }

    /**
     * @param goods 增
     *              设置新节点,存储货物，并且实例化对象
     */
    public void setNewNode(Goods goods) {
        next.data = goods;
        next.next = new Node();
    }

    /**
     * @return 删
     * 返回下一个节点的data，并连接下下个节点
     */
    public Goods delNode() {
        next = next.next;
        return next.data;
    }

    /**
     * @param goods 改
     *              只需要修改data即可
     */
    public void setNode(Goods goods) {
        next.data = goods;
    }


}

