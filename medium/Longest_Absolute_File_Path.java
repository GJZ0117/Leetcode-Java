package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 388. Longest Absolute File Path
 */

public class Longest_Absolute_File_Path {

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(input));
    }

    public static int lengthLongestPath(String input) {
        List<String> list = new LinkedList<>();
        int curLen = 0;
        int maxLen = 0;
        int preTNum = -1; // the previous str in list contains how many \t (equals 4 spaces)
        input = input.replaceAll("\t", "    "); // replace all \t with 4 spaces
        String[] strs = input.split("\n"); // split the input string by \n
        for (int i = 0; i < strs.length; i++) {
            int curTNum = 0;
            // calculate how many \t current string contains (save extra spaces which are used in file or dictionary name)
            while (curTNum * 4 + 4 < strs[i].length() && "    ".equals(strs[i].substring(curTNum * 4, curTNum * 4 + 4)) && curTNum <= preTNum + 1) {
                curTNum++;
            }
            // if current string's \t number is bigger than previous string's \t number, it means that current string has some extra spaces
            if (curTNum > preTNum + 1) {
                curTNum--;
            }
            // delete the necessary \t in current string and save the extra spaces (one \t equals to 4 spaces)
            String curStr = strs[i].substring(4 * curTNum, strs[i].length());
            // if current string's \t number equals to previous string's \t number + 1, the structure is like this :
            // previous
            //     |____ current
            if (curTNum == preTNum + 1) {
                list.add(curStr);
                curLen += curStr.length();
                preTNum = curTNum;
                // if current string contains ".", it means that this is a file not a dictionary, so compare current path length with max length
                if (curStr.contains(".")) {
                    // for each file or dictionary in list, if connect them as a path, we need to add a "\" to every pair, so current length path is all strings' lengths + list.size()-1
                    maxLen = Math.max(maxLen, curLen + list.size() - 1);
                }
            } else if (curTNum == preTNum) {
                // if current string's \t number equals to previous string's \t number, the structure is like this :
                // ... ...
                //    |____ previous
                //    |____ current
                // remove the last string in the list and add current string into list, update current path length
                curLen -= list.get(list.size() - 1).length();
                list.remove(list.size() - 1);
                list.add(curStr);
                curLen += curStr.length();
                if (curStr.contains(".")) {
                    maxLen = Math.max(maxLen, curLen + list.size() - 1);
                }
            } else {
                // if current string's \t number is smaller than previous string's \t number, the structure is like this :
                // ... ...           ... ...
                //    |                 |____ previous
                //    |____ current
                // calculate the difference, then using the difference to remove the last strings in the list and update current path length
                int diff = preTNum - curTNum + 1;
                while (diff > 0) {
                    curLen -= list.get(list.size() - 1).length();
                    list.remove(list.size() - 1);
                    diff--;
                }
                list.add(curStr);
                curLen += curStr.length();
                preTNum = curTNum;
                if (curStr.contains(".")) {
                    maxLen = Math.max(maxLen, curLen + list.size() - 1);
                }
            }
        }
        return maxLen;
    }

}
