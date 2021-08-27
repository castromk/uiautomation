package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONReader {

	private static final Logger console = LoggerFactory.getLogger(JSONReader.class);
	public static String getData(String key) {
		String value = "";
		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader(
				System.getProperty("user.dir") + "/src/test/resources/dataFiles/ExpectedData.json")) {

			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			// System.out.println(jsonObject.toString());
			org.json.JSONObject jsonData = new org.json.JSONObject(jsonObject.toString());
			value = jsonData.getString(key);
			console.info("Key {{}} value is retrived as {{}}",key,value);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;

	}
}
