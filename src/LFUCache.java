import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    /*leetcode460、LFUCache
    *
    * */
    // 存储缓存的内容。
    Map<Integer, Node> cache;
    // 存储每个访问频次对应的内容链表。
    Map<Integer, LinkedHashSet<Node>> freqMap;
    // 缓存内容长度。
    int capacity;
    // 记录最小访问频次。
    int minFreq;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
        int minFreq = 1;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        // 更新当前节点访问频次。
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        // 如果插入的节点已存在则直接覆盖并更新访问频次，否则创建新节点插入。
        if (node == null){
            // 如果缓存满了，则移除最后一个节点。
            if (cache.size() == capacity){
                removeNode();
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
        } else {
            node.value = value;
            updateFreq(node);
        }
    }

    public void updateFreq(Node node){
        // 当前节点之前的访问频次。
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        // 在之前访问频次的链表中删除当前节点。
        set.remove(node);
        // 当前节点的访问频次最小，并且没有相同访问频次的节点了，则最小访问频次 +1 。
        if (freq == minFreq && set.size() == 0) {
            minFreq = freq + 1;
        }

        // 当前节点的访问频次 +1 。
        node.freq++;
        // 然后将更新访问频次后的节点添加到对应访问频次的链表中。
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null){
            newSet = new LinkedHashSet<>();
            freqMap.put(freq+1, newSet);
        }
        newSet.add(node);
    }

    public void removeNode(){
        // 移除最小访问频次链表的最后一个节点。
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        // 得到最先加入当前链表的节点。
        Node node = set.iterator().next();
        set.remove(node);
        // 移除 key 对应在 cache map 中的节点。
        Node cacheNode = cache.get(node.key);
        cache.remove(cacheNode.key);
    }

    public void addNode(Node node){
        int freq = node.freq;
        // 添加的新节点加入访问频次为 1 的链表中。
        LinkedHashSet<Node> set = freqMap.get(freq);
        if (set == null){
            set = new LinkedHashSet<>();
            freqMap.put(node.freq, set);
        }
        set.add(node);
        // 记录最小访问频次。
        minFreq = node.freq;
        // 将新节点加入缓存。
        cache.put(node.key, node);
    }
}

class Node{
    int key;
    int value;
    int freq;
    // 封装一个包含key、value和初始化访问频次为 1 的节点。
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
    }
}