package com.pravin.automation.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    // Tracks how many times test retried
    private int count = 0;

    //  Max retry limit (2 retries = total 3 executions)
    private static final int maxRetry = 2;

    @Override
    public boolean retry(ITestResult result) {

        //  If retry limit not reached
        if (count < maxRetry) {
            count++;

            //  Store retry count inside TestNG context (VERY IMPORTANT)
            result.setAttribute("retryCount", count);

            //  Logging for debugging retry behavior
            System.out.println("Retrying Test: "
                    + result.getName()
                    + " | Attempt: " + (count + 1));

            return true; // Re-run test
        }

        // No more retries
        return false;
    }
}