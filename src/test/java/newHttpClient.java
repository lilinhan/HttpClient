import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

/**
 * Created by lewin on 15-4-7.
 */
public class newHttpClient {
    public static void main(String[] args) {
        try {
            StringEntity myEntity = new StringEntity("important message", ContentType.create("text/plain","UTF-8"));
            System.out.println(myEntity.getContentType()); // getContenType()和getContentLength()用来读取Content-type和Content-Length两个头消息
            System.out.println(myEntity.getContentLength());
            System.out.println(EntityUtils.toString(myEntity)); //
            System.out.println(EntityUtils.toByteArray(myEntity).length);
            String str = "important message";
            System.out.println(str.length());
        }catch (Exception e)  {
            e.printStackTrace();
        }

    }
}
