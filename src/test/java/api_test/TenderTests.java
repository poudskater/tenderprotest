package api_test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TenderTests {

    @DataProvider(name = "TenderRowsCount")
    public static Object[][] getTenderRowsCount() {
        return new Object[][]{
                {"0"},{"3"},{"100"}
        };
    }

    @Test
    public void trendListTestResponseCodeTest() {
        Response response = RestAssured.get("http://www.tender.pro/api/_info.tenderlist_by_set.json?_key=1732ede4de680a0c93d81f01d7bac7d1&set_type_id=2&set_id=7964&max_rows=3&open_only=t");
        Assert.assertEquals(response.statusCode(),200);
    }


    @Test(dataProvider = "TenderRowsCount")
    public void trendListTestTestMaxRowsTest(String rowCount) {
        String url = String.format("http://www.tender.pro/api/_info.tenderlist_by_set.json?_key=1732ede4de680a0c93d81f01d7bac7d1&set_type_id=2&set_id=7964&max_rows=%s&open_only=t",rowCount);
        Response response = RestAssured.get(url);
        JsonPath jsonPath = response.body().jsonPath();
        Assert.assertEquals("true", jsonPath.get("success"));
        Assert.assertEquals(rowCount, jsonPath.get("result.args.max_rows"));
        List<Object> data =jsonPath.get("result.data");
        Assert.assertEquals(Integer.parseInt(rowCount), data.size());
     }


}
