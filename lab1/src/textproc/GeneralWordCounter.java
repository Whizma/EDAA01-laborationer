package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
	
	private Map<String, Integer> wordMap;
	private Set<String> wordSet;
	
	public GeneralWordCounter (Set<String> stopwords) {
		wordMap = new HashMap<String, Integer>();
		wordSet = new HashSet<String>();
		for (String s : stopwords) {
			wordSet.add(s);
		}
	}
	public void process (String word) {
		if (!wordSet.contains(word)) {
			if (!wordMap.containsKey(word)) {
				wordMap.put(word, 1);
			}
			int freq = wordMap.get(word);
			wordMap.put(word, freq + 1);
		}
	}
	
	public void report () {
		Set<Map.Entry<String, Integer>> wordSet = counts.entrySet();
		List<Map.Entry<String,Integer>> wordList = new ArrayList<>(wordSet);
		/* for (String key : wordMap.keySet()) {
			if (wordMap.get(key) >= 200) {
				System.out.println(key.toString() + " " + wordMap.get(key));
			}
		}
		*/
	}
}
