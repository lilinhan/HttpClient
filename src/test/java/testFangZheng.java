import com.gargoylesoftware.htmlunit.WebClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.omg.CORBA.NameValuePair;

import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.net.CookieStore;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lewin on 15-3-29.
 */
public class testFangZheng {
    public static void main(String[] args) throws IOException {
        String userName = "04133088";
        String passWord = "l187175";

        String loginURL = "http://222.24.19.201/default_ysdx.aspx";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(loginURL);
        List Data = new ArrayList();
        Data.add(new BasicNameValuePair("__VIEWSTATE","dDw1MjQ2ODMxNzY7Oz4AG9yzNM0K25AybGLl5cV/3NvN4g=="));
        Data.add(new BasicNameValuePair("TextBox1","04133088"));
        Data.add(new BasicNameValuePair("TextBox2","l187175"));
        Data.add(new BasicNameValuePair("RadioButtonList1","学生"));
        Data.add(new BasicNameValuePair("Button1","  登录  "));

        httpPost.setEntity(new UrlEncodedFormEntity(Data, "GB2312"));
        HttpResponse response = httpClient.execute(httpPost);

//        HttpEntity entity = response.getEntity();
////        if (entity != null) {
////                System.out.println(EntityUtils.toString(entity));
////        }
//        httpPost.setEntity(entity);

//        HttpGet httpGet = new HttpGet("http://222.24.19.201/xs_main.aspx?xh=04133088");
//        response = httpClient.execute(httpGet);
//        HttpEntity entity = response.getEntity();
////        System.out.println(EntityUtils.toString(entity));
        Data.clear();

//        HttpGet httpGet = new HttpGet("http://222.24.19.201/xscjcx.aspx?xh=04133088&xm=%C0%EE%C1%D6%BA%B2&gnmkdm=N121605");
//        response = httpClient.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        System.out.println(EntityUtils.toString(entity));

//        Data.add(new BasicNameValuePair("xh",userName));
//        Data.add(new BasicNameValuePair("xm", URLEncoder.encode("李林翰", "GB2312")));  //学校是URL加密 GB2312
//        Data.add(new BasicNameValuePair("gnmkdm","N121605"));

    }
}
