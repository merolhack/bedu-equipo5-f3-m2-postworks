package org.bedu.java.testing.interviewer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

/**
 * @author Lenin Meza
 */
@Suite
@SelectClasspathResource("features")
public class RunCucumberTest {
}
