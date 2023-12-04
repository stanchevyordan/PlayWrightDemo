import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

import java.nio.file.Paths;
import java.util.Arrays;

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
        bookBtn.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./snaps/locator.png")));
        Locator header = page.locator(("#header"));
        header.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/region.png")));

        // masking locator

        Locator input = page.locator("input#user-message");
        input.type("Something");
        input.scrollIntoViewIfNeeded();
        page.screenshot(screenshotOptions.setPath(Paths.get("./snaps/input2.png"))
                .setFullPage(false)                                   // removing the full page option
                .setMask(Arrays.asList(input)));                      // mask option

        // caret show/hide

        input.click();
        page.screenshot(new Page.ScreenshotOptions().setCaret(ScreenshotCaret.HIDE)
                .setPath(Paths.get("./snaps/caretHide.png")));                          // without shown typing index
        page.screenshot(new Page.ScreenshotOptions().setCaret(ScreenshotCaret.INITIAL)       // with shown typing index
                .setPath(Paths.get("./snaps/caretInitial.png")));


        page.close();
        playwright.close();         // screenshots are appearing after we close the page and Playrwright

    }
}
