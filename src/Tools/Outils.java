package Tools;

public class Outils {

	public static boolean isClicked = false; //---- un boolean qui retourne true 
                                             //si le joueur clique sur le board pour dessiner un pion       
	public static int moveIndex = 0;       //----- la position de pion à dessiner
	public static Position position;
	public static int depth = 0;           //----- la profendeur
	public static boolean gameOver = false;   //----- Si la partie est terminée , on va retourner True
	public static TicTacToePosition lastPosition = new TicTacToePosition();
}
