package io.cucumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.ForeachStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.sun.tools.javac.util.Assert;

import cucumber.api.java.en.Then;

public class ConstructionCheckSteps {
	
	private static String TEST_PATH = "src/test/java/assessment/Task1.java"; 
	
	@Then("^check that contains FOR statement$")
	public void checkForStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			Assert.error(test.getAbsolutePath());
		}
        Optional<ForStmt> loop = cu.findFirst(ForStmt.class);
        Assert.checkNonNull(loop.get());
	}
	
	@Then("^check that contains IF statement$")
	public void checkIfStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<IfStmt> ifst = cu.findFirst(IfStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains WHILE statement$")
	public void checkWhileStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<WhileStmt> ifst = cu.findFirst(WhileStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains DO-WHILE statement$")
	public void checkDoStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<DoStmt> ifst = cu.findFirst(DoStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains FOREACH statement$")
	public void checkForEachStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<ForeachStmt> ifst = cu.findFirst(ForeachStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains SWITCH statement$")
	public void checkSwitchStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<SwitchStmt> ifst = cu.findFirst(SwitchStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains THROW statement$")
	public void checkThrowStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<ThrowStmt> ifst = cu.findFirst(ThrowStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains TRY statement$")
	public void checkTryStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<TryStmt> ifst = cu.findFirst(TryStmt.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains CATCH statement$")
	public void checkCatchStatement() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<CatchClause> ifst = cu.findFirst(CatchClause.class);
        Assert.checkNonNull(ifst.get());
	}
	
	@Then("^check that contains Inner Class$")
	public void checkInnerClass() {
		File test = new File(TEST_PATH);
        // parse the file
		CompilationUnit cu = null;
		try {
			cu = JavaParser.parse(test);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Assert.error(test.getAbsolutePath());
		}
        Optional<LocalClassDeclarationStmt> ifst = cu.findFirst(LocalClassDeclarationStmt.class);
        Assert.checkNonNull(ifst.get());
	}
}
