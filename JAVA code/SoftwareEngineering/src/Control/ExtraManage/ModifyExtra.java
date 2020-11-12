package Control.ExtraManage;
import java.io.IOException;
import Control.FileManage.*;
public class ModifyExtra {
public ModifyExtra() {
		
	}
public  ExtraFile extrafile = new ExtraFile();
	public  void AddExtra(String name,String price) {
	try {
		extrafile.AddExtra(name,price);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public void DeleteExtra(int index) {
		extrafile.DeleteExtra(index);
	}
	public void SetExtra(int index,String price,String Availability) {
		extrafile.SetExtra(index, price, Availability);
	}
}
