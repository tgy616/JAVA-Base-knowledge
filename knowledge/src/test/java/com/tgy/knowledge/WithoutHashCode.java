package com.tgy.knowledge;

import java.util.HashMap;

/**
 * 没有重写hashcode
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-11-29 17:34
 **/

public class WithoutHashCode {
    public static void main(String[] args) {
        Key k1 = new Key(1);
        Key k2 = new Key(1);
        HashMap<Key, String> hm = new HashMap<Key, String>();
        hm.put(k1, "Key with id is 1");
        System.out.println(hm.get(k2));
    }
}

class Key {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public Key(Integer id) {
        this.id = id;
    }
    //故意先注释掉equals和hashCode方法
    //  public boolean equals(Object o) {
    //      if (o == null || !(o instanceof Key))
    //      { return false; }
    //      else
    //      { return this.getId().equals(((Key) o).getId());}
    //  }

    //  public int hashCode()
    //  { return id.hashCode(); }
}
