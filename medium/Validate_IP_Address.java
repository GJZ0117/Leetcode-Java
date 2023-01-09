package medium;

/**
 * 468. Validate IP Address
 */

public class Validate_IP_Address {
    public static void main(String[] args) {
        String queryIp = "192.0.0.1";
        System.out.println(validIPAddress(queryIp));
    }

    public static String validIPAddress(String queryIP) {
        boolean flag4 = queryIP.contains(".");
        boolean flag6 = queryIP.contains(":");
        if ((flag4 && flag6) || (!flag4 && !flag6)) {
            return "Neither";
        } else {
            int count = 0;
            if (flag4) {
                for (char c : queryIP.toCharArray()) {
                    if (c == '.') {
                        count++;
                    }
                }
                if (count != 3) {
                    return "Neither";
                }
                String[] strs = queryIP.split("\\.");
                if (strs.length != 4) {
                    return "Neither";
                }
                for (String str : strs) {
                    if (str.length() == 0 ||str.length() > 3) {
                        return "Neither";
                    }
                    if (str.charAt(0) == '0' && str.length() > 1) {
                        return "Neither";
                    }

                    for (char c : str.toCharArray()) {
                        if (c < '0' || c > '9') {
                            return "Neither";
                        }
                    }
                    int num = Integer.parseInt(str);
                    if (num < 0 || num > 255) {
                        return "Neither";
                    }
                }
                return "IPv4";
            } else {
                for (char c : queryIP.toCharArray()) {
                    if (c == ':') {
                        count++;
                    }
                }
                if (count != 7) {
                    return "Neither";
                }
                String[] strs = queryIP.split(":");
                if (strs.length != 8) {
                    return "Neither";
                }
                for (String str : strs) {
                    if (str.length() == 0 || str.length() > 4) {
                        return "Neither";
                    }
                    for (char c : str.toCharArray()) {
                        if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9')) {
                            continue;
                        } else {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
        }
    }
}
