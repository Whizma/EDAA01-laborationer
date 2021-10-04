package textproc;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BookReaderController {
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();

		// pane �r en beh�llarkomponent till vilken de �vriga komponenterna (listvy,
		// knappar etc.) ska l�ggas till.
		frame.pack();
		frame.setVisible(true);
	}
}
