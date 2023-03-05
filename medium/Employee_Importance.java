package medium;

import java.util.*;

/**
 * 690. Employee Importance
 */

public class Employee_Importance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int ans = 0;
        Employee employee;
        Deque<Employee> deque = new ArrayDeque<>();
        deque.offer(map.get(id));
        while (!deque.isEmpty()) {
            employee = deque.pollFirst();
            ans += employee.importance;
            for (int subordinateId : employee.subordinates) {
                deque.offer(map.get(subordinateId));
            }
        }
        return ans;
    }
}
