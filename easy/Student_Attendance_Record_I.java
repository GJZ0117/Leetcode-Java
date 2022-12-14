package easy;

/**
 * 551. Student Attendance Record I
 */

public class Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        int absentTimes = 0;
        int consecutiveLateTimes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentTimes++;
                consecutiveLateTimes = 0;
                if (absentTimes == 2) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                consecutiveLateTimes++;
                if (consecutiveLateTimes == 3) {
                    return false;
                }
            } else {
                consecutiveLateTimes = 0;
            }
        }
        return true;
    }
}
