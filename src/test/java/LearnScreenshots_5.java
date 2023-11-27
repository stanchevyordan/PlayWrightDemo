import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class LearnScreenshots_5 {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        System.out.println(page.title());


        // screenshots
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        page.screenshot(screenshotOptions.setPath(Paths.get("./snaps/scr.png")));


        // full page screenshots
        page.screenshot(screenshotOptions.setFullPage(true)
                .setPath(Paths.get("./snaps/fullPage.jpg")));

        // locator screenshot
        Locator bookBtn = page.locator("//button[text()='Book a Demo']");


        // masking locator


        // caret show/hide


        page.close();
        playwright.close();

    }
}
