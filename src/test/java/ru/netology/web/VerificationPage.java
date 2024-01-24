package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField=$("[data-test-id=code] input");
    private SelenideElement verifyButton=$("[data-test-id=action-verify]");
    public VerificationPage(){
        codeField.shouldBe(Condition.visible);
    }
    public DashboardPage validVerify(DataHelper.VerifivationCode verifivationCode)
    {
        codeField.setValue(verifivationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
