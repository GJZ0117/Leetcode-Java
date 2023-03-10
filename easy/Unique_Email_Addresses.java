package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 */

public class Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();
        StringBuilder localName = new StringBuilder();
        for (String email : emails) {
            String[] strs = email.split("@");
            localName.append(strs[0].split("\\+")[0]);
            for (int i = 0; i < localName.length(); i++) {
                if (localName.charAt(i) == '.') {
                    localName.deleteCharAt(i);
                    i--;
                }
            }
            if (map.containsKey(strs[1])) {
                map.get(strs[1]).add(localName.toString());
            } else {
                Set<String> set = new HashSet<>();
                set.add(localName.toString());
                map.put(strs[1], set);
            }
            localName.delete(0, localName.length());
        }
        int res = 0;
        for (Set<String> set : map.values()) {
            res += set.size();
        }
        return res;
    }
}
