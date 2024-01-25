package ru.netology.web.page;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public VerificationPage validlogin(DataHelper.AuthInfo info) {
        $("[data-test-id='login'] input").sendKeys(info.getLogin());
        $("[data-test-id='password'] input").sendKeys(info.getPassword());
        $("button.button").click();
        return new VerificationPage();
    }
}
