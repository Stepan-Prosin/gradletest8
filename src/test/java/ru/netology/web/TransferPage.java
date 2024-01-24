package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import javax.swing.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferButton=$("[data-test-id=action-transfer]");
    private SelenideElement amountInput=$("[data-test-id='amount'] input");
    private SelenideElement fromInput=$("[data-test-id='from'] input");
    private SelenideElement transferHead=$(byText("Пополнение карты"));

    private SelenideElement errorMessege=$("[data-test-id='error-notification'] .notification__content");
public TransferPage(){transferHead.shouldBe(Condition.visible);}
    public DashboardPage validTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo){
        makeTransfer(amountToTransfer,cardInfo);
        return new DashboardPage();
    }
    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNuber());
        transferButton.click();
    }
    public void findErrorMessge(String expectedText){
    errorMessege.shouldBe(text(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
