package ListFile;

import LinkedList.*;

import java.io.*;

public class ListFile {


    /**
     * 为链表创建文件
     *
     * @param head 为哪个链表建文件
     */
    public ListFile(Node head) {

//        节点指针
        Node s = null;


        try {

//            仓库文件夹
            File folder = new File("d:\\WareHouse", "仓库货物清单");

//            创建仓库文件夹
            if (!folder.exists()) folder.mkdir();

//            清理旧文件
            if (folder.length() != 0) delFiles(head, folder);


//            货物文件
            File file;

            s = head;
            while (s.next != null) {

                s = s.next;

//                创建货物文件
                file = new File("d:\\WareHouse\\仓库货物清单", s.data.name + ".txt");
                if (!file.exists()) file.createNewFile();

//                写文件
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("货物名：");
                bw.write(s.data.name);
                bw.newLine();

                bw.write("重量（kg）：");
                bw.write(s.data.weight);
                bw.newLine();

                bw.write("体积(立方米)：:");
                bw.write(s.data.volume);
                bw.newLine();

                bw.write("入仓时间为:");
                bw.write(s.data.inTime);
                bw.newLine();

                bw.close();


            }

        }
//        SecurityException和IOException是一样的？
        catch (IOException | SecurityException e) {
            e.printStackTrace();
        }


    }

    /**
     * @param head 展示文件列表
     */
    public void showFiles(Node head) {

        File folder = new File("d:\\WareHouse\\仓库货物清单");
        String[] fileList = folder.list();

        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }

    //    删除货物清单中不存在的文件
    public void delFiles(Node head, File folder) {

//        数组fileList中存放文件夹中”所有文件的文件名“，即fileName
        String[] fileList = folder.list();

        Node s = head.next;

//        assert坚称，断言，坚持自己的主张
//        为了防止数组为空，发生NullPointException,空指针异常，从而无法循环
//        但是调用这个方法前，已经判断了文件夹中不为空
        assert fileList != null;

//        教材p75，数组的遍历
//        专门用于数组循环，可以避免越界
//        fileList是数组名，fileName是新定义的”数组元素变量名“，即把数组元素的值依次赋给fileName
        for (String fileName : fileList) {

            while (s.next != null & !fileName.equals(s.data.name + ".txt")) {
                s = s.next;
            }
            if (s.next == null) {
                File delFile = new File("d:\\WareHouse\\仓库货物清单\\" + fileName);
                boolean result = delFile.delete();
            }
        }
    }


}








