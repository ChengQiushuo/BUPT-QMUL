package Boundary;
/** 
 * projectName: SoftwareEngineering
 * fileName: ReportShow.java 
 * packageName: Boundary
 * date:2020.5 
 * copyright(c) EBU6304-2020 Software Engineering Group 87
 */
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Entity.Report;
import Control.ReportManage.ReportInfo;;

/**
 * ClassName: ReportShow<br>
 * Description: This is the GUI interface showing the report of business condition in the last seven days 
 * @version V4.0
 * @author Hu Zhenming
 */
public class ReportShow extends JFrame implements ActionListener {
    private String infoFile;
    /**the operating file path*/
    public static String save_url;
  
    private JFreeChart[] chart = new JFreeChart[10];
    private ChartPanel[] panel = new ChartPanel[10];
    
    private ReportInfo reportInfo;
    private Report report;
    
    /**
	* This constructor used to set up the GUI interface and 
	* @throws IOException when reading the report information from file failed
	*/
    public ReportShow() throws IOException {
        // Set the frame.
        super("Report");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        String temp = "../jsonfile/report/" + (Integer.parseInt(formatter.format(date))+1-(cal.get(Calendar.DAY_OF_WEEK)-1)-7);
        this.infoFile = temp + "info.json";
        save_url = temp + "email";

        reportInfo = new ReportInfo(infoFile);
        report = reportInfo.getReportInfo();
        // Set the title.
        JLabel l = new JLabel("Report of last 7 days", JLabel.CENTER);
        l.setBounds(300, 10, 400, 50);
        l.setFont(new Font(null, Font.BOLD, 30));
        this.add(l);

        // Set back button.
        JButton back = new JButton("Back");
        back.setFont(new Font(null, Font.BOLD, 20));
        back.setBounds(50, 654, 200, 60);
        back.addActionListener(this);
        back.setActionCommand("back");
        this.add(back);

        // Set email me button.
        JButton email_me = new JButton("Email Me");
        email_me.setFont(new Font(null, Font.BOLD, 20));
        email_me.setBounds(412, 654, 200, 60);
        email_me.addActionListener(this);
        email_me.setActionCommand("email_me");
        this.add(email_me);

        // Set cancel button.
        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font(null, Font.BOLD, 20));
        cancel.setBounds(774, 654, 200, 60);
        cancel.addActionListener(this);
        cancel.setActionCommand("cancel");
        this.add(cancel);

        JPanel p_1_1 = new JPanel();
        p_1_1.setLayout(null);
        p_1_1.setBounds(5, 63, 252, 190);
        p_1_1.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[0]));
        this.add(p_1_1);

        JPanel p_1_2 = new JPanel();
        p_1_2.setLayout(null);
        p_1_2.setBounds(259, 63, 252, 190);
        p_1_2.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[1]));
        this.add(p_1_2);

        JPanel p_1_3 = new JPanel();
        p_1_3.setLayout(null);
        p_1_3.setBounds(513, 63, 252, 190);
        p_1_3.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[2]));
        this.add(p_1_3);

        JPanel p_1_4 = new JPanel();
        p_1_4.setLayout(null);
        p_1_4.setBounds(767, 63, 252, 190);
        p_1_4.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[3]));
        this.add(p_1_4);

        JPanel p_2_1 = new JPanel();
        p_2_1.setLayout(null);
        p_2_1.setBounds(5, 258, 252, 190);
        p_2_1.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[4]));
        this.add(p_2_1);

        JPanel p_2_2 = new JPanel();
        p_2_2.setLayout(null);
        p_2_2.setBounds(259, 258, 252, 190);
        p_2_2.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[5]));
        this.add(p_2_2);

        JPanel p_2_3 = new JPanel();
        p_2_3.setLayout(null);
        p_2_3.setBounds(513, 258, 252, 190);
        p_2_3.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[6]));
        this.add(p_2_3);

        JPanel p_2_4 = new JPanel();
        p_2_4.setLayout(null);
        p_2_4.setBounds(767, 258, 252, 190);
        p_2_4.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[7]));
        this.add(p_2_4);

        JPanel p_3_1 = new JPanel();
        p_3_1.setLayout(null);
        p_3_1.setBounds(5, 453, 760, 190);
        p_3_1.setBorder(BorderFactory.createTitledBorder("Extra dishes"));
        this.add(p_3_1);

        JPanel p_3_2 = new JPanel();
        p_3_2.setLayout(null);
        p_3_2.setBounds(767, 453, 252, 190);
        p_3_2.setBorder(BorderFactory.createTitledBorder(report.getCompulsoryName()[8]));
        this.add(p_3_2);

        switch (report.getCompulsoryCount()) {//compulsory dishes has up to 9 statistical charts
            case 9:
                p_3_2.add(getCompulsoryPanel(8));
            case 8:
                p_2_4.add(getCompulsoryPanel(7));
            case 7:
                p_2_3.add(getCompulsoryPanel(6));
            case 6:
                p_2_2.add(getCompulsoryPanel(5));
            case 5:
                p_2_1.add(getCompulsoryPanel(4));
            case 4:
                p_1_4.add(getCompulsoryPanel(3));
            case 3:
                p_1_3.add(getCompulsoryPanel(2));
            case 2:
                p_1_2.add(getCompulsoryPanel(1));
            case 1:
                p_1_1.add(getCompulsoryPanel(0));
            case 0:
                p_3_1.add(getExtraPanel());
                break;
            default:
                System.out.println("---Compulsory ERROR---");
        }

        /**
         * Set the closing operation.
         * Set the frame to non-resizeable.
         * Set the frame to visible.
         */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
	* Used to generate the pie charts of the compulsory dishes and put it in a panel
	* @param index the index of a dish in the information list of compulsory dishes 
	* @return ChartPanel the panel contains the generated pie chart
	*/
    private ChartPanel getCompulsoryPanel(int index) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i=0; i<report.getItemCount()[index]; i++) {
            dataset.setValue(report.getItemName()[index][i], report.getItemNumber()[index][i]);
        }
        chart[index] = ChartFactory.createPieChart(null, dataset, true, false, false);
        panel[index] = new ChartPanel(chart[index]);
        panel[index].setBounds(6, 22, 238, 155);

        return panel[index];
    }

    /**
	* Used to generate the bar charts of the extra dishes and put it in a panel
	* @return ChartPanel the panel contains the generated bar chart
	*/
    private ChartPanel getExtraPanel() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<report.getExtraCount(); i++) {
            dataset.addValue(report.getDishNumber()[i], "null", report.getDishName()[i]);
        }
        chart[9] = ChartFactory.createBarChart3D(null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot plot = chart[9].getCategoryPlot();
        BarRenderer3D renderer = new BarRenderer3D();
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        renderer.setItemLabelPaint(Color.BLACK);
        plot.setRenderer(renderer);
        panel[9] = new ChartPanel(chart[9]);
        panel[9].setBounds(3, 15, 750, 170);

        return panel[9];
    }

    /**
	* Used to save the report charts to the file
	* @param chart the chart wants to save
	* @param outPutPath the saving path of the file
	*/
    public static void saveAsFile(JFreeChart chart, String outPutPath) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outPutPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outPutPath);
            ChartUtilities.writeChartAsPNG(out, chart, 714, 465);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
	* Used to react to the event happened on the interface elements
	* @param e the event happened on the interface elements
	*/
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "back":
                new managementOptions();
                this.dispose();
                break;

            case "email_me"://go to automatic email service setting
                new AutomaticReport();
                int i;
                for(i=0; i<report.getCompulsoryCount(); i++) {
                    saveAsFile(chart[i], save_url+"/"+(i+1)+"."+report.getCompulsoryName()[i]+".png");
                }
                saveAsFile(chart[9], save_url + "/"+(i+1)+".Extra.png");//save chart to the file
                this.dispose();
                break;

            case "cancel":
            	 this.dispose();
            	 new managerLogin();
                break;

            default:
                System.out.println("---ERROR---");
        }
    }
}