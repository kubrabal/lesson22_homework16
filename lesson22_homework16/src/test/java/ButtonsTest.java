import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ButtonsTest {

    @Test
    public void clickButtons() {
        Selenide.open("https://demoqa.com/elements");

        SelenideElement buttons = $(byId("item-4"));
        SelenideElement clickMeButtons = $(byCssSelector(".col-md-6 div:nth-of-type(3) > .btn"));
        SelenideElement clickMeMessage = $(byId("dynamicClickMessage"));

        buttons.click();
        assertThat("https://demoqa.com/elements");
        clickMeButtons.click();
        assertThat("https://demoqa.com/buttons");
        System.out.println(clickMeMessage.getText());

        Selenide.closeWebDriver();
    }
}