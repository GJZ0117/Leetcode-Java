package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. Camelcase Matching
 */

public class Camelcase_Matching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>(queries.length);
        for (String query : queries) {
            list.add(check(pattern, query));
        }
        return list;
    }

    private boolean check(String pattern, String query) {
        int patternIndex = 0;
        int queryIndex = 0;
        while (patternIndex < pattern.length()) {
            while (queryIndex < query.length() && pattern.charAt(patternIndex) != query.charAt(queryIndex) && Character.isLowerCase(query.charAt(queryIndex))) {
                queryIndex++;
            }
            if (queryIndex == query.length() || query.charAt(queryIndex) != pattern.charAt(patternIndex)) {
                return false;
            }
            queryIndex++;
            patternIndex++;
        }
        while (queryIndex < query.length() && Character.isLowerCase(query.charAt(queryIndex))) {
            queryIndex++;
        }
        return queryIndex == query.length();
    }
}
