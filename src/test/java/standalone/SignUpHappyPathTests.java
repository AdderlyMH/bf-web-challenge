package standalone;

import components.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class SignUpHappyPathTests extends TestBase {

    @Test(dataProvider = "getMap")
    public void createUserTest(HashMap<String,Object> parameter) {

        mainPage.clickSignUpHeaderButton();

        mainPage.writeSignUpUsernameInput((String) parameter.get("username"));
        mainPage.writeSignUpPasswordInput((String) parameter.get("password"));

        mainPage.clickSignUpModalButton();

        String actualAlertMessage = mainPage.getAlertText();
        assertEquals(actualAlertMessage, parameter.get("expectedAlertMessage"),"Alert messages don't match");

        mainPage.clickAlertOKButton();

    }

    @DataProvider
    public Object[][] getMap() {

        HashMap<String,Object> firstMap = new HashMap<>();
        firstMap.put("username", "another155");
        firstMap.put("password", "another15");
        firstMap.put("expectedAlertMessage", "Sign up successful.");

        HashMap<String,Object> secondMap = new HashMap<>();
        secondMap.put("username", "another166");
        secondMap.put("password", "another16");
        secondMap.put("expectedAlertMessage", "Sign up successful.");

        return new Object[][] {{firstMap}, {secondMap}};

    }

}
