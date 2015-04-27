import com.sun.org.apache.bcel.internal.classfile.Constant;
import org.apache.http.Consts;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.xml.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lewin on 15-4-7.
 */
public class newHttpPost {
    public static void main(String[] args) {
        List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
        formparams.add(new BasicNameValuePair("param1","value1"));
        formparams.add(new BasicNameValuePair("param2","value2"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost post = new HttpPost("http://www.yeetrack.com/handler.do");
        post.setEntity(entity);

        System.out.println(entity.getContentType());
    }
}
