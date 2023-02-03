/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp: employees) {
            map.put(emp.id, emp);
        }
        return calculateImportance(map, id, 0);
    }
    
    private int calculateImportance(HashMap<Integer, Employee> empMap, int empId, int totalImportance) {
        
        Employee emp = empMap.get(empId);
        int importance = emp.importance + totalImportance;
        
        for (int subId: emp.subordinates) {
            if (visited.contains(subId)) continue;
            importance+= calculateImportance(empMap, subId, 0);
            visited.add(subId);
        }
        return importance;
    }
}