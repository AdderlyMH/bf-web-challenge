package components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int COUNT = 0;
    int MAX_TRY = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (COUNT < MAX_TRY) {
            COUNT++;
            return true;
        } else return false;
    }

}
