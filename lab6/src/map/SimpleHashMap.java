package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K,V>[] table;
	private int capacity;
	int size = 0;
	private final double loadFactor = .75;
	
	SimpleHashMap() {
		capacity = 16;
		table = (Entry<K,V>[]) new Entry[capacity];
	}
	
	@SuppressWarnings("unchecked")
	SimpleHashMap(int capacity) {
		this.capacity = capacity;
		table = (Entry<K,V>[]) new Entry[capacity];
	}
	
	public String show() {
		String s = "";
		for (int i = 0;  i < table.length; i++) {
			s+=table[i].toString() + "\n";
		}
		return s;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % size);
	}
	
	private Entry<K,V> find(int index, K key) {
		if (table[index].getKey() == key) {
			return table[index];
		}
		return null;
	}
	
	@Override
	public V get(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> node = find(index(key, arg))
	}

	@Override
	public V remove(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}
	}

}
