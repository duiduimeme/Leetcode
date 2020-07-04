import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class leetcode146 {

    /*
    * 146、实现一个LRU缓存
    * */

    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LinkedHashMap LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
        return cache;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int val = cache.get(key);
        cache.remove(key); // 从链表中删除
        cache.put(key, val); // 添加到链尾

        return val;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key); // 已经存在，链表中删除
        }

        if (capacity == cache.size()) {
            // cache 已满,删除链表头
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// 添加到链尾
    }
}
