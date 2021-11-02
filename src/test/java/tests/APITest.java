package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.APISteps;
import steps.ResponseValidationSteps;

@RunWith(SerenityRunner.class)
public class APITest {

    @Steps
    APISteps apiSteps;
    @Steps
    ResponseValidationSteps responseValidationSteps;

    @Test
    public void getUserList() {
        apiSteps.getUserList();
        responseValidationSteps.validateSuccessResponse(200);
        apiSteps.validatePageNumber(1);
        apiSteps.validateTotal(12);
        apiSteps.validatePerPage(6);

    }
}
