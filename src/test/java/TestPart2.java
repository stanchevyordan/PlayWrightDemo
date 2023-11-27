import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPart2 {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
                );
        Page page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");

        Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
        myAccount.hover();
        // page.click("//a[contains(.,'Login')]");
        page.locator("//a[contains(.,'Login')]").click();
        assertThat(page).hasTitle("Account Login");
        page.getByPlaceholder("E-Mail Address").type("yordan.stanchev98@gmail.com");
        page.getByPlaceholder("Password").type("$123456");
        page.locator("//input[@value='Login']").click();
        assertThat(page).hasTitle("My Account");
        page.close();
        browser.close();
        playwright.close();

    }
}
