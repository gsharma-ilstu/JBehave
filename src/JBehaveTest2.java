

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class JBehaveTest2 extends JUnitStories {

	private Calculator cal;

	@Given("a calculator")
	public void aCalculator() {

		cal = new Calculator();
	}

	@Given("the input1 has value 3")
	public void theInput1HasValue3() {

		cal.setValue1(3);
	}

	@Given("the input2 has value 4")
	public void theInput2HasValue4() {

		cal.setValue2(4);
	}
	
	@When("the user uses add function")
	public void whenTheUserUsesAdd() {

		cal.add(cal.getValue1(), cal.getValue2());
	}

	@Then("the result of addition must be 7")
	public void resultOfAdditionMustBe7() {
		Assert.assertEquals(7, cal.add(cal.getValue1(), cal.getValue2()));
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}
	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("test_cal.story");
	}

	@Override
	@Test
	public void run() throws Throwable {
		super.run();
	}
}