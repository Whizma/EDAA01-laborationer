package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
	Map<String, Integer> m;
	
	public MultiWordCounter(String[] landskap)	{
		m = new HashMap<String, Integer>();
		for (String s : landskap) {
			m.put(s, 0);
		}
	}
	
	public void process(String word) {
		for (String key : m.keySet()) {
			if (key.equalsIgnoreCase(word)) {
				int freq = m.get(key);
				m.put(key, freq + 1);
			}
		}
	}
	
	public void report() {
		for (String key : m.keySet()) {
			System.out.println(key.toString() + " " + m.get(key));
		}
	}
}
