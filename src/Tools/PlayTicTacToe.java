package Tools;

import Traitement.TicTacToe;

public class PlayTicTacToe implements Runnable {

	@Override
	public void run() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playGame(Outils.position, true);
	}

}
