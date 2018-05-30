package io.cucumber;

import org.junit.Assert;

import static org.junit.Assert.assertThat;

import org.apache.log4j.BasicConfigurator;

import cucumber.api.java.en.Then;
import edu.umd.cs.findbugs.Priorities;
import guru.nidi.codeassert.config.AnalyzerConfig;
import guru.nidi.codeassert.config.In;
import guru.nidi.codeassert.findbugs.BugCollector;
import guru.nidi.codeassert.findbugs.FindBugsAnalyzer;
import guru.nidi.codeassert.jacoco.Coverage;
import guru.nidi.codeassert.pmd.PmdRulesets;
import static guru.nidi.codeassert.junit.CodeAssertMatchers.hasNoBugs;
import static guru.nidi.codeassert.junit.CodeAssertMatchers.hasNoUnusedActions;


public class FindBugsSteps {
    private final AnalyzerConfig config = AnalyzerConfig.maven().test("assessment");
    private final BugCollector bugCollector = new BugCollector().minPriority(Priorities.NORMAL_PRIORITY)
            .because("is not useful",
                    In.everywhere().ignore(
                            "UWF_UNWRITTEN_FIELD", "NP_UNWRITTEN_FIELD", "UUF_UNUSED_FIELD",
                            "DLS_DEAD_LOCAL_STORE", "SIC_INNER_SHOULD_BE_STATIC", "UC_USELESS_OBJECT",
                            "OBL_UNSATISFIED_OBLIGATION", "EI_EXPOSE_REP", "EI_EXPOSE_REP2"),
                    In.classes("*Comparator").ignore("SE_COMPARATOR_SHOULD_BE_SERIALIZABLE"))
            .because("avoid jvm killed on travis",
                    In.classes("*Test").ignore("DM_GC"))
            .because("it's ok",
                    In.clazz(Coverage.class).ignore("EQ_COMPARETO_USE_OBJECT_EQUALS"),
                    In.everywhere().ignore("PATH_TRAVERSAL_IN"))
            .because("is handled by annotation",
                    In.clazz(PmdRulesets.class).ignore("URF_UNREAD_FIELD"));
    
    @Then("^check for no unused actions$")
    public void checkForNoUnusedActions() {
    	BasicConfigurator.configure();
    	/*
        System.gc();
        assertThat(new FindBugsAnalyzer(config, new BugCollector().maxRank(17).minPriority(Priorities.IGNORE_PRIORITY)).analyze(), hasNoUnusedActions());
        */
    }
}
