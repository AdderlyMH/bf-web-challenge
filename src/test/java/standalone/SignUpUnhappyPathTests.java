package standalone;

import components.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpUnhappyPathTests extends TestBase {

    @Test(dataProvider = "getData")
    public void validateUserTest(String username, String password, String expectedAlertMessage) {

        mainPage.clickSignUpHeaderButton();

        mainPage.writeSignUpUsernameInput(username);
        mainPage.writeSignUpPasswordInput(password);

        mainPage.clickSignUpModalButton();

        String actualAlertMessage = mainPage.getAlertText();
        assertEquals(actualAlertMessage, expectedAlertMessage,"Alert messages don't match");

        mainPage.clickAlertOKButton();
        mainPage.clickCloseModalButton();

    }

    @DataProvider
    public Object[][] getData() {

        return new Object[][] {
                {"example", "example", "This user already exist."},
                {"example2", "example2", "This user already exist."}
        };

    }

}
