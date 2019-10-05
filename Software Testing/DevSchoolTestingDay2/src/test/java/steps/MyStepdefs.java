package test.java.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ro.Cand;
import cucumber.api.java.ro.Datfiind;
import cucumber.api.java.ro.Și;

public class MyStepdefs {
    // Adnotare Cucumber, metoda pe care o poate folosi. Parseaza fisierul feature  si compara cu adnotarea.
    // Partea de matching se numeste look code.
    @Datfiind("^Deschid pagina \"([^\"]*)\"$")
    @Given("^I go to URL \"([^\"]*)\"$")
    public void iGoToURL(String arg0) {
        System.out.println("I open url " + arg0);
    }

    @Cand("^Dau click pe \"([^\"]*)\"$")
    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String arg0) {
        System.out.println("I click on " + arg0);
    }

    @Și("^Selectez Subject Heading \"([^\"]*)\"$")
    @When("^I select Subject Heading \"([^\"]*)\"$")
    public void iSelectSubjectHeading(String arg0) {
        System.out.println("I select Subject Heading " + arg0);
    }

    @Și("^Introduc adresa de email \"([^\"]*)\"$")
    @When("^I enter email address \"([^\"]*)\"$")
    public void iEnterEmailAddress(String arg0) {
        System.out.println("I enter email address " + arg0);
    }

    @Și("^Introduc mesajul \"([^\"]*)\"$")
    @When("^I enter message \"([^\"]*)\"$")
    public void iEnterMessage(String arg0) {
        System.out.println("I enter message " + arg0);
    }

    // No param, scoate si stringul din lista de parametrii
    @When("^I click \"Send\"$")
    public void iClick() {
        System.out.println("I click on send");
    }

    @Then("^Success message \"([^\"]*)\" appears$")
    public void successMessageAppears(String arg0) {
        System.out.println("Success message appears: " + arg0);
    }

    @Then("^Error message appears \"([^\"]*)\"$")
    public void errorMessageAppears(String arg0) {
        System.out.println("Error message is  " + arg0);
    }
//
//    @Datfiind("^Deschid pagina \"([^\"]*)\"$")
//    public void deschidPagina(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Cand("^Dau click pe \"([^\"]*)\"$")
//    public void dauClickPe(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Și("^Selectez Subject Heading \"([^\"]*)\"$")
//    public void selectezSubjectHeading(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Și("^Introduc adresa de email \"([^\"]*)\"$")
//    public void introducAdresaDeEmail(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Și("^Introduc mesajul \"([^\"]*)\"$")
//    public void introducMesajul(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
