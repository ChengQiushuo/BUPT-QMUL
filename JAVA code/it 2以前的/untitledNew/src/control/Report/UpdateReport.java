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
import entity.RamenInfo;

public class UpdateReport {

public  void updateReport(ExtraInfo ExtraInfo,RamenInfo RamenInfo) {
	Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    SimpleDateFormat formatter = new SimpleDateFormat(("yyyyMMdd"));
    Date date = new Date(System.currentTimeMillis());
    File f = new File("./report/" + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json");
    try {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String str = null;
        String data = "";
        while ((str = br.readLine()) != null) {
            data = data + str + "\n";
        }
        JSONObject dataObject = new JSONObject(data);
        JSONArray extraArray = dataObject.getJSONArray("extra");
        JSONArray compulsoryArray = dataObject.getJSONArray("compulsory");
        for (int count2 = 0; count2 < ExtraInfo.dishName.length; count2++) {
            int a1 = extraArray.getJSONObject(count2).getInt("number");
            a1 = a1 + ExtraInfo.extraCount[count2];
            extraArray.getJSONObject(count2).put("number", a1);
        }
        for (int i = 0; i < RamenInfo.ramen; i++) {
            String choice[] = RamenInfo.ramenOrder[i].split("\\,");
            for (int count = 0; count < Ramen.cominfo.dish_len; count++) {
                JSONArray array = compulsoryArray.getJSONObject(count).getJSONArray("options");
                for (int count1 = 0; count1 < array.length(); count1++) {
                    String s1 = new String(array.getJSONObject(count1).getString("item"));
                    String s2 = new String(choice[count]);
                    if (s2.equals(s1)) {
                        int a = array.getJSONObject(count1).getInt("number");
                        a++;
                        array.getJSONObject(count1).put("number", a);
                        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./report/"
                                + (Integer.parseInt(formatter.format(date)) + 1 - (cal.get(Calendar.DAY_OF_WEEK) - 1)) + "info.json"));
                        String updatedJson = formatJson(dataObject.toString());
                        osw.write(updatedJson);
                        osw.flush();
                        osw.close();
                    }
                }
            }
        }

    }
    catch(FileNotFoundException O){
        O.printStackTrace();
    } catch(IOException O){
        O.printStackTrace();
    }
}
private static String SPACE = "   ";

/**
 * 返回格式化JSON字符串。
 *
 * @param json 未格式化的JSON字符串。
 * @return 格式化的JSON字符串。
 */
public static String formatJson(String json) {
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

/**
 * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
 *
 * @param number 缩进次数。
 * @return 指定缩进次数的字符串。
 */
private static String indent(int number) {
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < number; i++) {
        result.append(SPACE);
    }
    return result.toString();
}

}
