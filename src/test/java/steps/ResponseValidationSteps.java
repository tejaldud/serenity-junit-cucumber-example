package steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ResponseValidationSteps {

    @Step
    public void validateSuccessResponse(int statusCode)
    {
        SerenityRest.restAssuredThat(validatableResponse -> validatableResponse.statusCode(statusCode));
    }
}
