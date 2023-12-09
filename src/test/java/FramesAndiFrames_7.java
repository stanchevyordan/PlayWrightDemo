import com.microsoft.playwright.*;

import java.util.List;

public class FramesAndiFrames_7 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Page page = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
        page.navigate("https://the-internet.herokuapp.com/iframe");
        FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");
        Locator bodyLocator = frameLocator.locator("body");
//        bodyLocator.click();
        bodyLocator.clear();
        bodyLocator.fill("Hey, crazy strength!");

//        page.close();

        page.navigate("https://letcode.in./frame");
        List<Frame> frames = page.frames();
        System.out.println("No. of frames available: " + frames.size());
//        frames.forEach(frame -> System.out.println(frame.url()));

        FrameLocator firstFrame = page.frameLocator("#firstFr");
        firstFrame.getByPlaceholder("Enter name").type("Yordan");
        FrameLocator nestedFrame = firstFrame.frameLocator("iframe.has-background-white");
        nestedFrame.getByPlaceholder("Enter email").type("yordan.stanchev98@gmail.com");

        firstFrame.getByPlaceholder("Enter name").fill("Yordan Stanchev");

    }
}
