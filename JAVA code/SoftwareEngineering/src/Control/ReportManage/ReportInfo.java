package Control.ReportManage;
import Control.FileManage.ReportFile;
import java.io.IOException;
import Entity.Report;
public class ReportInfo {

	private ReportFile reportfile;
	public ReportInfo(String name) {

		reportfile = new ReportFile(name);
	}

	
	public  Report getReportInfo() throws IOException {
		return reportfile.getReportInfo();
	}
}
