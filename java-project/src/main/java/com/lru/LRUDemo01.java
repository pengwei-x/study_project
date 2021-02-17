package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用算法 LRU
 *
 * @author pengwei
 * @date 2021/2/15
 */
public class LRUDemo01<k, v> extends LinkedHashMap<k, v> {
    /**
     * 坑位
     */
    private int capaCity;

    //    public LRUDemo01(int initialCapacity, float loadFactor, boolean accessOrder) {
//        super(initialCapacity, loadFactor, accessOrder);
//    }
    public LRUDemo01(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capaCity=initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {

        return super.size()>capaCity;
    }
}
