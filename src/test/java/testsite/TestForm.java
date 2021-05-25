package testsite;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    static Logger log = LoggerFactory.getLogger(TestForm.class);
    @BeforeAll
    static void  setConfig()
    {
        log.info("@BeforeAll");
        Configuration.startMaximized = true;
    }

    String firstName="Vasya";
    String lastName="Pupkin";
    String userEmail="emailtest@testtest.com";
    String userNumber= "1234567890";
    String subjectsInput="M";
    String currentAddress="Moscow, Russia";

    @Test
    void selenideTestForms() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1992");
        $("[aria-label='Choose Monday, May 25th, 1992']").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("d").pressEnter();
        $("#react-select-4-input").setValue("Ja").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName), text(userEmail),
                text("Male"), text(userNumber), text("25 May,1992"), text(subjectsInput),
                text("Sports"), text(currentAddress));

    }

}
