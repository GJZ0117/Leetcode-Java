package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. Encode and Decode TinyURL
 */

public class Encode_and_Decode_TinyURL {
    public class Codec {

        Random random = new Random();
        Map<Integer, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int key = random.nextInt();
            while (map.containsKey(key)) {
                key = random.nextInt();
            }
            map.put(key, longUrl);
            return "https://newurl.com/" + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String[] strs = shortUrl.split("/");
            int key = Integer.parseInt(strs[strs.length - 1]);
            return map.get(key);
        }
    }
}
