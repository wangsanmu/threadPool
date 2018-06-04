package com.wangsen.fanxing;

/**
 * @author wangsen
 * @data 2018/5/20 20:21
 * @des
 */
public class Pair<K,V> {

    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    public static <K extends Comparable<K>,V extends Comparable<V>> int countGreateThen(K[] arrayK,V[] arrayV,K k,V v){
        int  count= 0;
        for(K ka:arrayK){
            if(ka.compareTo(k) == 0){
               ++count;
            }
        }

        for (V va:arrayV){
            if(va.compareTo(v) == 0 ){
                ++count;
            }
        }

        return count;
    }


    static class Util {
        public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
            return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
        }
    }


    public static void main(String[] args) {
        Pair<String,Integer> stringStringPair1 = new Pair<String, Integer>("String",1);
        Pair<String,Integer> stringStringPair2 = new Pair<String, Integer>("String",2);
        System.out.println(Pair.Util.compare(stringStringPair1,stringStringPair2));

        String[] strings = new String[3];
        strings[0] = "a";
        strings[1] = "b";
        strings[2] = "a";
//        System.out.println(strings.toString());

        Integer[] integers = new Integer[2];
        integers[0] = 1;
        integers[1] = 2;
        System.out.println(Pair.countGreateThen(strings,integers,"a",1));
    }

}
