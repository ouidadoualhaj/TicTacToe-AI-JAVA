package Interfaces;

import Tools.Outils;
import Tools.Pion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

public class Cellule extends javax.swing.JPanel implements MouseMotionListener, MouseListener {
    
    public static int TAILLE_CELL = 134;    //La taille de cellule                  
    private int id =0;                      //id de cellule  
    private Pion pionx;  
    private Pion piono;                   

    
    //-------- Constructeur -------------
    public Cellule(int id) {
        initComponents();
        this.id = id;
    }
    
    
    //-------- Getter & Setter ----------
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setBackground(new java.awt.Color(20, 144, 241));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 238, 248)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //------- Dessiner X ------------
    public void drawX(Color color) {
        pionx = new Pion(color);
        this.repaint();
    }
    
    //------- Dessiner O ------------
    public void drawO(Color color) {
        piono = new Pion(color);
        this.repaint();
    }
    
    //--------eraseCellule--------
    public void eraseCellule() {
        pionx = null;
        piono = null;
        this.repaint();
    }
    
    //-------- paint ----------
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        if(pionx != null)
           pionx.dessinerX((Graphics2D) g);
        if(piono != null)
            piono.dessinerO((Graphics2D) g);
        else
        {
            //Pion epion = new Pion(new Color(215, 189, 226));
            //epion.dessinerO((Graphics2D) g);
        }
    }
    

    @Override
  public void mouseClicked(MouseEvent e) {
        
        if(pionx != null)
        {
            JOptionPane.showMessageDialog(this, "Il y a un pion déjà !");
            System.out.println("Il y a un pion déjà !");
        }
        if(piono != null)
        {
            JOptionPane.showMessageDialog(this, "Il y a un pion déjà !");
            System.out.println("Il y a un pion déjà !");
        }
        else
        {
        	pionx = new Pion(Color.black);
            int x = e.getComponent().getY()/50;
            int y = e.getComponent().getX()/50;
            int tmp;
            int k = 0;
            for(int i = 0; i < 9; i++)
            {   if(x == i)
                    {
                        Outils.isClicked = true;
                        Outils.moveIndex = this.getId();
                        
                        break;
                    }
                    k++;
                
            }
            this.repaint();
               
        }   
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}