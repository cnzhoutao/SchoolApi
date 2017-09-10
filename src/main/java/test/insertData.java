package test;

import com.google.gson.Gson;
import com.zt.entity.School;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URLDecoder;

public class insertData {


    public static JSONObject httpGet(String url){

        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/

                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");

        } catch (IOException e) {
            System.err.println("get请求提交失败:" + url);
        }
        return jsonResult;
    }


    public static void main(String []args){

        School sch = new Gson().fromJson(httpGet("file:///Users/user/Desktop/index.html").toString(), School.class);

        System.err.println(sch.getCampus().get(0).getAnhui().get(0));
    }



}
