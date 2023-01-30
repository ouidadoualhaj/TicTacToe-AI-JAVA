package Interfaces;

import Tools.ConnectionManager;
import Tools.TicTacToePosition;
import Tools.Outils;
import Tools.PlayTicTacToe;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Home extends javax.swing.JFrame {
    
    
    // Les �l�ments de connection � la base de donn�es 
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public static int idUser = 0;      //-----id du joeur
    public static int idPartie = 0;    //-----id d'une partie d'un joueur
    public static BoardPanel board;     //---- le plateau de TicTacToe
    
    //------- Getters & Setters -----------
    public BoardPanel getBoard()
    {
        return this.board;
    }
    
    public void setBoard(BoardPanel board) {
        this.board = board;
    }
    
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
       
    
    //------- Constructeur -----------
    public Home() throws SQLException, ClassNotFoundException {
        initComponents();
        
        Outils.gameOver = false;
        noirTxt.setEditable(false);
        blancTxt.setEditable(false);
        playPositionBtn.setEnabled(false);
        
        //------- Se connecter � la BDD
        connection = ConnectionManager.getConnection();
        
        //------- Creer un nouveau plateau 
        board = new BoardPanel();
        board.setBounds(0, 0, BoardPanel.TAILLE_BOARD, BoardPanel.TAILLE_BOARD);
        boardPane.add(board);
        boardPane.repaint();
        
        /***********************************************************************
         * La requete de selection l'id et l'etat d'une partie, un etat signifie
         * si la partie est termin�e ou non
         * ********************************************************************/
        String qry = "select idPosition, etatPosition from position where idUser = ?";
        this.ps = this.connection.prepareStatement(qry);
        this.ps.setInt(1, this.idUser);
        this.rs = this.ps.executeQuery();
        
        while(this.rs.next())
        {
            this.positionUserCB.addItem(String.valueOf(this.rs.getInt(1)) + "  " + String.valueOf(this.rs.getInt(2) == 0 ? "Non" : "Oui"));
        }
        
        if(this.positionUserCB.getItemCount() != 0)
            playPositionBtn.setEnabled(true);
        else
            playPositionBtn.setEnabled(false);
         //----- Centrer la fenetre 
        Dimension screenSize,frameSize;
        int x,y;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize=getSize();
        x=(screenSize.width-frameSize.width)/2;
        y=(screenSize.height-frameSize.height)/2;
        setLocation(x, y);
        
        //------ mettre la fenetre non Resizable
        this.setResizable(false);
        
        //------ Icon de frame
        Image icon = Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/o3.png"));  
        this.setIconImage(icon); 
        
        //------ Titre de frame
        this.setTitle("TicTacToe");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        boardPane = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        depthCB = new javax.swing.JComboBox<>();
        deconnexionBtn = new javax.swing.JButton();
        positionUserCB = new javax.swing.JComboBox<>();
        playPositionBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        //hommeMachineCB = new javax.swing.JComboBox<>();
        playNewBtn = new javax.swing.JButton();
        noirTxt = new javax.swing.JTextField();
        blancTxt = new javax.swing.JTextField();
        blancLbl = new javax.swing.JLabel();
        noirLbl = new javax.swing.JLabel();
        //timerLbl = new javax.swing.JLabel();
        //second = new javax.swing.JLabel();
        //millisecond = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        resultValueLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        resultValueLbl1 = new javax.swing.JLabel();
        //undoBtn = new javax.swing.JButton();
        noirLbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(20, 144, 241));

        contentPane.setBackground(new java.awt.Color(174, 214, 241));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boardPane.setBackground(new java.awt.Color(20, 144, 241));
        boardPane.setForeground(new java.awt.Color(20, 144, 241));
        boardPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boardPane.setMinimumSize(new java.awt.Dimension(400, 400));
        boardPane.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout boardPaneLayout = new javax.swing.GroupLayout(boardPane);
        boardPane.setLayout(boardPaneLayout);
        boardPaneLayout.setHorizontalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        boardPaneLayout.setVerticalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        contentPane.add(boardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 6, -1, -1));

        exit.setBackground(new java.awt.Color(20, 144, 241));
        exit.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 0, 0));
        exit.setText("Quitter");
        exit.setToolTipText("");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        contentPane.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 162, -1));
        deconnexionBtn.setBackground(new java.awt.Color(20, 144, 241));
        deconnexionBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        deconnexionBtn.setForeground(new java.awt.Color(0, 0, 0));
        deconnexionBtn.setText("Se deconnecter");
        deconnexionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionBtnActionPerformed(evt);
            }
        });
        
        contentPane.add(deconnexionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 162, 30));

        contentPane.add(positionUserCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 123, 27));

        playPositionBtn.setBackground(new java.awt.Color(20, 144, 241));
        playPositionBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        playPositionBtn.setForeground(new java.awt.Color(0, 0, 0));
        playPositionBtn.setText("Jouer Ancienne partie");
        playPositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPositionBtnActionPerformed(evt);
            }
        });
       contentPane.add(playPositionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 77, -1));

        saveBtn.setBackground(new java.awt.Color(20, 144, 241));
        saveBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(0, 0, 0));
        saveBtn.setText("Enregistrer");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        contentPane.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 164, 30));

        playNewBtn.setBackground(new java.awt.Color(20, 144, 241));
        playNewBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        playNewBtn.setForeground(new java.awt.Color(0, 0, 0));
        playNewBtn.setText("Nouvelle partie");
        playNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playNewBtnActionPerformed(evt);
            }
        });
        contentPane.add(playNewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 164, 30));


        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setText("R�sultat :");
        contentPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        resultValueLbl.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        contentPane.add(resultValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 424, 131, -1));

        resultValueLbl1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        contentPane.add(resultValueLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //------ Methode Play() -------
    private void play() {      
        new Thread(new PlayTicTacToe()).start();
    }
    
    //-------- Button :  Quitter --------
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        setDefaultCloseOperation(Home.DISPOSE_ON_CLOSE);
        setVisible(false);  
    }
    
    //-------- Button : Se deconnecter ---------
    private void deconnexionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "voullez-vous vraiment quitter ?");
        if (a == JOptionPane.YES_OPTION) {
            this.idUser = 0;
            dispose();
            try {
                Authentification auth = new Authentification();
                auth.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
     //--------- Button : jouer une ancienne partie ----------
    private void playPositionBtnActionPerformed(java.awt.event.ActionEvent evt) {

        resultValueLbl1.setText("en cours de jeu...");
        saveBtn.setEnabled(true);
        
        try {
            String pos = this.positionUserCB.getSelectedItem().toString();
            int idPosition = Integer.parseInt(pos.split(" ")[0]);
            idPartie = idPosition;

            String br = "";
            String qry = "select board from position where idPosition = ?";
            this.ps = this.connection.prepareStatement(qry);
            ps.setInt(1, idPosition);
            this.rs = this.ps.executeQuery();
            while(this.rs.next())
            {
                br = this.rs.getString(1);
                break;
            }
            int k=0;
            int [] brd = new int[9];
            for(int i = 0; i < 9; i++)
            {
                brd[i] = Integer.parseInt(br.split(" ")[i]);
            }

            TicTacToePosition p = new TicTacToePosition();
            p.setBoard(brd);
            Outils.position = p;

            play();
               
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    //----------- Button : Enregistrer --------
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        TicTacToePosition pos = (TicTacToePosition) Outils.position;
        String br = "";
        int etat = 0;
        for(int i = 0; i < 9; i++)
            br = br + pos.getBoard()[i] + " ";
        
        etat = pos.etat() ? 1 : 0;
        
        //------- Enregister la partie s'elle est nouvelle
        if(idPartie == 0)
        {
            try {
                String qry = "insert into position (board, etatPosition, idUser) values (?, ?, ?)";
                this.ps = this.connection.prepareStatement(qry);
                this.ps.setString(1, br);
                this.ps.setInt(2, etat);
                this.ps.setInt(3, this.idUser);
                this.ps.execute();
                
                JOptionPane.showMessageDialog(this, "Enregistr�", "Bien enregistr�e !", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //------ Modifier la partie si elle est ancienne
        else
        {
            try {
                String qry = "update position set board = ?, etatPosition = ? where idPosition = ?";
                this.ps = this.connection.prepareStatement(qry);
                this.ps.setString(1, br);
                this.ps.setInt(2, etat);
                this.ps.setInt(3, idPartie);
                this.ps.execute();

                JOptionPane.showMessageDialog(this, "Modifi�", "Bien modifi� !", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //------- Rafrachir la ComboBox des parties de l'utilisateur
        this.positionUserCB.removeAllItems();
        try {
            String req = "select idPosition, etatPosition from position where idUser = ?";
            this.ps = this.connection.prepareStatement(req);
            this.ps.setInt(1, idUser);
            this.rs = this.ps.executeQuery();
            while(this.rs.next())
            {
                this.positionUserCB.addItem(String.valueOf(this.rs.getInt(1)) + "  " + String.valueOf(this.rs.getInt(2) == 0 ? "Non" : "Oui"));
            }
            if(this.positionUserCB.getItemCount() != 0)
                playPositionBtn.setEnabled(true);
            else
                playPositionBtn.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    //----------- Button : Nouvelle partie --------
    private void playNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playNewBtnActionPerformed
        idPartie = 0;
        Outils.gameOver = false;
        resultValueLbl1.setText("en cours de jeu...");
        saveBtn.setEnabled(true);
        int indexDepth = this.depthCB.getSelectedIndex();
        switch(indexDepth) {
            case 0: // Facile
                Outils.depth = 0;
                break;
            case 1: // Moyen
                Outils.depth = 5;
                break;
            case 2: // Difficile
                Outils.depth = 8;
                break;
        }
        
        TicTacToePosition p = new TicTacToePosition();
        Outils.position = p;

        play();
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blancLbl;
    public static javax.swing.JTextField blancTxt;
    private javax.swing.JPanel boardPane;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton deconnexionBtn;
    private javax.swing.JComboBox<String> depthCB;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel noirLbl;
    private javax.swing.JLabel noirLbl1;
    public static javax.swing.JTextField noirTxt;
    private javax.swing.JButton playNewBtn;
    private javax.swing.JButton playPositionBtn;
    private javax.swing.JComboBox<String> positionUserCB;
    private javax.swing.JLabel resultValueLbl;
    public static javax.swing.JLabel resultValueLbl1;
    public static javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
