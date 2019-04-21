/**
 * 
 */
package financeinvoices;

/**
 * @author kloudone
 *
 */
public class SpecialChars {

	public static void main(String[] args) {
		String fileName = "chat.pdf";
		String[] terms = fileName.split("[\\s@&.?$+-]+");
		System.out.println(terms[1]);
	}
}
