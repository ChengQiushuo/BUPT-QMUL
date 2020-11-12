package control.Report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.Ramen;
import entity.ExtraInfo;

public class compulsoryReport {
	  private static String SPACE = "   ";
	 public void doCompulsoryReport(ExtraInfo ExtraInfo) {
	        try {
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(new Date());
	            SimpleDateFormat formatter = new SimpleDateFormat(("yyyyMMdd"));
	            Date date = new Date(System.currentTimeMillis());
	            File f = new File("./report/" + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json");
	            if (!f.exists()) {
	                String dish_temp = "";
	                String dish_string = "";
	                FileReader dish_fr = new FileReader("./dish/compulsory.json");
	                BufferedReader dish_br = new BufferedReader(dish_fr);
	                while ((dish_temp = dish_br.readLine()) != null) {
	                    dish_string = dish_string + dish_temp + "\n";
	                }
	                JSONObject dish = new JSONObject(dish_string);
	                JSONArray dishes = dish.getJSONArray("dishes");
	                Ramen.cominfo.dish_len = dishes.length();

	                for (int i = 0; i < Ramen.cominfo.dish_len; i++) {
	                    JSONObject obj_i = (JSONObject) dishes.get(i);
	                    Ramen.cominfo.dish_str[i] = obj_i.getString("name");
	                    JSONArray options = obj_i.getJSONArray("option");
	                    Ramen.cominfo.option_len[i] = options.length();
	                    for (int j = 0; j < Ramen.cominfo.option_len[i]; j++) {
	                        JSONObject obj_j = (JSONObject) options.get(j);
	                        Ramen.cominfo.option_str[i][j] = obj_j.getString("item");
	                        Ramen.cominfo.availability[i][j] = obj_j.getString("availability");
	                    }
	                }
	                dish_br.close();
	                dish_fr.close();
	     
	                try {
	                    JSONObject root = new JSONObject();
	                    root.put("boss", "Mr. Miyazaki");
	                    root.put("restaurant", "Totoro Ramen");
	                    JSONArray compulsory = new JSONArray();
	                    JSONArray extra = new JSONArray();
	                    JSONArray[] options = new JSONArray[Ramen.cominfo.dish_len];
	                    JSONObject[] object = new JSONObject[Ramen.cominfo.dish_len];
	                    JSONObject[][] items = new JSONObject[Ramen.cominfo.dish_len][10];
	                    JSONObject[] object1 = new JSONObject[ExtraInfo.dishName.length];
	                    for (int count = 0; count < Ramen.cominfo.dish_len; count++) {
	                        object[count] = new JSONObject();
	                        object[count].put("name", Ramen.cominfo.dish_str[count]);
	                        options[count] = new JSONArray();
	                        for (int count0 = 0; count0 < Ramen.cominfo.option_len[count]; count0++) {
	                            items[count][count0] = new JSONObject();
	                            items[count][count0].put("item", Ramen.cominfo.option_str[count][count0]);
	                            items[count][count0].put("number", 0);
	                            options[count].put(items[count][count0]);
	                        }
	                        object[count].put("options", options[count]);
	                        compulsory.put(object[count]);
	                    }
	                    for (int count = 0; count < ExtraInfo.dishName.length; count++) {
	                        object1[count] = new JSONObject();
	                        object1[count].put("dish", ExtraInfo.dishName[count]);
	                        object1[count].put("number", 0);
	                        extra.put(object1[count]);
	                    }
	                    root.put("compulsory", compulsory);
	                    root.put("extra", extra);
	                    String jsonString = formatJson(root.toString());
	                    //System.out.println(jsonString);
	                    //将json字符串写入到json文件中
	                    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./report/"
	                            + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json"));
	                    osw.write(jsonString);
	                    osw.flush();
	                    osw.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  public  String formatJson(String json) {
	        StringBuffer result = new StringBuffer();

	        int length = json.length();
	        int number = 0;
	        char key = 0;

	        // 遍历输入字符串。
	        for (int i = 0; i < length; i++) {
	            // 1、获取当前字符。
	            key = json.charAt(i);

	            // 2、如果当前字符是前方括号、前花括号做如下处理：
	            if ((key == '[') || (key == '{')) {
	                // （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
	                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
	                    result.append('\n');
	                    result.append(indent(number));
	                }

	                // （2）打印：当前字符。
	                result.append(key);

	                // （3）前方括号、前花括号，的后面必须换行。打印：换行。
	                result.append('\n');

	                // （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
	                number++;
	                result.append(indent(number));

	                // （5）进行下一次循环。
	                continue;
	            }

	            // 3、如果当前字符是后方括号、后花括号做如下处理：
	            if ((key == ']') || (key == '}')) {
	                // （1）后方括号、后花括号，的前面必须换行。打印：换行。
	                result.append('\n');

	                // （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
	                number--;
	                result.append(indent(number));

	                // （3）打印：当前字符。
	                result.append(key);

	                // （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
	                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
	                    result.append('\n');
	                }

	                // （5）继续下一次循环。
	                continue;
	            }

	            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
	            if ((key == ',')) {
	                result.append(key);
	                result.append('\n');
	                result.append(indent(number));
	                continue;
	            }

	            // 5、打印：当前字符。
	            result.append(key);
	        }

	        return result.toString();
	    }
	  private static String indent(int number) {
	        StringBuffer result = new StringBuffer();
	        for (int i = 0; i < number; i++) {
	            result.append(SPACE);
	        }
	        return result.toString();
	    }
}
