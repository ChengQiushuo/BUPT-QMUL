package Control.CompulsoryManage;
import java.io.IOException;

import Control.FileManage.*;
import Entity.Compulsory;
public class CompulsoryInfo {
	public  CompulsoryFile compulsoryfile = new CompulsoryFile();
	
	public  Compulsory[] getCompulsoryInfo() throws IOException {
				return compulsoryfile.getCompulsoryInfo();
	}
	
	public int getCompulsoryNumber() {
		return compulsoryfile.getLength();
	}
	public int getOptionNumber(int index) {
		return compulsoryfile.getOptionLength(index);
	}
}
