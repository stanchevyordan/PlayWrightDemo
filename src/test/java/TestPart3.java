import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPart3 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        page.locator("input#user-message").type("Hey Tester");
        page.locator("id=showInput").click();
        String message = page.locator("#message").textContent();
        System.out.println(message);
        assertThat(page.locator("#message")).hasText("Hey Tester");

        // type vs fill

//        page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
//        page.locator("#textbox").fill("Data entered in the below textarea will be download with file name 'Lambdainfo.txt'.");

        // get input values

/*        page.navigate("https://leetcode.in/edit");
        String inputValue = page.locator("#getMe").inputValue();
        System.out.println(inputValue);

        String placeholderValue = page.locator("#fullName").getAttribute("placeholder");
        System.out.println(placeholderValue);

        Locator fullNamelocator = page.locator("#fullName");
        assertThat(fullNamelocator).hasAttribute("placeholder", "Enter first & last name");

        page.locator("id=clearMe").clear();
*/
        page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        Locator isAge = page.locator("#isAgeSelected");
        assertThat(isAge).not().isChecked();
        isAge.check();
        assertThat(isAge).isChecked();


        playwright.close();

    }

}
