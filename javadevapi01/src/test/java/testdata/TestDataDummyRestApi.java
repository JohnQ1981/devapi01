package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDataDummyRestApi {

	public HashMap<String,Object> setUpData(){
		HashMap<String,Object> expectedData = new HashMap<String,Object>();
		expectedData.put("statusCode", 200);
		expectedData.put("fifthEmpName", "Airi Satou");
		expectedData.put("numOfEmployees", 24);
		expectedData.put("secondLastSalary", "106450");

		List<String> agesList = new ArrayList<>();
		agesList.add("40");
		agesList.add("21");
		agesList.add("19");

		expectedData.put("ages", agesList);

		HashMap<String,Object> innerMap = new HashMap<String,Object>();
		innerMap.put("id", "11");
		innerMap.put("employee_name", "Jena Gaines");
		innerMap.put("employee_salary", "90560");
		innerMap.put("employee_age", "30");
		innerMap.put("profile_image", "");

		expectedData.put("eleventhEmployee", innerMap);
		//System.out.println(expectedData);
		return expectedData;
	}

}
