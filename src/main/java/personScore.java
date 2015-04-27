import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lewin on 15-4-23.
 */
public class personScore {
    private static String num= null;
    private static String passwd = null;
    private static String name = null;
    private static Document scoreDom = null;

    public static void main(String[] args) throws Exception{
        System.out.println("please input your StudentID and your password:");
        Scanner scannerName = new Scanner(System.in);
        num = scannerName.nextLine();
        Scanner scannerNum = new Scanner(System.in);
        passwd = scannerNum.nextLine();
        //创建一个client
        CloseableHttpClient client = HttpClients.createDefault();
        //创建GET请求
        HttpGet get = new HttpGet("http://222.24.19.201/default_ysdx.aspx" );
        //client执行GET请求
        CloseableHttpResponse response = client.execute(get);
        //得到GET请求的响应
        HttpEntity entity = response.getEntity();

//        System.out.println(entity.getContentType());
//        System.out.println(response.getStatusLine());
//        System.out.println(EntityUtils.toString(entity));

        //找到__VIEWSTATE属性和value
        Document document = Jsoup.parse(EntityUtils.toString(entity));//parse将得到的HTML文件DOM化
        //筛选需要的部分
        Element element = document.getElementById("form1");
        Elements elements = element.select("input");
        String value = elements.attr("value");

        // 设置httpclient属性
        HttpPost post = new HttpPost("http://222.24.19.201/default_ysdx.aspx");
        //设置User-Agent
        post.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36");
        //将发的信息写入post请求中
        List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
        pairs.add(new BasicNameValuePair("__VIEWSTATE",value));
        pairs.add(new BasicNameValuePair("TextBox1" , num));
        pairs.add(new BasicNameValuePair("TextBox2" , passwd));
        pairs.add(new BasicNameValuePair("RadioButtonList1" , "\321\247\311\372"));
        pairs.add(new BasicNameValuePair("Button1" , "\265\307\302\274"));
        UrlEncodedFormEntity entitys = new UrlEncodedFormEntity(pairs, Consts.UTF_8);
        post.setEntity(entitys);
        //发送post请求
        client.execute(post);
        //上一步得到的response不是想要的东西
        //现在在发一个get请求试试
        get = new HttpGet("http://222.24.19.201/xscjcx.aspx?xh=" + num + "&xm=%C0%EE%C1%D6%BA%B2&gnmkdm=N121605");
        CloseableHttpResponse r = client.execute(get);

        document = Jsoup.parse(EntityUtils.toString(r.getEntity()));
        //获取name
        Elements elements1 = document.select("span[class=formbox]");
        Elements elem = elements1.select("span[id=lbl_xm]");
        String s = elem.text();
        name = s.substring(s.indexOf("：")+1);

        //获取__VIEWSTATE的值
        Elements element1 = document.select("input[name=__VIEWSTATE]");
        value = element1.first().attr("value");
        List<BasicNameValuePair> scorPairs = new ArrayList<BasicNameValuePair>();
        scorPairs.add(new BasicNameValuePair("__EVENTTARGET",""));
        scorPairs.add(new BasicNameValuePair("__EVENTARGUMENT",""));
        scorPairs.add(new BasicNameValuePair("__VIEWSTATE",value));
        scorPairs.add(new BasicNameValuePair("hidLanguage" , ""));
        scorPairs.add(new BasicNameValuePair("ddlXN" , "2014-2015"));
        scorPairs.add(new BasicNameValuePair("ddlXQ" , "1"));
        scorPairs.add(new BasicNameValuePair("ddl_kcxz", ""));
        scorPairs.add(new BasicNameValuePair("btn_xq", "%D1%A7%C6%DA%B3%C9%BC%A8"));

        post = new HttpPost("http://222.24.19.201/xscjcx.aspx?xh=" + num +"&xm=" + name + "&gnmkdm=N121605");
        entitys = new UrlEncodedFormEntity(scorPairs,Consts.UTF_8);
        post.setEntity(entitys);
        post.addHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36");

        response = client.execute(post);

        //将成绩的那一个网页变成一个DOM树解析
        scoreDom = Jsoup.parse(EntityUtils.toString(response.getEntity()));
        Elements scoreEle = scoreDom.select("table[class=datelist]");
        System.out.println(scoreEle);

    }
}

