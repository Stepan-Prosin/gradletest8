package  ru.netology.web;
import lombok.Value;
import org.example.Main;

import java.util.Random;

public class DataHelper {
private DataHelper(){}


@Value
    public static class AuthInfo{
    private String login;
    private String password;
    }


    public static AuthInfo getAuthInfo(){return new AuthInfo("vasya","qwerty123");}
    public static CardInfo getFirstCardInfo(){
        return new CardInfo("5559 0000 0000 0001","92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }
    public static CardInfo getSecondCardInfo(){
        return new CardInfo("5559 0000 0000 0002","0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }
    public static int generateValidAmount(int balance){
        return new Random().nextInt(Math.abs(balance))+1;
    }
    public static int generateInValidAmount(int balance){
        return  Math.abs(balance)+new Random().nextInt(10000);
    }
@Value
    public static class VerifivationCode{
    private String code;
    }
@Value
public static class CardInfo{
    String cardNuber;
    String testId;
}

    public static VerifivationCode getVerifivationCode(AuthInfo authInfo){return new VerifivationCode("12345");}
}

