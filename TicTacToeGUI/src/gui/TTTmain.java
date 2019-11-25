package gui;

import javax.swing.SwingUtilities;

public class TTTmain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				TTTGUI ttt = new TTTGUI();

			}

		});
	}
}
