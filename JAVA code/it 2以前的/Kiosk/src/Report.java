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

/**
 * Title        : Report.java
 * Description  :
 * @author      : Hu Zhenming
 * @version     : 1.0
 */
public class Report extends JFrame implements ActionListener {
    /**
     * Constructor without parameters.
     */
    public Report() {
        // Set the frame.
        super("Report");
        this.setLayout(null);
        this.setBounds(200, 33, 1024, 768);

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
        JFreeChart soup_chart = ChartFactory.createPieChart3D(null, soup_dataset, false, false, false);
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
        JFreeChart noodles_chart = ChartFactory.createPieChart3D(null, noodles_dataset, false, false, false);
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
        JFreeChart springOnion_chart = ChartFactory.createPieChart3D(null, springOnion_dataset, false, false, false);
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
        JFreeChart smallDishes_chart = ChartFactory.createBarChart3D(null, null, null, smallDishes_dataset, PlotOrientation.VERTICAL, true, false, false);
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
        JFreeChart spiciness_chart = ChartFactory.createPieChart(null, spiciness_dataset, false, false, false);
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
        JFreeChart extraDishes_chart = ChartFactory.createBarChart3D(null, null, null, extraDishes_dataset, PlotOrientation.VERTICAL, false, false, false);
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

    private DefaultPieDataset getSoupDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Tonkotsu", 11);
        dataset.setValue("Shoyu", 33);
        dataset.setValue("Shio", 22);
        return dataset;
    }

    private DefaultPieDataset getNoodlesDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Soft", 33);
        dataset.setValue("Medium", 11);
        dataset.setValue("Firm", 22);
        return dataset;
    }

    private DefaultPieDataset getSpringOnionDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("No please", 11);
        dataset.setValue("Just a little", 22);
        dataset.setValue("A lot!", 33);
        return dataset;
    }

    private DefaultCategoryDataset getSmallDishesDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(33, "Yes", "Nori");
        dataset.addValue(16, "No", "Nori");
        dataset.addValue(5, "Yes", "Chashu");
        dataset.addValue(11, "No", "Chashu");
        dataset.addValue(44, "Yes", "Boiled egg");
        dataset.addValue(22, "No", "Boiled egg");
        return dataset;
    }

    private DefaultPieDataset getSpicinessDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("0(No)", 11);
        dataset.setValue("1", 22);
        dataset.setValue("2", 33);
        dataset.setValue("3", 33);
        dataset.setValue("4", 99);
        dataset.setValue("5(Max)", 11);
        return dataset;
    }

    private DefaultCategoryDataset getExtraDishesDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(11, "", "Extra Nori");
        dataset.addValue(33, "", "Extra boiled egg");
        dataset.addValue(44, "", "Bammboo shoots");
        dataset.addValue(22, "", "Extra Chashu");/*
        dataset.addValue(11, "Extra Nori", "Extra Nori");
        dataset.addValue(33, "Extra boiled egg", "Extra boiled egg");
        dataset.addValue(44, "Bammboo shoots", "Bammboo shoots");
        dataset.addValue(22, "Extra Chashu", "Extra Chashu");*/
        return dataset;
    }

    /**
     * This method can response to events.

    public static void main(String[] args) { new Modify(); }
     * @param e The event.
     */
    public void actionPerformed(ActionEvent e) {
        // Get the event.
        String opt = e.getActionCommand();
        switch (opt) {
            case "back":
                // 稍后还有其他操作
                break;

//            case "email_me":
//                this.dispose();
//                new AutomaticReport();
//                break;

            case "cancel":
                // 感觉有点鸡肋。。。
                break;

            default:
                System.out.println("---ERROR---");
        }
    }

    public static void main(String[] args) { new Report(); }
}
