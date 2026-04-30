package com.pravin.automation.testdata;

import com.pravin.automation.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class ExcelTestData  {
    //Excel data fetch
    @DataProvider (name = "excelLoginData")
    public Object [][] getExcelData (){

        //path to the excel sheeet
        String path = "src/test/resources/testdata/LoginData.xlsx";

        //here we're calling ExcelUtil (This is real engine)   //output looks like this [ {username= tomsmith, password =pass....}]
        List<Map<String , String>> dataList = ExcelUtil.getTestData(path , "LoginData");
        //Each Map= One test case.


        Object [][] data = new Object[dataList.size()][1];  //Convert to Object


        for (int i=0 ; i< dataList.size();i++){
            data [i][0] =dataList.get(i);
        }
        return data;
    }


}
//Core understanding (IMPORTANT)
//Excel → List<Map> → Object[][] → TestNG → Test Method