import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

/**
 * Created by lewin on 15-4-2.
 */
public class webClientFindSomething {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage("http://www.baidu.com");
            HtmlSubmitInput htmlSubmitInput = (HtmlSubmitInput)htmlPage.getHtmlElementById("su");
            System.out.println(htmlSubmitInput.getDefaultValue());
        }catch (Exception e)  {
            e.printStackTrace();
        }
        webClient.closeAllWindows();
    }
}
