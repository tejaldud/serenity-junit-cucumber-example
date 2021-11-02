package service;


import io.restassured.http.ContentType;
import model.users.UsersListResponseDTO;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;

public class API {
    EnvironmentVariables environmentVariables ;

    public String getBaseURL()
    {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("restapi.baseurl");
    }

    public UsersListResponseDTO getListOfUsers(int pageNumber)
    {
       return SerenityRest.given()
                .baseUri(getBaseURL()+"/api/users")
                .queryParam("page",pageNumber)
               .contentType(ContentType.JSON)
                .get().as(UsersListResponseDTO.class);
    }

}
