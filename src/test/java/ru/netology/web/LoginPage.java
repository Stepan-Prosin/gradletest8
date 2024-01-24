package ru.netology.web;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class LoginPage {
    public VerificationPage validlogin(DataHelper.AuthInfo info){
        $("[data-test-id='login'] input").sendKeys(info.getLogin());
        $("[data-test-id='password'] input").sendKeys(info.getPassword());
        $("button.button").click();
        return new VerificationPage();
    }
}
