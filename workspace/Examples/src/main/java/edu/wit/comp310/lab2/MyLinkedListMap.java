package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.*; // :-(
import java.util.Set;

import edu.wit.comp310.lab1.MyLinkedList;

public class MyLinkedListMap<Key extends Comparable<Key>,Value> implements Map<Key,Value>{
	List<Pair<Key, Value>> list = new MyLinkedList<Pair<Key, Value>>();

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		for (Pair<Key,Value> item : list) {
			if (item.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for(Pair<Key,Value> item: list){
			if(item.value.equals(arg0)){
				return true;
			}
		}
		return false;
	}

	@Override
	public java.util.Set<java.util.Map.Entry<Key, Value>> entrySet() {
		Set<java.util.Map.Entry<Key, Value>> result = new HashSet<java.util.Map.Entry<Key, Value>>();
		for (Pair<Key, Value> item : list) {
			result.add(item);
		}
		return result;
	}

	@Override
	public Value get(Object arg0) {
		for (Pair<Key, Value> item : list) {
			if (item.key.equals(arg0)) {
				return item.value;
			}
		}
	return null;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Set<Key> keySet() {
		Set<Key> set = new HashSet<Key>();
		for (Pair<Key, Value> item : list) {
			set.add(item.key);

		}
		return set;
	}

	@Override
	public Value put(Key key, Value value) {
		// First, loop through the list
		// to see if the key is already in the list
		for (Pair<Key, Value> item : list) {
			// We encountered the previous value
			if (item.key.equals(key)) {
				Value temp = item.value;
				item.value = value;
				return temp;
			}
		}
		list.add(new Pair<Key, Value>(key,value));
		return null;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> map) {
		for(java.util.Map.Entry<? extends Key, ? extends Value> item : map.entrySet()) {
			put(item.getKey(), item.getValue());
		}
	}

	@Override
	public Value remove(Object arg0) {
		for (Pair<Key, Value> item : list) {
			if (item.key.equals(arg0)) {
				Value temp = item.value;	
				list.remove(item);
				return temp;	
				}
		}
		return null;
	}		

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Collection<Value> values() {
		MyLinkedList <Value> olist = new MyLinkedList<Value>();
		for (Pair<Key, Value> item : list) {
		olist.add(item.value);
		}
		return olist;
	}
	
}
