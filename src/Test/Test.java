package Test;


import LinkedList.*;
import ListFile.ListFile;


public class Test {

    public static void main(String[] args) {

        Node head = new Node();
        head.next = null;

        List list = new List(head);

//        list.delList(head);

        list.showList(head);

        ListFile listFile = new ListFile(head);

        listFile.showFiles(head);

//        list.insertList(head);

//        list.showList(head);

//        list.searchList(head);

//        list.locateList(head);

//        listFile=new ListFile(head);


    }

}
