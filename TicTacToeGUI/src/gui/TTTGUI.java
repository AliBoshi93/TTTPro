package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TTTGUI extends JFrame {

	private Container pane;
	private String currentPlayer;
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;

	private JMenuItem quit;
	private JMenuItem newGame;

	public TTTGUI() {
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("Tic Tac Toe");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "x";
		board = new JButton[3][3];
		hasWinner = false;

		InitializeBoard();
		initializeMenuBar();

	}

	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});

		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);

	}

	private void resetBoard() {
		currentPlayer = "x";
		hasWinner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");

			}
		}

	}

	private void InitializeBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton("");
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (((JButton) e.getSource()).getText().equals("") && hasWinner == false) {
							btn.setText(currentPlayer);
							hasWinner();
							togglePlayer();

						}

					}
				});

				pane.add(btn);

			}

		}

	}

	private void togglePlayer() {
		if (currentPlayer.equals("x")) {
			currentPlayer = "o";
		} else {
			currentPlayer = "x";
		}

	}

	public void hasWinner() {

		for (int i = 0; i < 3; i++) {

			if (board[i][0].getText().equals(currentPlayer) && board[i][1].getText().equals(currentPlayer)
					&& board[i][2].getText().equals(currentPlayer) == true) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has win..");
				hasWinner = true;
				resetBoard();
			} 

		}

		for (int i = 0; i < 3; i++) {

			if (board[0][i].getText().equals(currentPlayer) && board[1][i].getText().equals(currentPlayer)
					&& board[2][i].getText().equals(currentPlayer) == true) {
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has win..");
				hasWinner = true;
				resetBoard();
			}

		}

		if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer) == true) {

			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has win..");
			hasWinner = true;
			resetBoard();

		}

		if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer) == true) {

			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has win..");
			hasWinner = true;
			resetBoard();

		}
		
		
	}
}
