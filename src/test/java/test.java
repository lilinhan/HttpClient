import com.sun.javafx.fxml.builder.URLBuilder;
import com.sun.org.apache.xerces.internal.util.URI;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import sun.net.www.http.HttpClient;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by lewin on 15-3-29.
 */
public class test {
    public static void main(String[] args) throws URISyntaxException {
        java.net.URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .addParameter("q","httpclient")
                .addParameter("btnG","Google Search")
                .addParameter("aq","f")
                .addParameter("oq","")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());

        HttpResponse httpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");

        System.out.println(httpResponse.getProtocolVersion());  //显示HTTP协议版本号
        System.out.println(httpResponse.getStatusLine().getStatusCode());  //连接状态码
        System.out.println(httpResponse.getStatusLine().getReasonPhrase()); //状态响应码
        System.out.println(httpResponse.getStatusLine().toString());

        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK,"OK");
        response.addHeader("Set-Cookie","c1=a; path=/;domain=localhost");
        response.addHeader("Set-Cookie","c2=a; path=\"/\", c3 = c ;domain=\"localhost\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header [] hs = response.getHeaders("Set-Cookie");
        System.out.println(hs.length);

        HttpResponse response1 = new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK,"OK");
        response1.addHeader("Set-Cookie","c1=a ; path=/ ; domain=localhost");
        response1.addHeader("Set-Cookie","c2=b ; path=\"/\" , c3 = c; domain=\"localhost\"");
        HeaderIterator it = response1.headerIterator("Set-Cookie");
        while (it.hasNext())  {
//            System.out.println(it.next());
        }


    }
}
