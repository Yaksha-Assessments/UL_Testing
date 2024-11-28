package runner;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import coreUtilities.testbase.TestBase;
import coreUtilities.utils.FileOperations;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "src/test/java/features/", glue = { "runner", "steps" }, plugin = { "pretty",
		"json:target/cucumber-reports/report2.json", "junit:target/cucumber-reports/cucumber.xml",
		"html:target/cucumber-reports/report.html" }, tags = "@Test1", monochrome = true, publish = true // Enable
																											// publishing
																											// results
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
	String browserName = "chrome";
	TestBase testbase = new TestBase();

	@Before()
	public void beforeClass() throws Exception {
		System.out.println("Inside before");
		Map<String, String> configData;
		String projectBaseDirPath = System.getProperty("user.dir");
		String config_filePath = projectBaseDirPath + "/src/main/resources/config.xlsx";

		System.out.println("File path --> " + config_filePath);
		configData = new FileOperations().readExcelPOI(config_filePath, "prod");
		configData.put("url", configData.get("url").replaceAll("[\\\\]", ""));
		configData.put("browser", "chrome");
		testbase.initialize(configData);
	}

	@After(order = 0)
	public void tearDown() {
		testbase.browserTearDown();
	}

//	// This method will accept the tags parameter from the XML
//	@Parameters("tags")
//	public Object[][] scenarios(String tags) {
//		System.out.println("Tag name --> " + tags);
//		// Use the tags passed via the XML to filter which tests to run
//		System.setProperty("cucumber.filter.tags", tags); // Pass the tags dynamically
//		return super.scenarios(); // Pass the filtered scenarios to Cucumber
//	}
}
