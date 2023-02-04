package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System
 */

public class Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split(" ");
            String p = strs[0];
            for (int i = 1; i<strs.length; i++) {
                String file = strs[i];
                String fileName = file.substring(0, file.indexOf("("));
                String fileContent = file.substring(file.indexOf("(") + 1, file.length() - 1);
                String fullPath = p + "/" + fileName;
                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(fullPath);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(fullPath);
                    map.put(fileContent, list);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                ans.add(entry.getValue());
            }
        }

        return ans;
    }
}
