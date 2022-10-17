package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 692. Top K Frequent Words
 */

public class Top_K_Frequent_Words {

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>(); //the final return answer
        Map<String, Integer> map = new HashMap<>(); //calculate each string's frequency

        for (String s : words) { //calculate each string's frequency
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); //use a list to save each string and its frequency which are used to sort
        sortList(list); //sort the list as each string's frequency and lexicographical order
        for (int i=0; i<k; i++) {
            ans.add(list.get(i).getKey());
        }
        return ans;
    }


    public static void sortList(List<Map.Entry<String, Integer>> list) { //bubble sort
        Map.Entry<String, Integer> temp;
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (compare(list.get(j), list.get(j + 1)) == -1) {
                    flag = true;
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    //if map1 is in front of map2 than return 1, else return -1
    public static int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
        if (map1.getValue() > map2.getValue()) { // str1's frequenct > str2's frequency
            return 1;
        } else if (map1.getValue().equals(map2.getValue())) { //str1's frequenct == str2's frequency then check lexicographical order
            int minLen = Math.min(map1.getKey().length(), map2.getKey().length());
            for (int i = 0; i < minLen; i++) {
                if (map1.getKey().charAt(i) < map2.getKey().charAt(i)) {
                    return 1;
                } else if (map1.getKey().charAt(i) > map2.getKey().charAt(i)) {
                    return -1;
                }
            }
            if (map1.getKey().length() == minLen) {
                return 1;
            } else {
                return -1;
            }
        } else { //str1's frequenct < str2's frequency
            return -1;
        }
    }
}