package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 */

public class Time_Based_Key_Value_Store {
    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                map.get(key).put(timestamp, value);
            } else {
                TreeMap<Integer, String> timestampMap = new TreeMap<>();
                timestampMap.put(timestamp, value);
                map.put(key, timestampMap);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            } else {
                if (map.get(key).containsKey(timestamp)) {
                    return map.get(key).get(timestamp);
                }
                Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
                return entry == null ? "" : entry.getValue();
            }
        }
    }
}
