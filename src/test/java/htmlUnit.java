import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by lewin on 15-4-2.
 */
public class htmlUnit {
    public static void main(String[] args) {
        String string;
        //使用火狐读取网页
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
        //配置不加载css js
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage("http://www.baidu.com");
            string = htmlPage.asXml();
            System.out.println(string);
        }catch (Exception e)  {
            e.printStackTrace();
        }
        webClient.closeAllWindows();
    }
}
