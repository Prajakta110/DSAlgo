package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Tag;
import pages.HomePage;
import pages.LandingPage;
import pages.LinkedListPage;
import pages.LinkedlistPage;
import utils.DriverFactory;

public class LinkedListSD {
	
	WebDriver driver;
	
	LinkedListPage LinkedList;
	
	@Before
	public void setup() {
		
		driver = DriverFactory.getDriver("chrome");
		LinkedList = new LinkedListPage(driver);
	}
	
	@When("Verify User is on Linked List Page")
	public void verify_user_is_on_linked_list_page() {
		LinkedList.VerifyLinkedlistUrl();
	}

	@When("user clicks get started button on LinkedList")
	public void user_clicks_get_started_button_on_linked_list() {
	    //LandingPageSD.clickongetstartedbutton();
	}

	@When("User clicks get started btn on LinkedList")
	public void user_clicks_get_started_btn_on_LinkedList() {
	  LinkedList.LinkedlistIntroductionBtn();  
	}
	
	@When("User clicks Linked-listpage Introduction link")
	public void user_is_directed_to_Linked_listpage_and_clicks_Introductionbtn() {
		LinkedList.LinkedlistIntroductionBtn();
	}
	
	@When("^User clicks Linked-listpage \"(.*)\" link")
	public void user_is_directed_to_Linked_listpage_and_clicks_link(String linkname) {
		LinkedList.LinkedlistClickOnLink(linkname);
	}
	
	@Then("^Verify linked list link url \"(.*)\"")
	public void verify_Linked_list_url(String url) {
		LinkedList.VerifyLinkedlistChildUrl(url);
	}
	
	@Then("^User launches linkedlist suburl \"(.*)\"")
	public void user_launches_linked_list_sub_url(String url) {
		LinkedList.LaunchSubUrl(url);
	}
	
	@When("User clicks on Try Here button")
	public void user_clicks_on_try_here_button() {
		LinkedList.tryHereBtn();
	}
	
	@Then("Verify Try Here button takes to editor Url")
	public void Verify_Linked_list_try_here_button() {
		LinkedList.VerifyLinkedlistTryHeredUrl();
	}
	
	@Then("Verify linked list introduction link")
	public void verify_Linked_list_introduction_url() {
		LinkedList.VerifyLinkedlistIntroUrl();
	}
	
	@When("user is directed to LinkedList introduction page click Try Here")
	public void user_is_directed_to_LinkedList_introduction_page_click_Try_Here() {
		LinkedList.tryEditorBtn();
	}
	
	 @Then ("user should be directed to LinkedList Editor page")
	 public void user_should_be_directed_to_linkedlist_Editor_page() {
		 LinkedList.tryEditorBtn();
	 }
	
}




