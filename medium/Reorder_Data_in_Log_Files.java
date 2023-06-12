package medium;

import java.util.*;

/**
 * 937. Reorder Data in Log Files
 */

public class Reorder_Data_in_Log_Files {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        int index = 0;
        List<String> digitLogs = new ArrayList<>();
        TreeMap<String, List<String>> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int minLen = Math.min(s1.length(), s2.length());
                for (int i = 0; i < minLen; i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return s1.charAt(i) - s2.charAt(i);
                    }
                }
                return s1.length() - s2.length();
            }
        });
        for (String log : logs) {
            int firstSpaceIndex = log.indexOf(' ');
            if (Character.isDigit(log.charAt(firstSpaceIndex + 1))) {
                digitLogs.add(log);
            } else {
                String identifier = log.substring(0, firstSpaceIndex);
                String content = log.substring(firstSpaceIndex + 1, log.length());
                if (treeMap.containsKey(content)) {
                    treeMap.get(content).add(identifier);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(identifier);
                    treeMap.put(content, list);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                sb.append(entry.getValue().get(0));
                sb.append(' ');
                sb.append(entry.getKey());
                res[index++] = sb.toString();
                sb.delete(0, sb.length());
            } else {
                Collections.sort(entry.getValue(), new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        int minLen = Math.min(s1.length(), s2.length());
                        for (int i = 0; i < minLen; i++) {
                            if (s1.charAt(i) != s2.charAt(i)) {
                                return s1.charAt(i) - s2.charAt(i);
                            }
                        }
                        return s1.length() - s2.length();
                    }
                });
                for (String identifier : entry.getValue()) {
                    sb.append(identifier);
                    sb.append(' ');
                    sb.append(entry.getKey());
                    res[index++] = sb.toString();
                    sb.delete(0, sb.length());
                }
            }
        }
        for (String s : digitLogs) {
            res[index++] = s;
        }
        return res;
    }
}
