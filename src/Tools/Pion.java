package Tools;

import Interfaces.Cellule;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Pion {
    
    private int x;               // ----- L'abscisse
    private int y;              // ----- L'ordonnée
    private Color color;       // ----- La variable qui prend la color de pion, Il sera soit la couleur blanc ou noir
    public ArrayList<Pion> pions = new ArrayList<Pion>(); 
    
    // ---------- Constructeur ------------
    public Pion(Color color) 
    {
        super();
        this.x = 0;
        this.y = 0;
        this.color = color;
    }
    
    // -------- Getters & Setters -----------
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Pion> getPions() {
        return pions;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPions(ArrayList<Pion> pions) {
        this.pions = pions;
    }
    
    //-------- ToString --------------
    @Override
    public String toString() {
        return "Pion{" + "x=" + x + ", y=" + y + ", color=" + color + '}';
    }
    

    
    //--------- Dessiner X ---------
    public void dessinerX(Graphics2D g)
    {
        g.setColor(color);
        g.setStroke(new BasicStroke(3));
        g.drawLine(x+2, y+2, x+Cellule.TAILLE_CELL-5, y+Cellule.TAILLE_CELL-5);
        g.drawLine(x+Cellule.TAILLE_CELL-5, y+2, x+2, y+Cellule.TAILLE_CELL-5);
    }

    //--------- Dessiner O ---------
    public void dessinerO(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(3));
        g.drawOval(x+2, y+2, Cellule.TAILLE_CELL-5, Cellule.TAILLE_CELL-5);
    }
    
    //------- Supprimer pion ----------
    public void remove(Pion p)
    {
        this.remove(p);
    }


}
