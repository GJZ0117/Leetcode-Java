package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 299. Bulls and Cows
 */

public class Bulls_and_Cows {

    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        List<Integer> bulls = new ArrayList<>(); //record index which both position and value equal
        Map<Character, Integer> mapS = new HashMap<>(); //record secret's character and its frequency except bulls
        Map<Character, Integer> mapG = new HashMap<>(); //record guess's character and its frequency except bull

        int len = secret.length();

        for (int i = 0; i < len; i++) { //find bulls and add their indexs into list
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls.add(i);
            }
        }

        for (int i = 0; i < len; i++) { //count secret's and guess's character as well as their frequency(not conatined in bull list)
            if (!bulls.contains(i)) {
                char charS = secret.charAt(i);
                char charG = guess.charAt(i);
                mapG.put(charG, mapG.containsKey(charG) ? mapG.get(charG) + 1 : 1);
                mapS.put(charS, mapS.containsKey(charS) ? mapS.get(charS) + 1 : 1);
            }
        }

        int cows = 0;
        for (Character c : mapG.keySet()) { //check each character in secret, find if they also showed in guess. if true then add the samller one
            if (mapS.containsKey(c)) {
                cows += Math.min(mapG.get(c), mapS.get(c));
            }
        }

        return bulls.size() + "A" + cows + "B";
    }


    // 二刷
    public String getHint_2(String secret, String guess) {
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                aCount++;
            } else {
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : secretMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (guessMap.containsKey(key)) {
                bCount += Math.min(value, guessMap.get(key));
            }
        }

        return aCount + "A" + bCount + "B";
    }
}
