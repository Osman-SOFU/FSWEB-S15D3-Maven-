package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // LinkedList tanımlama
        LinkedList<Employee> employeeList = new LinkedList<>();

        // Listeye birkaç Employee ekleyelim (bazıları tekrar edecek şekilde)
        employeeList.add(new Employee(1, "Doğancan", "Yılmaz"));
        employeeList.add(new Employee(2, "Ayşe", "Demir"));
        employeeList.add(new Employee(3, "Mehmet", "Kaya"));
        employeeList.add(new Employee(2, "Ayşe", "Demir"));    // Tekrar
        employeeList.add(new Employee(4, "Burak", "Cevizli"));
        employeeList.add(new Employee(3, "Mehmet", "Kaya"));   // Tekrar
        employeeList.add(new Employee(5, "Ali", "Öztürk"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new LinkedHashSet<>(); // LinkedHashSet kullanıldı

        for (Employee e : employees) {
            // Eğer bu employee önceden görülmüşse, duplicates set'ine ekle
            if (!seen.add(e)) {
                duplicates.add(e);
            }
        }

        // Set'i listeye çevirip döndürür
        return new LinkedList<>(duplicates);
    }


    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Employee, Integer> frequencyMap = new HashMap<>();

        // Her bir Employee'nin listede kaç kez geçtiğini sayar.
        for (Employee e : employees) {
            if (e == null) continue;  // null değerleri atla
            frequencyMap.put(e, frequencyMap.getOrDefault(e, 0) + 1);
        }

        Map<Integer, Employee> uniqueMap = new HashMap<>();
        // Sadece bir kez geçen veya tekrar edenlerden bir tanesini seçer
        for (Map.Entry<Employee, Integer> entry : frequencyMap.entrySet()) {
            Employee employee = entry.getKey();
            // employee null olmayacak, çünkü null'lar frequencyMap'e eklenmedi
            int employeeId = (int) employee.getId();
            // Eğer bu employee daha önce uniqueMap'e eklenmemişse ekle
            if (!uniqueMap.containsKey(employeeId)) {
                uniqueMap.put(employeeId, employee);
            }
        }

        return uniqueMap;
    }



    public static List<Employee> removeDuplicates(List<Employee> employees) {
        // Her bir Employee'nin kaç kez geçtiğini sayan bir harita oluşturuyoruz.
        Map<Employee, Integer> frequencyMap = new HashMap<>();
        for (Employee e : employees) {
            // Eğer employee null ise atla
            if(e == null) continue;
            frequencyMap.put(e, frequencyMap.getOrDefault(e, 0) + 1);
        }

        // Sadece bir kez geçen employee'ları içeren listeyi oluşturuyoruz.
        List<Employee> uniqueList = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueList.add(entry.getKey());
            }
        }

        return uniqueList;
    }

}
