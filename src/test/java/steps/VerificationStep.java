
package steps;

import org.testng.Assert;

import coreUtilities.testbase.TestBase;
import io.cucumber.java.en.*;
import pages.VerificationPage;

public class VerificationStep extends TestBase {

	VerificationPage verification = new VerificationPage(driver);

@When("Login in the healthapp application")
public void login_in_the_healthapp_application() {
verification.login();
}

@Given("Scroll & click till {string} menu on the side bar.")
public void scroll_click_till_menu_on_the_side_bar(String string) {
   verification.openVerificationMenu();
}


@Then("Verify that the user is able to navigate to {string} section")
public void verify_that_the_user_is_able_to_navigate_to_section(String module) throws InterruptedException {
	verification.successfullNavigation(module);
}

@Then("Verify that the {string} menu is visible.")
public void verify_that_the_menu_is_visible(String module) {

}

@Then("Verify that {string} button is visible.")
public void verify_that_buttons_are_visible(String text) {
verification.verifyButtonPresentWithText(text);
}

@Then("Click on {string} under {string}")
public void click_on_under(String subModule, String module) {
	verification.clickOnButtonByText(module);
	verification.clickOnButtonByText(subModule);
}

@Given("I am on the required page")
public void i_am_on_the_required_page() {
 
}

@Then("Verify these elements: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
public void verify_these_elements(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, String string19, String string20, String string21, String string22) {
   
}

@Then("Click on {string} tab")
public void click_on_tab(String text) {
	verification.clickOnButtonByText(text);
}



@Then("Enter the {string} date as {string} {string} {string}")
public void enter_the_date_as(String string, String string2, String string3, String string4) {
   
}

@When("Click on {string} button")
public void click_on_button(String string) {
 
}

@Then("Verify that all the dates present inside the requested date are within the range")
public void verify_that_all_the_dates_present_inside_the_requested_date_are_within_the_range() {

}

}
