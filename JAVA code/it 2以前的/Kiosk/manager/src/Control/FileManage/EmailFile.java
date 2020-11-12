package Control.FileManage;
/** 
 * projectName: SoftwareEngineering
 * fileName: EmailFile.java 
 * packageName: Control.FileManage
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import Entity.Email;

/**
 * ClassName: EmailFile<br>
 * Description: This is the control class that used to operate on<br>
 * the 'email.json' file which contains all the information about email in json format.
 * @version V2.0
 */
public class EmailFile {
	private String jsonfile = "./info.json";
	
	/**
	* This constructor used to do nothing
	*/
	public EmailFile() 
	{
		
	}
	
	/**
	* Used to set the email service information, like status, name.
	* @param email the email name(email address)
	*/
	public void SetEmail(Email email) {
		String emailName = email.getEmail();
		String Status = email.getStatus();
		try {
			JSONObject info;
			String info_temp = "";
			String info_string = "";
			FileReader info_fr = new FileReader(jsonfile);
			BufferedReader info_br = new BufferedReader(info_fr);
			while ((info_temp=info_br.readLine())!=null) {
				info_string = info_string + info_temp + "\n";
			}
			info_br.close();
			info_fr.close();
			info = new JSONObject(info_string);	
		    JSONArray jsonArray = info.getJSONArray("reportReceiver");
      
			FileWriter fw = new FileWriter("./info.json");
		    BufferedWriter bw=new BufferedWriter(fw);
			JSONObject object=new JSONObject();
        	JSONObject receiver=new JSONObject();
        	for (int i = 0; i < jsonArray.length(); i++) {
                   JSONObject r = jsonArray.getJSONObject(i);
                   if(r.getString("email").equals(emailName)) {
                       jsonArray.remove(i);   
                       break;
                   }
               }
       
        		receiver.put("email", emailName);
            	receiver.put("sendStatus", Status);
            	jsonArray.put(receiver);
        	
        	object.put("reportReceiver", jsonArray);
        	String jsonString = object.toString();

        	bw.write(jsonString);	
			bw.close();
			fw.close();
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
