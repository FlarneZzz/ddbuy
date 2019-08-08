package com.kgc.solr;

import org.csource.fastdfs.*;

/**
 * @author 王建兵
 * @Classname Test1
 * @Description TODO
 * @Date 2019/7/27 10:54
 * @Created by Administrator
 */
public class Test2 {
    //使用java程序删除图片到Fastdfs
    public static void main(String[] args) {
       //使用api操作Fastdfs
        try {
            //1.加载属性
            ClientGlobal.init("fastdfs.properties");
            //2.创建tracker服务器对象
            TrackerClient client=new TrackerClient();
            TrackerServer trackerServer=client.getConnection();
            //3.创建storage客户端
            StorageServer storageServer=null;
            StorageClient storageClient=new StorageClient(trackerServer,storageServer);
            //4.删除图片
            //storageClient.delete_file("组名","文件位置");
            int temp=storageClient.delete_file("group1","M00/00/00/wKgBHl09EmqAKzTDAACdwjt8POc292.jpg");

            System.out.println("删除成功:"+temp);
            //5.关闭
            trackerServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
