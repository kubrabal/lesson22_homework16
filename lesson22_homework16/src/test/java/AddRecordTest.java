import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class AddRecordTest {
    @BeforeTest
    public void setUp() {
        Configuration.timeout = 50000;
    }

    @Test
    public void submitAndEditNewEntry() {
        SelenideElement addNewRecordButton = $("#addNewRecordButton");
        SelenideElement registrationForm = $("#registration-form-modal");

        SelenideElement firstNameField = $("#firstName");
        SelenideElement lastNameField = $("#lastName");
        SelenideElement emailField = $("#userEmail");
        SelenideElement ageField = $("#age");
        SelenideElement salaryField = $("#salary");
        SelenideElement departmentField = $("#department");

        SelenideElement submitButton =  $("#submit");
        SelenideElement editButton = $("#edit-record-4");

        open("https://demoqa.com/webtables");

        addNewRecordButton.scrollTo().click();

        registrationForm.shouldBe(Condition.visible);

        //Setting form fields
        firstNameField.setValue("Joh");
        lastNameField.setValue("Doe");
        emailField.setValue("john.doe@email.com");
        ageField.setValue("25");
        salaryField.setValue("35000");
        departmentField.setValue("Sales");

        submitButton.click();

        editButton.click();

        //Editing the new record
        firstNameField.clear();
        firstNameField.setValue("John");
        submitButton.click();
    }

    @AfterTest
    public void tearDown() {
    }
}
