package ru.netology.web;


import static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    DashboardPage dashboardPage;
    DataHelper.CardInfo firstCardInfo;
    DataHelper.CardInfo secondCardInfo;
    int firstCardBalance;
    int secondCardBalence;
    @BeforeEach
    void setup(){
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage=loginPage.validlogin(authInfo);
        var verificatiomCode = DataHelper.getVerifivationCode(authInfo);
        dashboardPage = verificationPage.validVerify(verificatiomCode);
        firstCardInfo=DataHelper.getFirstCardInfo();
        secondCardInfo=DataHelper.getSecondCardInfo();
        firstCardBalance=dashboardPage.getCardBalance(firstCardInfo);
        secondCardBalence = dashboardPage.getCardBalance(secondCardInfo);

    }
    @Test
    void validTransferBetweenTwoCards(){
       var amount = DataHelper.generateValidAmount(firstCardBalance);
        var expectedBalanceFirstCard= firstCardBalance-amount;
        var expectedBalanceSecondCard= secondCardBalence+amount;
        var transferPage=dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.validTransfer(String.valueOf(amount),firstCardInfo);
        var actualBalanceFirstCard= dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
        assertAll(() ->assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard),
                ()-> assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard));
    }
    @Test
    void errorMessegeWhenAmountMoreBalance() {
        var amount = DataHelper.generateValidAmount(secondCardBalence);
        var transferPage=dashboardPage.selectCardToTransfer(firstCardInfo);
        transferPage.makeTransfer(String.valueOf(amount),secondCardInfo);
        transferPage.findErrorMessge("Выполнена попытка перевода суммы, превышающей остаток на карте списания");
    }

}
