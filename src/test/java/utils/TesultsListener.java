package utils;

import com.amazonaws.services.s3.transfer.model.UploadResult;
import com.tesults.tesults.*;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;


import java.util.*;

public class TesultsListener implements TestExecutionListener {

    private final List<Map<String, Object>> results = new ArrayList<>();

    @Override
    public void executionFinished(TestIdentifier testIdentifier,
                                  org.junit.platform.engine.TestExecutionResult result) {
        if (testIdentifier.isTest()) {
            Map<String, Object> testCase = new HashMap<>();
            testCase.put("name", testIdentifier.getDisplayName());
            testCase.put("suite", testIdentifier.getParentId().orElse("Default Suite"));
            testCase.put("result", result.getStatus().toString().toLowerCase());
            results.add(testCase);
        }
    }

}
