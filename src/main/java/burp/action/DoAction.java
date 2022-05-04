package burp.action;

import java.util.HashMap;
import java.util.Map;
import burp.Config;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EvilChen
 */

public class DoAction {
    public Map<String, String> extractString(Map<String, Map<String, Object>> obj) {
        Map<String, String> resultMap = new HashMap<String, String>();
        obj.keySet().forEach(i->{
            Map<String, Object> tmpMap = obj.get(i);
            String data = tmpMap.get("data").toString();
            resultMap.put(i, String.format("%s\n", data).intern());
        });
        return resultMap;
    }

    public List<List<String>> highlightAndComment(Map<String, Map<String, Object>> obj) {
        List<String> colorList = new ArrayList<>();
        List<String> commentList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        obj.keySet().forEach(i->{
            Map<String, Object> tmpMap = obj.get(i);
            String color = tmpMap.get("color").toString();
            colorList.add(color);
            commentList.add(i);
        });
        result.add(colorList);
        result.add(commentList);
        return result;
    }
}