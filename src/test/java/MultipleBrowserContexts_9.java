import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

public class MultipleBrowserContexts_9 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        page.getByLabel("E-mail Address").type("yordan.stanchev98@gmail.com");
        page.getByLabel("Password").type("$123456");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        Locator myAccount = page.getByText("Edit your account information");
        assertThat(myAccount).isVisible();
        Page newTab = page.context().newPage();
        newTab.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        assertThat(myAccount).isVisible();
        newTab.close();
        context.close();


        BrowserContext context2 = browser.newContext();
        Page userPage = context2.newPage();
        userPage.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");


        playwright.close();


    }
}
