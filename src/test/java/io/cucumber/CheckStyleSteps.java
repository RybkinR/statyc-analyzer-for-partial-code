package io.cucumber;

import static guru.nidi.codeassert.junit.CodeAssertMatchers.hasNoCheckstyleIssues;
import static org.junit.Assert.assertThat;

import org.apache.log4j.BasicConfigurator;

import com.puppycrawl.tools.checkstyle.api.SeverityLevel;

import cucumber.api.java.en.Then;
import guru.nidi.codeassert.checkstyle.CheckstyleAnalyzer;
import guru.nidi.codeassert.checkstyle.CheckstyleResult;
import guru.nidi.codeassert.checkstyle.StyleChecks;
import guru.nidi.codeassert.checkstyle.StyleEventCollector;
import guru.nidi.codeassert.config.AnalyzerConfig;
import guru.nidi.codeassert.config.In;

public class CheckStyleSteps {
	
	private final AnalyzerConfig config = AnalyzerConfig.maven().test("assessment");

    // Only treat issues with severity ERROR or higher
    private final StyleEventCollector collector = new StyleEventCollector().severity(SeverityLevel.WARNING)
            .just(In.everywhere().ignore("import.avoidStar", "javadoc.missing", "file.containsTab", "final.parameter", 
            		"hide.utility.class", "javadoc.packageInfo", "containsTab", "indentation.child.error", "indentation.error"));
	
	@Then("^check style google$")
    public void checkStyleGoogle() {
		BasicConfigurator.configure();

        final StyleChecks checks = StyleChecks.google().maxLineLen(80);

        CheckstyleResult result = new CheckstyleAnalyzer(config, checks, collector).analyze(); 
        assertThat(result, hasNoCheckstyleIssues());
    }
	
	@Then("^check style sun$")
    public void checkStyleSun() {
		BasicConfigurator.configure();

        final StyleChecks checks = StyleChecks.sun().maxLineLen(80);

        CheckstyleResult result = new CheckstyleAnalyzer(config, checks, collector).analyze(); 
        assertThat(result, hasNoCheckstyleIssues());
    }
}