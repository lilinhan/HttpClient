import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by lewin on 15-4-7.
 */
public class closeHttpClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.yeetrack.com");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            if ( entity != null ) {
                long len = entity.getContentLength();
                if (len != -1 && len < 2048) {
                    System.out.println(EntityUtils.toString(entity));
                }
            }else {
                System.out.println("null");
            }
        }finally {
            response.close();
        }
    }
}
