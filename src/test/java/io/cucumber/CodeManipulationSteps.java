package io.cucumber;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.sun.tools.javac.util.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CodeManipulationSteps {
	
	private static String TEST_PATH = "src/test/java/assessment/Task1";
	
	private static String[] ARGS = { "5", "7", "0" };
	
	@When("^code is complemented to full$")
	public void codeIsComplemented() {
		
	}
	
	@When("^code is compiled")
	public void codeIsCompiled() {/*
		try {
			runProcess("pwd");
	        System.out.println("**********");
	        runProcess("javac -cp src " + TEST_PATH);
	        System.out.println("**********");
	        for(String arg: ARGS) {
	        	runProcess("java -cp src " + TEST_PATH + " " + arg);
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.error("Oops..");
			e.printStackTrace();
		}
		*/
	}
	
	@Then("^run program over test set$")
	public void runProgramOverTestSet() {
		/*
		System.out.println("**********");
        for(String arg: ARGS) {
        	try {
				runProcess("java -cp src " + TEST_PATH + " " + arg + ".class");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        */
	}

	private void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }
	
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }
}
