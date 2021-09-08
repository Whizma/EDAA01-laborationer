package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };
	
	private static Set<String> scanStopWords() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<String>();
		while (scan.hasNext()) {
			stopwords.add(scan.next());
		}
		scan.close();
		return stopwords;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor q = new SingleWordCounter("norge");
		TextProcessor multi = new MultiWordCounter(REGIONS);
		TextProcessor general = new GeneralWordCounter(scanStopWords());

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning'			

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

		//	p.process(word);
		//	q.process(word);
		//	multi.process(word);
			general.process(word);
		}		
		// s.close();
		// p.report();
		// q.report();
		// multi.report();
		general.report();
	}
}