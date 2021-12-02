package map;

import java.util.Random;

public class SimpleHashMapMain {

	public static final String[] landskap = {"blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland"};
	public static void main(String[] args) {
		Random random = new Random();
		SimpleHashMap<String, Integer> map = new SimpleHashMap<String, Integer>(10);
		addRandom(map, random);
		System.out.println(map.show());
		removeAll(map);
		System.out.println(map.show());
		
	}

	private static void addRandom(SimpleHashMap<String, Integer> map, Random random) {
		int iterations = 10;
		for (int i = 0; i < iterations; i++) {
			map.put(landskap[random.nextInt(landskap.length)], random.nextInt(100));
		}
	}

	private static void removeAll(SimpleHashMap<String, Integer> map) {
		for (int i = 0; i < landskap.length; i++) {
			map.remove(landskap[i]);
		}
	} 
}
