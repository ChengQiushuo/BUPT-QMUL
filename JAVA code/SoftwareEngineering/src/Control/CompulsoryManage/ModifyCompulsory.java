package Control.CompulsoryManage;
import java.io.IOException;
import Control.FileManage.*;

public class ModifyCompulsory {
	public ModifyCompulsory() {
		
	}

	public  CompulsoryFile compulsoryfile = new CompulsoryFile();
	public  void AddSimpleOption(String name) {
		try {
			compulsoryfile.addSimpleOption(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void AddRankingOption(String name,String item1,String item2,String item3) {
		try {
			compulsoryfile.addRankingOptions(name,item1,item2,item3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void AddExtraOption(int index ,String name,String availability) {
		try {
			compulsoryfile.AddExtraOption(index,name,availability);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteCompulsory(int index) {	
			compulsoryfile.DeleteCompulsory(index);		
	}
	public void DeleteCompulsoryOption(int index) {	
		compulsoryfile.DeleteCompulsoryOption(index);		
	}
	public void setOption(String[] Availability) {
		compulsoryfile.setOption(Availability);
	}
	
}
