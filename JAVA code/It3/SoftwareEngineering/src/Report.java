import org.json.JSONObject;

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
import java.util.Date;

/**
 * Title        : Report.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Report extends JFrame implements ActionListener {
    public static String save_url;
    private JSONObject info, soup, noodles, springOnion, nori, chashu, boiledEgg, spiciness, extraDishes;
    private JFreeChart soup_chart, noodles_chart, springOnion_chart, smallDishes_chart, spiciness_chart, extraDishes_chart;

    /**
     * Constructor without parameters.
     */
    public Report() throws IOException {
        // Set the frame.
        super("Report");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());
        save_url = "./report/" + formatter.format(date);

        Json();

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

        // Set soup report panel.
        JPanel p_l_1 = new JPanel();
        p_l_1.setLayout(null);
        p_l_1.setBounds(8, 63, 500, 190);
        p_l_1.setBorder(BorderFactory.createTitledBorder("Soup"));
        // Set soup report.
        DefaultPieDataset soup_dataset = getSoupDataset();
        soup_chart = ChartFactory.createPieChart3D(null, soup_dataset, false, false, false);
        ChartPanel soup_panel = new ChartPanel(soup_chart);
        soup_panel.setBounds(49, 15, 400, 170);
        p_l_1.add(soup_panel);

        // Set noodles report panel.
        JPanel p_l_2 = new JPanel();
        p_l_2.setLayout(null);
        p_l_2.setBounds(8, 258, 500, 190);
        p_l_2.setBorder(BorderFactory.createTitledBorder("Noodles"));
        // Set noodles report.
        DefaultPieDataset noodles_dataset = getNoodlesDataset();
        noodles_chart = ChartFactory.createPieChart3D(null, noodles_dataset, false, false, false);
        ChartPanel noodles_panel = new ChartPanel(noodles_chart);
        noodles_panel.setBounds(49, 15, 400, 170);
        p_l_2.add(noodles_panel);

        // Set spring onion report panel.
        JPanel p_l_3 = new JPanel();
        p_l_3.setLayout(null);
        p_l_3.setBounds(8, 453, 500, 190);
        p_l_3.setBorder(BorderFactory.createTitledBorder("Spring onion"));
        // Set spring onion report.
        DefaultPieDataset springOnion_dataset = getSpringOnionDataset();
        springOnion_chart = ChartFactory.createPieChart3D(null, springOnion_dataset, false, false, false);
        ChartPanel springOnion_panel = new ChartPanel(springOnion_chart);
        springOnion_panel.setBounds(49, 15, 400, 170);
        p_l_3.add(springOnion_panel);

        // Set small dishes report panel.
        JPanel p_r_1 = new JPanel();
        p_r_1.setLayout(null);
        p_r_1.setBounds(516, 63, 500, 190);
        p_r_1.setBorder(BorderFactory.createTitledBorder("Small Dishes"));
        // Set small dishes report.
        DefaultCategoryDataset smallDishes_dataset = getSmallDishesDataset();
        smallDishes_chart = ChartFactory.createBarChart3D(null, null, null, smallDishes_dataset, PlotOrientation.VERTICAL, true, false, false);
        CategoryPlot smallDishes_plot = smallDishes_chart.getCategoryPlot();
        BarRenderer3D smallDishes_renderer = new BarRenderer3D();
        smallDishes_renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        smallDishes_renderer.setItemLabelsVisible(true);
        smallDishes_renderer.setItemLabelPaint(Color.BLACK);
        smallDishes_plot.setRenderer(smallDishes_renderer);
        ChartPanel smallDishes_panel = new ChartPanel(smallDishes_chart);
        smallDishes_panel.setBounds(49, 15, 400, 170);
        p_r_1.add(smallDishes_panel);

        // Set spiciness report panel.
        JPanel p_r_2 = new JPanel();
        p_r_2.setLayout(null);
        p_r_2.setBounds(516, 258, 500, 190);
        p_r_2.setBorder(BorderFactory.createTitledBorder("Spiciness"));
        // Set spiciness report.
        DefaultPieDataset spiciness_dataset = getSpicinessDataset();
        spiciness_chart = ChartFactory.createPieChart(null, spiciness_dataset, false, false, false);
        ChartPanel spiciness_panel = new ChartPanel(spiciness_chart);
        spiciness_panel.setBounds(49, 15, 400, 170);
        p_r_2.add(spiciness_panel);

        // Set extra dishes report panel.
        JPanel p_r_3 = new JPanel();
        p_r_3.setLayout(null);
        p_r_3.setBounds(516, 453, 500, 190);
        p_r_3.setBorder(BorderFactory.createTitledBorder("Extra dishes"));
        // Set extra dishes report.
        DefaultCategoryDataset extraDishes_dataset = getExtraDishesDataset();
        extraDishes_chart = ChartFactory.createBarChart3D(null, null, null, extraDishes_dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot extraDishes_plot = extraDishes_chart.getCategoryPlot();
        BarRenderer3D extraDishes_renderer = new BarRenderer3D();
        extraDishes_renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        extraDishes_renderer.setItemLabelsVisible(true);
        extraDishes_renderer.setItemLabelPaint(Color.BLACK);
        extraDishes_plot.setRenderer(extraDishes_renderer);
        ChartPanel extraDishes_panel = new ChartPanel(extraDishes_chart);
        extraDishes_panel.setBounds(3, 15, 490, 170);
        p_r_3.add(extraDishes_panel);

        this.add(p_l_1);
        this.add(p_l_2);
        this.add(p_l_3);
        this.add(p_r_1);
        this.add(p_r_2);
        this.add(p_r_3);

        /*
         * Set the closing operation.
         * Set the frame to non-resizeable.
         * Set the frame to visible.
         */
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void Json() throws IOException {
        String info_temp = "";
        String info_string = "";
        FileReader info_fr = new FileReader("./info.json");
        BufferedReader info_br = new BufferedReader(info_fr);
        while ((info_temp=info_br.readLine())!=null) {
            info_string = info_string + info_temp + "\n";
        }
        info = new JSONObject(info_string);
        info_br.close();
        info_fr.close();

        soup = (JSONObject)info.get("Soup");
        noodles = (JSONObject)info.get("Noodles");
        springOnion = (JSONObject)info.get("SpringOnion");
        nori = (JSONObject)info.get("Nori");
        chashu = (JSONObject)info.get("Chashu");
        boiledEgg = (JSONObject)info.get("BoiledEgg");
        spiciness = (JSONObject)info.get("Spiciness");
        extraDishes = (JSONObject)info.get("ExtraDishes");
    }

    private DefaultPieDataset getSoupDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Tonkotsu", (int)soup.get("Tonkotsu"));
        dataset.setValue("Shoyu", (int)soup.get("Shoyu"));
        dataset.setValue("Shio", (int)soup.get("Shio"));
        return dataset;
    }

    private DefaultPieDataset getNoodlesDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Soft", (int)noodles.get("Soft"));
        dataset.setValue("Medium", (int)noodles.get("Medium"));
        dataset.setValue("Firm", (int)noodles.get("Firm"));
        return dataset;
    }

    private DefaultPieDataset getSpringOnionDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("No please", (int)springOnion.get("No please"));
        dataset.setValue("Just a little", (int)springOnion.get("Just a little"));
        dataset.setValue("A lot!", (int)springOnion.get("A lot!"));
        return dataset;
    }

    private DefaultCategoryDataset getSmallDishesDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue((int)nori.get("Yes"), "Yes", "Nori");
        dataset.addValue((int)nori.get("No"), "No", "Nori");
        dataset.addValue((int)chashu.get("Yes"), "Yes", "Chashu");
        dataset.addValue((int)chashu.get("No"), "No", "Chashu");
        dataset.addValue((int)boiledEgg.get("Yes"), "Yes", "Boiled egg");
        dataset.addValue((int)boiledEgg.get("No"), "No", "Boiled egg");
        return dataset;
    }

    private DefaultPieDataset getSpicinessDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("0(No)", (int)spiciness.get("0"));
        dataset.setValue("1", (int)spiciness.get("1"));
        dataset.setValue("2", (int)spiciness.get("2"));
        dataset.setValue("3", (int)spiciness.get("3"));
        dataset.setValue("4", (int)spiciness.get("4"));
        dataset.setValue("5(Max)", (int)spiciness.get("5"));
        return dataset;
    }

    private DefaultCategoryDataset getExtraDishesDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue((int)extraDishes.get("Extra Nori"), "null", "Extra Nori");
        dataset.addValue((int)extraDishes.get("Extra boiled egg"), "null", "Extra boiled egg");
        dataset.addValue((int)extraDishes.get("Bammboo shoots"), "null", "Bammboo shoots");
        dataset.addValue((int)extraDishes.get("Extra Chashu"), "null", "Extra Chashu");
        return dataset;
    }

    public static void saveAsFile(JFreeChart chart, String outPutPath) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outPutPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outPutPath);
            ChartUtilities.writeChartAsPNG(out, chart, 490, 170);
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
     * This method can response to events.
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "back":
                // 稍后还有其他操作
                break;

            case "email_me":
                this.dispose();
                saveAsFile(soup_chart, save_url + "/01.soup.png");
                saveAsFile(noodles_chart, save_url + "/02.noodles.png");
                saveAsFile(springOnion_chart, save_url + "/03.springOnion.png");
                saveAsFile(smallDishes_chart, save_url + "/04.smallDishesp.png");
                saveAsFile(spiciness_chart, save_url + "/05.spiciness.png");
                saveAsFile(extraDishes_chart, save_url + "/06.extraDishes.png");
                //new AutomaticReport();
                break;

            case "cancel":
                // 感觉有点鸡肋。。。
                break;

            default:
                System.out.println("---ERROR---");
        }
    }

    public static void main(String[] args) throws IOException { new Report(); }
}