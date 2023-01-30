package Tools;

public class TicTacToePosition extends Position{

	final static public int BLANK = 0;      //----- une case vide prend la valeur 0
    final static public int HUMAN = 1;      //----- la valeur remplie par le joueur prend la valeur 1
    final static public int PROGRAM = -1;   //----- la valeur remplie par l'adversaire prend la valeur -1
    public int [] board = new int[9];      //----- Le plateau de 64 cases (8x8)
    
    //---------- Constructeur --------------
    public TicTacToePosition() {
        
        
        //----- Si une case n'est pas remplie par 1 ou -1, il va etre vide => 0
        for(int i = 0 ; i < 9; i ++)
        {
            if(board[i] != -1 && board[i] != 1)
                board[i] = 0;
        }
    }
    
    //---------- Getters & Setters --------------
    public int[] getBoard() {
        return this.board;
    }
    
    public void setBoard(int[] board) {
        this.board = board;
    }
    
    
    //----- un boolean qui decrit l'etat d'une partie jouée, 
    //----- s'il est terminer etat =1, sinon etat = 0
    public boolean etat() {
        for(int i = 0; i < 9; i++)
            if(this.board[i] == 0)
                return false;
        return true;
    }
    
    //---------- toString()-----------------
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i=0; i<9; i++) {
            sb.append(""+board[i]+",");
        }
        sb.append("]");
        return sb.toString();
    }
}
