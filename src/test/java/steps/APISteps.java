package steps;

import model.users.UsersListResponseDTO;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import service.API;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class APISteps {

    @Steps
    API api;
    int pageNumber = 1;
    UsersListResponseDTO listOfUsers;

    @Step
    public void getUserList() {
        listOfUsers = api.getListOfUsers(1);
    }

    @Step
    public void validatePageNumber(int expectedPageNumber) {
        assertThat(expectedPageNumber, is(listOfUsers.getPage()));
    }

    @Step
    public void validateTotal(int total) {
        assertThat(total, is(listOfUsers.getTotal()));
    }

    @Step
    public void validatePerPage(int perPage) {
        assertThat(perPage, is(listOfUsers.getPerPage()));
        assertThat(perPage, is(listOfUsers.getData().size()));
    }


}
