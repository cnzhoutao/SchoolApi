package com.zt.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;

import java.io.InputStream;
import java.util.List;

/**
 * 阿里云对象存储工具类
 */
public class UploadUtil {

    private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";

    private static String accessKeyId = "LTAIdK2pZI2HWZiN";

    private static String accessKeySecret = "X106ovBnsyTyIzwTCaByNEDwGd6tCt";


    private static String bucketName = "graduate-zt";

    /**
     * 用流的方式上传图片到oss
     *
     * @param name
     * @param inputStream
     */
    public static void uploadImage(String name, InputStream inputStream) {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, name, inputStream);

        ossClient.shutdown();
    }

    /**
     * 根据图片名称，删除多张图片
     *
     * @param keys
     */
    public static void deleteMultiImg(List<String> keys) {

        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        try {
            DeleteObjectsResult deleteObjectsResult = client.deleteObjects(

                    new DeleteObjectsRequest(bucketName).withKeys(keys));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
            for (String object : deletedObjects) {
                System.out.println("\t" + object);
            }
            System.out.println();

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } finally {
            client.shutdown();
        }

    }
}
