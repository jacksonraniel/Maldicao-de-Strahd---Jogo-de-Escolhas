package teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Teste {
	public static void main(String[] args) throws IOException {
		 System.out.println("--- Serialize / Deserialize Started ---");
	        String fileName = "Narrativas/narrativa.json";

	        Gson gson = new Gson();
	        Type listOfTestObject = new TypeToken<List<Narrativa>>(){}.getType();

	        //Make Serial 
	        Writer osWriter = new OutputStreamWriter( new FileOutputStream(fileName));
	        List<Narrativa> list = Collections.synchronizedList(new ArrayList<Narrativa>() );
	        Narrativa n1 = new Narrativa();
	        n1.setId(1);
	        n1.setTexto("nada");
	        n1.setTitulo("1");
	        list.add(new Narrativa());
	        list.add(n1);
	        gson.toJson(list, osWriter);
	        osWriter.close();


	        //Eat Serial
	        Reader isReader = new InputStreamReader( new FileInputStream((fileName) ) );
	        List<Narrativa> list2 = Collections.synchronizedList(
	            (List<Narrativa>)gson.fromJson(isReader, listOfTestObject) 
	        );
	        isReader.close();
	        System.out.println(list2.get(0).getTexto() );
	        System.out.println(list2.get(1).getTexto() );
	        System.out.println("--- Serialize / Deserialize Ended ---");
		
	}
	
	

}
