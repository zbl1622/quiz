package com.leetcode.quiz;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 981. 基于时间的键值存储
 * 创建一个基于时间的键值存储类TimeMap，它支持下面两个操作：
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * 存储键key、值value，以及给定的时间戳timestamp。
 * 2. get(string key, int timestamp)
 * <p>
 * 返回先前调用set(key, value, timestamp_prev)所存储的值，其中timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的timestamp_prev的那个值。
 * 如果没有值，则返回空字符串（""）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释：
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
 * kv.get("foo", 1);  // 输出 "bar"
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // 输出 "bar2"
 * kv.get("foo", 5); // 输出 "bar2"
 * <p>
 * 示例 2：
 * <p>
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在[1, 100]范围内。
 * 所有TimeMap.set操作中的时间戳timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和TimeMap.get函数在每个测试用例中将（组合）调用总计120000 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem981 {

    public static void main(String... args) {
        String[] inputs = {"set", "get", "get", "set", "get", "get"};

        System.out.println(JSON.toJSONString(new Problem981().test()));
    }

    public String test() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        return null;
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
    class TimeMap {
        private HashMap<String, ArrayList<Object[]>> hashMap;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            hashMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            ArrayList<Object[]> list = hashMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                hashMap.put(key, list);
            }
            list.add(new Object[]{value, timestamp});
        }

        public String get(String key, int timestamp) {
            ArrayList<Object[]> list = hashMap.get(key);
            if (list == null) {
                return "";
            } else {
                if (timestamp < (int) list.get(0)[1]) {
                    return "";
                }
                int start = 0;
                int end = list.size() - 1;
                int i = 0;
                while (start <= end) {
                    int index = (start + end) >> 1;
                    int t = (int) list.get(index)[1];
                    if (t <= timestamp) {
                        i = index;
                        start = index + 1;
                    } else {
                        end = index - 1;
                    }
                }
                return (String) list.get(i)[0];
            }
        }
    }

}