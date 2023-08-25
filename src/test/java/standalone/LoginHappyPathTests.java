package standalone;

import components.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginHappyPathTests extends TestBase {

    @Test(dataProvider = "getJsonMap")
    public void loginLogoutTest(HashMap<String,Object> parameter) {

        mainPage.clickLoginHeaderButton();

        mainPage.writeLoginUsernameInput((String) parameter.get("username"));
        mainPage.writeLoginPasswordInput((String) parameter.get("password"));

        mainPage.clickLoginModalButton();

        String actualUsernameWelcome = mainPage.getWelcomeUsernameButtonText();
        assertEquals(actualUsernameWelcome, parameter.get("expectedUsernameWelcome"),"Username welcome doesn't match");

        mainPage.clickLogoutHeaderButton();

    }

    @DataProvider
    public Object[][] getJsonMap() throws IOException {
        List<HashMap<String,Object>> data = getJsonDataToMap("src/main/resources/dataJsonTest.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

}
