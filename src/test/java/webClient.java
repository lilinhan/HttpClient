import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import sun.awt.motif.X11GB2312;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lewin on 15-4-1.
 */
public class webClient {
    public static void main(String[] args) {
        String xh = "04133088";
        String xm = "";
        //得到浏览器        final HtmlForm button = htmlPage.getFormByName("f");
        WebClient webClient = new WebClient();
        //配置不加载css和javascript
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage htmlPage = webClient.getPage("http://222.24.19.201/default_ysdx.aspx");
            WebRequest request = new WebRequest(new URL("http://222.24.19.201/xs_main.aspx?"+xh),HttpMethod.POST);

            HtmlPage h = webClient.getPage(request);
            System.out.println(h.asXml());
        }catch (Exception e)  {
            e.printStackTrace();
        }
        webClient.closeAllWindows();
    }
}
