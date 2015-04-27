import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by lewin on 15-4-2.
 */
public class webClientSearch {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage htmlPage = webClient.getPage("http://www.baidu.com");
            HtmlInput htmlInput = (HtmlInput)htmlPage.getHtmlElementById("kw");
//            System.out.println(htmlInput.toString());

            htmlInput.setValueAttribute("linux");
//            System.out.println(htmlInput.toString());

            HtmlInput btn = (HtmlInput)htmlPage.getHtmlElementById("su");
            HtmlPage htmlPage1 = btn.click();

//            System.out.println(htmlPage1.asText());
//            System.out.println(htmlPage1.asXml());

        }catch (Exception e) {
            e.printStackTrace();
        }
        webClient.closeAllWindows();
    }
}
