package chapter_5;

import java.util.*;

/*
* 380. O(1) 时间插入、删除和获取随机元素
* */
public class five_30 {
    Map<Integer, Integer> dict;  // 数字：list索引
    List<Integer> list;
    Random rand = new Random();  // 这个放外面的话只用new一次，速度会快不少

    /**
     因为它要插入、删除、随机获取为O(1)，首先来看插入、删除哈希表可以做到，但是随机获取哈希表
     最不到，因为哈希表没有索引，只能通过key来获取value，所以引入了list。通过它俩的结合，哈希
     表存储list的索引，和其值。
     插入时，list就直接插在最后面。
     随机获取时，直接随机获取list的索引。
     这里说一下为什么用的是ArrayList，因为它底层是通过动态数组完成的，根据索引插入和删除是O(1)，
     而LinkedList是通过链表实现的，插入和删除达不到O(1)。
     着重说一下，remove。因为要随机取数，所以几个数字必须是连续的，所以每次删除时，要把呢个删除
     的数和list末尾的数交换，以及改变哈希表key的value。
     */
    public five_30() {
        dict = new HashMap();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val))
            return false;
        else {
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val))
            return false;
        else {
            //交换
            int current_index = dict.get(val);
            int last_index =  list.size() - 1;
            int last_value = list.get(list.size() - 1);
            list.set(current_index, last_value);
            dict.put(last_value, current_index);
            // 删除
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }
    }

    public int getRandom() {
        // Random rand = new Random();
        return list.get(rand.nextInt(list.size()));  // nextInt为[0,x)

        // int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        // randNumber将被赋值为一个MIN和MAX范围内的随机数
    }
}
