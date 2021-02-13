package io.qaguru.qa_guru_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class SelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://github.com/selenide/selenide";
        open("/wiki");
    }

    @Test
    void selenideTest() {
        $$(".Box--condensed li").filterBy(exactText("SoftAssertions"))
                .shouldHaveSize(1);
        $(By.linkText("SoftAssertions")).click();
        open("/wiki/SoftAssertions");
        $$("div>pre").filterBy(text("@ExtendWith"))
                .shouldHaveSize(1);
    }
}
