package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CssXpath {
    @BeforeAll
    static void beforeAll() {Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void cssXpath() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("anna");//Name
        $("#lastName").setValue("Ivanova"); //LastName
        $("#userEmail").setValue("tast@email.fig"); //email
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)").click();
        $("#userNumber").setValue("9001112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1900");
        $("[aria-label$='March 9th, 1900']").click();
        $("#subjectsInput").setValue("his") .sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label").click();
        $("#uploadPicture").uploadFromClasspath("Снимок.jpg");
    }
}
