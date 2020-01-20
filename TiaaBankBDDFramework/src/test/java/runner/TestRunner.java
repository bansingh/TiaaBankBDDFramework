package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		
//features="C:\\Users\\vanda\\eclipse-workspace\\TiaaBankBDDFramework\\src\\main\\java\\Features\\productSelection.feature",

features="C:\\Users\\vanda\\eclipse-workspace\\TiaaBankBDDFramework\\src\\main\\java\\Features\\submitApplication.feature",
	glue= {"stepDefs"},
			format= {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
			monochrome=true,
			//strict=true,
			dryRun=false
)
public class TestRunner {

}
