package io.qaguru.qa_guru_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
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
        $("[start = '3']").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
