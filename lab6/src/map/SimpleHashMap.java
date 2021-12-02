package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	private int capacity;
	int size = 0;
	private final double loadFactor = .75;

	@SuppressWarnings("unchecked")
	public SimpleHashMap() {
		capacity = 16;
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		this.capacity = capacity;
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		Entry<K, V> node = null;

		for (int i = 0; i < table.length; i++) {
			sb.append(i + "\t{");
			node = table[i];
			if (node != null) {
				while (node.next != null) {
					sb.append(node.toString() + ", ");
					node = node.next;
				}
				sb.append(node.toString());
			}
			sb.append("}\n");
		}
		return sb.toString();
	}

	private int index(K key) {
		return Math.abs(key.hashCode() % table.length);
	}
	private Entry<K, V> find(int index, K key) {
		Entry<K, V> node = table[index];

		while (node != null && !node.key.equals(key)) {
			node = node.next;
		}
		return node;
	}

	@Override
	public V get(Object object) {
		Entry<K, V> node = find(index((K) object), (K) object);
		if (node != null) {
			return node.getValue();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> node = find(index(key), key);
		if (node == null) {
			node = table[index(key)];

			if (node == null) {
				table[index(key)] = new Entry<K, V>(key, value);
			} else {
				while (node.next != null) {
					node = node.next;
				}
				node.next = new Entry<K, V>(key, value);
			}
		} else {
			V oldValue = node.getValue();
			node.setValue(value);
			return oldValue;
		}
		size++;

		if ((double) size / (double) capacity >= loadFactor) {
			rehash();
		}
		return null;
	}

	private void rehash() {
		int oldCapacity = capacity;
		capacity *= 2;
		Entry<K, V>[] oldTable = table;
		table = (Entry<K, V>[]) new Entry[capacity];
		size = 0;
		Entry<K, V> node = null;
		for (int i = 0; i < oldCapacity; i++) {
			node = oldTable[i];
			while (node != null) {
				put(node.getKey(), node.getValue());
				node = node.next;
			}
		}
		oldTable = null;
	}

	@Override
	public V remove(Object arg) {
		K key = (K) arg;
		int index = index(key);
		Entry<K,V> node = find(index, key);
		
		while (node != null) {
			if (node.getKey().equals(key)) {
				table[index] = node.next;
				size--;
				return node.getValue();
			}
			else if (node.next != null && node.next.key.equals(key)) {
				V value = node.next.getValue();
				node.next = node.next.next;
				size--;
				return value;
			}
			node = node.next;
		}
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
