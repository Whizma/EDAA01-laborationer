package textproc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
	
	private Map<String, Integer> wordMap;
	private Set<String> wordSet;
	
	public GeneralWordCounter (Set<String> stopwords) {
		wordMap = new HashMap<String, Integer>();
		for (String s : stopwords) {
			wordSet.add(s);
		}
	}
	public void process (String word) {
		if (!wordSet.contains(word)) {
			int freq = wordMap.getOrDefault(word, null) + 1;
			wordMap.put(word, freq);
		}
	}
	
	public void report () {
		for (String key : wordMap.keySet()) {
			if (wordMap.get(key) >= 200) {
				System.out.println(key.toString() + " " + wordMap.get(key));
			}
		}
	}
}
