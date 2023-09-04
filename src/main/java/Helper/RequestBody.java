package Helper;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOLayer.Repository;



public class RequestBody {

	public static FileReader file;
	public static ObjectMapper objMap;
	public static JsonNode jsonNode;
	public static Repository repos;
	
	public static String postRequestBody(String JSONnodeName) throws Exception
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resource\\postGITHUB.json";
		file = new FileReader(path);
		objMap = new ObjectMapper();
		jsonNode = objMap.readTree(file);
		repos = objMap.treeToValue(jsonNode.get(JSONnodeName), Repository.class);
		return objMap.writeValueAsString(repos);
		
	}
	
}
