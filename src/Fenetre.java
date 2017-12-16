import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Fenetre extends JFrame{
	private JPanel accueil = new JPanel();
	private JPanel page1 = new JPanel();
	private JLabel label = new JLabel("SCRABBLE");
	private JButton b = new JButton ("Jouer");
	
	public Fenetre(){
		
		this.setTitle("Scrabble");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(null);

		accueil.setLayout(null);
		accueil.setBackground(Color.white);
		
		Font police = new Font("Arial", Font.BOLD, 22);
		label.setFont(police);
		label.setForeground(Color.ORANGE);
		label.setBounds(this.getWidth()/2-75, this.getHeight()/2-105, 200, 75);
		
	    b.addActionListener(new BoutonListener());
	    b.setForeground(Color.blue);
	    b.setBackground(Color.orange);
	    b.setBounds(this.getWidth()/2-75, this.getHeight()/4*3, 100, 60);
	    
	    accueil.add(b);
	    accueil.add(label);
	    this.setContentPane(accueil);
	    
	    
	    
	    
	}
	
	
	public void changerMenu(){
		this.setContentPane(this.page1);
		this.revalidate();
		this.repaint();
	}
	
	class Page extends JPanel {
		
		
		@Override
		public void paintComponent(Graphics g){
			System.out.println("Dans paint componenent");
			
			//Colonnes
			g.drawLine(this.getWidth()/15,0,this.getWidth()/15,this.getHeight());
			g.drawLine(this.getWidth()/15*2,0,this.getWidth()/15*2,this.getHeight());
			g.drawLine(this.getWidth()/15*3,0,this.getWidth()/15*3,this.getHeight());
			g.drawLine(this.getWidth()/15*4,0,this.getWidth()/15*4,this.getHeight());
			g.drawLine(this.getWidth()/15*5,0,this.getWidth()/15*5,this.getHeight());
			g.drawLine(this.getWidth()/15*6,0,this.getWidth()/15*6,this.getHeight());
			g.drawLine(this.getWidth()/15*7,0,this.getWidth()/15*7,this.getHeight());
			g.drawLine(this.getWidth()/15*8,0,this.getWidth()/15*8,this.getHeight());
			g.drawLine(this.getWidth()/15*9,0,this.getWidth()/15*9,this.getHeight());
			g.drawLine(this.getWidth()/15*10,0,this.getWidth()/15*10,this.getHeight());
			g.drawLine(this.getWidth()/15*11,0,this.getWidth()/15*11,this.getHeight());
			g.drawLine(this.getWidth()/15*12,0,this.getWidth()/15*12,this.getHeight());
			g.drawLine(this.getWidth()/15*13,0,this.getWidth()/15*13,this.getHeight());
			
			//Lignes
			g.drawLine(0, this.getHeight()/15, this.getWidth(), this.getHeight()/15);
			g.drawLine(0, this.getHeight()/15*2, this.getWidth(), this.getHeight()/15*2);
			g.drawLine(0, this.getHeight()/15*3, this.getWidth(), this.getHeight()/15*3);
			g.drawLine(0, this.getHeight()/15*4, this.getWidth(), this.getHeight()/15*4);
			g.drawLine(0, this.getHeight()/15*5, this.getWidth(), this.getHeight()/15*5);
			g.drawLine(0, this.getHeight()/15*6, this.getWidth(), this.getHeight()/15*6);
			g.drawLine(0, this.getHeight()/15*7, this.getWidth(), this.getHeight()/15*7);
			g.drawLine(0, this.getHeight()/15*8, this.getWidth(), this.getHeight()/15*8);
			g.drawLine(0, this.getHeight()/15*9, this.getWidth(), this.getHeight()/15*9);
			g.drawLine(0, this.getHeight()/15*10, this.getWidth(), this.getHeight()/15*10);
			g.drawLine(0, this.getHeight()/15*11, this.getWidth(), this.getHeight()/15*11);
			g.drawLine(0, this.getHeight()/15*12, this.getWidth(), this.getHeight()/15*12);
			g.drawLine(0, this.getHeight()/15*13, this.getWidth(), this.getHeight()/15*13);
			g.drawLine(0, this.getHeight()/15*14, this.getWidth(), this.getHeight()/15*14);
			
			page1.paint(g); 
			
		}
		
		
	}
	
	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Fenetre.this.changerMenu();
		}
		
	}
}
