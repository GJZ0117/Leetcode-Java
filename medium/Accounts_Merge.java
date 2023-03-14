package medium;

import java.util.*;

/**
 * 721. Accounts Merge
 */

public class Accounts_Merge {
    Map<String, String> map = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> mailToName = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!map.containsKey(account.get(i))) {
                    map.put(account.get(i), account.get(i));
                    mailToName.put(account.get(i), account.get(0));
                }
                if (i > 1) {
                    map.put(find(account.get(i)), find(account.get(i - 1)));
                }
            }
        }

        Map<String, List<String>> temp = new HashMap<>();
        for (String email : map.keySet()) {
            String root = find(email);
            if (!temp.containsKey(root)) {
                temp.put(root, new ArrayList<>());
            }
            temp.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String root : temp.keySet()) {
            List<String> list = temp.get(root);
            Collections.sort(list);
            list.add(0, mailToName.get(root));
            ans.add(list);
        }
        return ans;
    }

    private String find(String s) {
        if (!map.get(s).equals(s)) {
            map.put(s, find(map.get(s)));
        }
        return map.get(s);
    }
}
