package com.pravin.automation.testdata;

import com.pravin.automation.utils.JsonUtil;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class JsonTestData {

    @DataProvider(name = "jsonLoginData")
    public Object[][] getJsonData() {
        String path = "src/test/resources/testdata/LoginData.json";

        List<Map<String, Object>> dataList = JsonUtil.getJsonData(path);
        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;
    }
}