package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
	
	private Map<String, Integer> wordMap;
	private Set<String> stopwordSet;
	
	public GeneralWordCounter (Set<String> stopwords) {
		wordMap = new TreeMap<String, Integer>();
		stopwordSet = new HashSet<String>();
		for (String s : stopwords) {
			stopwordSet.add(s);
		}
	}
	
	public List<Map.Entry<String, Integer>> getWordList() {
		return new ArrayList<Map.Entry<String,Integer>>(wordMap.entrySet());
		}
	
	public void process (String word) {
		if (!stopwordSet.contains(word)) {
			if (!wordMap.containsKey(word)) {
				wordMap.put(word, 1);
			}
			int freq = wordMap.get(word);
			wordMap.put(word, freq + 1);
		}
	}
	
	public void report () {
		Set<Map.Entry<String, Integer>> wordSet = wordMap.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		for (int i = 0; i < 600; i++) {
			System.out.println(wordList.get(i).toString());
		}
		
		/* for (String key : wordMap.keySet()) {
			if (wordMap.get(key) >= 200) {
				System.out.println(key.toString() + " " + wordMap.get(key));
			}
		}
		*/
	}
}
