package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 1418. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders{i}={customerNamei,tableNumberi,foodItemi} ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：orders = {{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}}
 * 输出：{{"Table","Beef Burrito","Ceviche","Fried Chicken","Water"},{"3","0","2","1","0"},{"5","0","1","0","1"},{"10","1","0","0","0"}}
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem1418 {

    public static void main(String... args) {
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList("David", "3", "Ceviche"));
        orders.add(Arrays.asList("Corina", "10", "Beef Burrito"));
        orders.add(Arrays.asList("David", "3", "Fried Chicken"));
        orders.add(Arrays.asList("Carla", "5", "Water"));
        orders.add(Arrays.asList("Carla", "5", "Ceviche"));
        orders.add(Arrays.asList("Rous", "3", "Ceviche"));

        System.out.println(JSON.toJSONString(new Problem1418().displayTable(orders)));
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> foodSet = new HashSet<>();
        HashMap<Integer, HashMap<String, Integer>> tableFoodMap = new HashMap<>();
        for (List<String> list : orders) {
            int table = Integer.parseInt(list.get(1));
            String food = list.get(2);
            foodSet.add(food);
            HashMap<String, Integer> foodCountMap = tableFoodMap.get(table);
            if (foodCountMap == null) {
                foodCountMap = new HashMap<>();
                tableFoodMap.put(table, foodCountMap);
            }
            if (foodCountMap.containsKey(food)) {
                foodCountMap.put(food, foodCountMap.get(food) + 1);
            } else {
                foodCountMap.put(food, 1);
            }
        }
        List<Integer> tableList = new ArrayList<>(tableFoodMap.keySet());
        Collections.sort(tableList);
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);

        List<List<String>> resultList = new ArrayList<>();
        List<String> headList = new ArrayList<>();
        headList.add("Table");
        headList.addAll(foodList);
        resultList.add(headList);
        for (int table : tableList) {
            List<String> itemList = new ArrayList<>();
            itemList.add(String.valueOf(table));
            for (String food : foodList) {
                HashMap<String, Integer> foodCountMap = tableFoodMap.get(table);
                if (foodCountMap.containsKey(food)) {
                    itemList.add(String.valueOf(foodCountMap.get(food)));
                } else {
                    itemList.add("0");
                }
            }
            resultList.add(itemList);
        }
        return resultList;
    }
}