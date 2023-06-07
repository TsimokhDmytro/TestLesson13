package datas;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class ValidCredentialRegistrationData {

    private String userName = generateRandomUserName();
    private String userEmail = generateRandomUserEmail();
    private String userPassword = generateRandomPassword();

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String generateRandomUserEmail(){
      String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        return randomEmail;
    }
    public String generateRandomUserName(){
        String randomName = RandomStringUtils.randomAlphabetic(10);
        return randomName;
    }

    public String generateRandomPassword(){
        String randomPassword = RandomStringUtils.randomAlphabetic(10);
        return randomPassword;
    }

    @Test
    public void dty(){
        System.out.println(userEmail);
        System.out.println(userName);
        System.out.println(userPassword);
    }
}

