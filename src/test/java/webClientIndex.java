import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.List;

/**
 * Created by lewin on 15-4-2.
 */
public class webClientIndex {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage("http://www.baidu.com");
            List list = htmlPage.getByXPath("//div");
            HtmlDivision hb = (HtmlDivision)list.get(0);
            System.out.println(hb.toString());

            List inputList = htmlPage.getByXPath("//input[@id='su']");
            HtmlInput input = (HtmlInput)inputList.get(0);
            System.out.println(input.toString());
        }catch (Exception e)  {
            e.printStackTrace();
        }
        webClient.closeAllWindows();
    }
}
