package standalone;

import components.Retry;
import components.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class SignUpHappyPathTests extends TestBase {

    @Test(dataProvider = "getMap", retryAnalyzer = Retry.class)
    public void createUserTest(HashMap<String,String> parameter) {

        mainPage.clickSignUpHeaderButton();

        mainPage.writeSignUpUsernameInput(parameter.get("username"));
        mainPage.writeSignUpPasswordInput(parameter.get("password"));

        mainPage.clickSignUpModalButton();

        String actualAlertMessage = mainPage.getAlertText();
        assertEquals(actualAlertMessage, parameter.get("expectedAlertMessage"),"Alert messages don't match");

        mainPage.clickAlertOKButton();

    }

    @DataProvider
    public Object[][] getMap() {

        HashMap<String,Object> firstMap = new HashMap<>();
        firstMap.put("username", "another255");
        firstMap.put("password", "another15");
        firstMap.put("expectedAlertMessage", "Sign up successful.");

        HashMap<String,Object> secondMap = new HashMap<>();
        secondMap.put("username", "another366");
        secondMap.put("password", "another16");
        secondMap.put("expectedAlertMessage", "Sign up successful.");

        return new Object[][] {{firstMap}, {secondMap}};

    }

}
