package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {
	public  List<HashMap<String, String>> getJsondatatoMap(String FilePath) throws IOException
	{
		//Read json to String
		String JsonContent=FileUtils.readFileToString(new File(FilePath));
		//String to HashMap (Jackson databind)
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data =mapper.readValue(JsonContent, new  TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
		
		
	}

}

