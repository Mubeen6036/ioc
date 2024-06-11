package com.example.ioc.utils;

import java.util.*;

public class Helper3 {

    public static String[] solution(String[][] queries) {
        Map<String, Map<String, Integer>> database = new HashMap<>();
        Map<String, Integer> modificationCount = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0];
            switch (operation) {
                case "SET_OR_INC":
                    String keySet = query[1];
                    int value = Integer.parseInt(query[3]);
                    if (!database.containsKey(query[1])) {
                        database.put(query[1], new HashMap<>());
                    }
                    database.get(query[1]).put(query[2], database.get(query[1]).getOrDefault(query[2], 0) + value);
                    modificationCount.put(keySet, modificationCount.getOrDefault(keySet, 0) + 1);
                    results.add(String.valueOf(database.get(query[1]).get(query[2])));
                    break;
                case "GET":
                    if (database.containsKey(query[1]) && database.get(query[1]).containsKey(query[2])) {
                        results.add(String.valueOf(database.get(query[1]).get(query[2])));
                    } else {
                        results.add("");
                    }
                    break;
                case "DELETE":
                    if (database.containsKey(query[1]) && database.get(query[1]).containsKey(query[2])) {
                        String keyDelete = query[1];
                        database.get(query[1]).remove(query[2]);
                        modificationCount.remove(keyDelete);
                        if (database.get(query[1]).isEmpty()) {
                            database.remove(query[1]);
                        }
                        results.add("true");
                    } else {
                        results.add("false");
                    }
                    break;
                case "TOP_N_KEYS":
                    int n = Integer.parseInt(query[1]);
                    if (database.isEmpty()) {
                        results.add("");
                        break;
                    }
                    List<Map.Entry<String, Integer>> list = new ArrayList<>(modificationCount.entrySet());
                    list.sort((a, b) -> {
                        int result = b.getValue().compareTo(a.getValue());
                        if (result == 0) {
                            return a.getKey().compareTo(b.getKey());
                        }
                        return result;
                    });
                    StringBuilder result = new StringBuilder();
                    for (int i = 0; i < Math.min(n, list.size()); i++) {
                        String key = list.get(i).getKey();
                        result.append(key).append("(").append(list.get(i).getValue()).append("), ");
                    }
                    results.add(result.substring(0, result.length() - 2));
                    break;
            }
        }
        return results.toArray(new String[0]);
    }

    public static String getTopNKeys(Map<String, Map<String, Integer>> database, Map<String, Integer> modificationCount, int n) {
        if (database.isEmpty()) {
            return "";
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(modificationCount.entrySet());
        list.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(n, list.size()); i++) {
            String key = list.get(i).getKey();
            String[] parts = key.split("_");
            result.append(parts[0]).append("(").append(list.get(i).getValue()).append("), ");
        }
        return result.substring(0, result.length() - 2);
    }

        public static void main(String[] args) {
            String[][] queries = {
                    {"GET", "dept4", "floors"},
                    {"SET_OR_INC", "dept4", "floors", "10"},
                    {"SET_OR_INC", "dept4", "floors", "4"},
                    {"TOP_N_KEYS", "1"},
                    {"TOP_N_KEYS", "1"},
                    {"SET_OR_INC", "dept4", "flowers", "15"},
                    {"SET_OR_INC", "dept3", "floors", "6"},
                    {"SET_OR_INC", "dept3", "floors", "1"},
                    {"GET", "dept4", "floors"},
                    {"TOP_N_KEYS", "1"},
                    {"SET_OR_INC", "dept3", "floors", "1"},
                    {"DELETE", "dept4", "flowers"},
                    {"TOP_N_KEYS", "2"}
            };

            String[] results = solution(queries);
            System.out.println(Arrays.toString(results));
        }
    }
