package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count
 */

public class Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String domains : cpdomains) {
            String[] s = domains.split(" ");
            int num = Integer.parseInt(s[0]);
            String[] strs = s[1].split("\\.");
            for (int i = strs.length - 1; i >= 0; i--) {
                sb.insert(0, i == strs.length - 1 ? strs[i] : strs[i] + ".");
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + num);
            }
            sb.delete(0, sb.length());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey());
            ans.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return ans;
    }
}
