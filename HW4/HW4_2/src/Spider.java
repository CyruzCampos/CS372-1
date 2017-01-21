import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

/**
 * @author CyruzCampos
 * This is the Spider class
 */
public class Spider {
	
	static Map<String, Boolean> Webs = new HashMap<String, Boolean>(); 
	
	/**
	 * The LinktoLink function, is a function that adds one link to the Hashmap (to get things started), and sets a counter to 1 so we can keep track on how many times
	 * this program runs. Then grabs the link from the Hashmap and sets it to a string value, which goes through a buffered reader and input stream reader, then checks
	 * if the link could connect and prompts the user that either the link did or did not connect. Then goes through the HTML coding and finds more links and then saves
	 * them to the Hashmap. Then goes the program again 100 times or until there are no more links to be found. The counter keeps track of how many times this program
	 * runs.
	 */
	public void LinktoLink() {
		Webs.put("http://www.whitworth.edu/cms", false);
		int counter = 1;
		do {
			try {
				Iterator<Entry<String, Boolean>> iterator = Webs.entrySet().iterator();
				Entry<String, Boolean> entry = iterator.next();
				iterator.remove();
				String link = entry.getKey();
				
				if (entry.getValue() == false) {
					System.out.printf("%s. Trying to connect to: %s\n", counter, link);
					Thread.sleep(1000);
					URL url = new URL(link);
					BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
						if (rdr.ready() == true) {
							System.out.printf("\t%s connected successfully!\n\n", link);
						
							String line;
							while ((line = rdr.readLine()) != null) {
								Pattern hyperlink = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
								Matcher matcher = hyperlink.matcher(line);
								if (matcher.find()) {
									String save = matcher.group(1);
									Webs.put(save, false);
								}
							}
							Thread.sleep(1000);
							counter++;
						}
					
						else {
							System.out.printf("\t%s could not connect...\n\n", link);
							Thread.sleep(1000);
							counter++;
						}
				}
					entry.setValue(true);
			}
			catch (Exception ex) {
				System.out.printf("%d. Oops: %s \n\tAttempting to Connect again...\n\n", counter,ex.getMessage());
				counter++;
			}
		} while (counter != 101);
	}
}
