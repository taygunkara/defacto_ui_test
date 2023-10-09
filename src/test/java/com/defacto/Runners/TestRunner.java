package com.defacto.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/defacto/Features/CartPage.feature"},
        glue = {"/com/defacto/TestCases"}
)

public class TestRunner {
}