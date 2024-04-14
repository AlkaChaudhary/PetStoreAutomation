package api.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    public ExtentTest test;
    String repName;

    
    public void onStart(ITestContext testContext) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            repName = "Test-Report-" + timeStamp + ".html";

            // Ensure directory exists or create it
            File reportDir = new File(".\\reports\\");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

            sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
            sparkReporter.config().setReportName("Pet Store Users API");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "Pet Store Users API");
            extent.setSystemInfo("Operating System", "Windows 11");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("API Name1", "POJOAPI");
            extent.setSystemInfo("API Name2", "DATA DRIVEN API");
            extent.setSystemInfo("User", "Alka");

            
        } catch (Exception e) {
            // Handle file IO exceptions
            e.printStackTrace();
        }
    }

   
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, "Test Passed");
    }

   
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
    }

 
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }


    public void onFinish(ITestContext testContext) {
        if (extent != null) {
            extent.flush();
        } else {
            System.err.println("ExtentReports object is null. Make sure to initialize it first.");
        }
    }

    // Implement other methods of ITestListener as needed
}
