package com.kgc.util;

import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FastDfsUtil {
    @Value(value = "${nginx.fastdfs.address}")
    private String nginx_fastdfs_address;
    @Value(value = "${nginx.fastdfs.port}")
    private String nginx_fastdfs_port;

    /**
     * @param bs      上传文件的二进制数据
     * @param expname 上传文件的扩展名  jpg  png
     * @return 返回上传文件的路径: http://localhost:8080/组名/文件名...
     */
    public String uploadFile(byte[] bs, String expname) {
        String filePath = null;
        //1.加载属性
        try {
            ClientGlobal.init("fastdfs.properties");
            //2.创建tracker服务器对象
            TrackerClient client = new TrackerClient();
            TrackerServer trackerServer = client.getConnection();
            //3.创建storage客户端
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            //4.上传图片
            String[] infos = storageClient.upload_file(bs, expname, null);
            filePath = nginx_fastdfs_address + ":" + nginx_fastdfs_port + "/" + infos[0] + "/" + infos[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}