package tests.android.local;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class ArticleTests extends TestBase {

    @Test
    void openArticleTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Open first article", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Verify article opened", () ->
                $(id("pcs-edit-section-title-description")).shouldHave(text("Software company based in India")));

    }
}
