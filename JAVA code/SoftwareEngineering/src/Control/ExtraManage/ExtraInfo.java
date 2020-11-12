package Control.ExtraManage;
import java.io.IOException;

import Control.FileManage.*;
import Entity.Extra;
public class ExtraInfo {
	public  ExtraFile extrafile = new ExtraFile();
	
	public  Extra[] getExtraInfo() throws IOException {
				return extrafile.getExtraInfo();
	}
	
	public int getExtraNumber() {
		return extrafile.getLength();
	}
}
