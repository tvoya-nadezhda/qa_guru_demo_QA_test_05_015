package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CssXpathTest {
    @BeforeAll
    static void beforeAll() {Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
            }
    @Test
    void cssXpath() {
        open("/automation-practice-form/");//открываем нужную страницу
        executeJavaScript("$('#fixedban').remove()"); //скрываем рекламу
        executeJavaScript("$('footer').remove()");//Скрываем футер
        $("#firstName").setValue("anna");//Вводим имя
        $("#lastName").setValue("Ivanova"); //Вводим Фамилию
        $("#userEmail").setValue("tast@email.fig"); //email
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)").click();//объявляем миру, что  Анна - женщина)
        $("#userNumber").setValue("9001112233");//Вводлим номер
        $("#dateOfBirthInput").click();//Открываем календарь
        $(".react-datepicker__month-select").selectOption("March");//Выбирае месяц
        $(".react-datepicker__year-select").selectOption("1900");//Выбирае год
        $("[aria-label$='March 9th, 1900']").click();//Устанавливаем нужную дату рождения
        $("#subjectsInput").setValue("his") .sendKeys(Keys.ARROW_DOWN, Keys.ENTER);//Выбираем историю, как интерес
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();//Прокликиваем галочку
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label").click();//Прокликиваем галочку
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label").click();//Прокликиваем галочку
        $("#uploadPicture").uploadFromClasspath("pik.JPG");//Загружаем картинку
        $("#currentAddress").setValue("112233, Ulica kuricy, dom Petuha, kvartira Ciplenka, 4 zvonka");//Вводим адрес
        $("#react-select-3-input").setValue("NCR").sendKeys(Keys.ENTER);//Выбираем штат
        $("#react-select-4-input").setValue("Noida").sendKeys(Keys.ENTER);//Выбираем город
        $("#submit").click();
//проверки
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("tast@email.fig"));
        $(".table").shouldHave(text("Female"));
        $(".table").shouldHave(text("9001112233"));
        $(".table").shouldHave(text("09 March,1900"));
        $(".table").shouldHave(text("History"));
        $(".table").shouldHave(text("Sports, Reading, Music"));
        $(".table").shouldHave(text("pik.JPG"));
        $(".table").shouldHave(text("NCR Noida"));
    }
}
