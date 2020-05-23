package pruebaBBDD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;

class MarcoMotos extends JFrame{
	boolean cajaelegida=false, inmovilizadorelegido=false;
	JRadioButton moto1 = new JRadioButton("SuperDink 125i (3350€)");
	JRadioButton moto2 = new JRadioButton("Agility City (2995€)");
	ButtonGroup motos= new ButtonGroup();
	JPanel preciototal= new JPanel();
	JTextField precio= new JTextField(15);
	JLabel euros= new JLabel("€");
	JCheckBox caja = new JCheckBox("Cajon transportin (100€)");
	JCheckBox inmovi= new JCheckBox("Inmovilizador(200€)");
	JPanel extras= new JPanel();
	PanelMotos superior = new PanelMotos();
	JPanel central = new JPanel();
	JPanel mipane= new JPanel();
	public MarcoMotos () {
		setTitle("MOTOS KYMCO AUSMOTOR");
		setVisible(true);
		setBounds(600, 300, 400, 360);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mipane.setLayout(new GridLayout(2,2));
		preciototal.add(precio);
		preciototal.add(euros);
		moto1.addActionListener(new OyenteMotos());
		moto2.addActionListener(new OyenteMotos());
		motos.add(moto1);
		motos.add(moto2);
		central.setLayout(new GridLayout(2,2));
		central.add(moto1);
		central.add(moto2);
		extras.setLayout(new GridLayout(2,1));
		
		caja.addActionListener(new OyenteExtras());
		inmovi.addActionListener(new OyenteExtras());
		
		extras.add(caja);
		extras.add(inmovi);
		
		
		central.add(extras);
		central.add(preciototal);
		
		mipane.add(superior);
		
		mipane.add(central);
		add(mipane);
	}
	private class PanelMotos extends JPanel{
		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			Font rojas = new Font("Cambria", Font.BOLD, 18);
			g2.setFont(rojas);
			g2.setColor((Color.red).brighter());
			g2.drawString("KYMCO Scooters", 120,50);

		}
	}
	private class OyenteMotos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int cantidad= motos.getButtonCount();
			String precio2="";
			int parentesis1,parentesis2;
			System.out.println(cantidad);
			System.out.println(motos.getSelection());
			for (int i=0; i<cantidad; i++){
			System.out.println(motos.getElements().nextElement().getText());
		}System.out.println(motos.getElements());
		///it.next();
			System.out.println(motos.getElements().nextElement().getText());
			if(moto1.isSelected()) {
				 parentesis1= moto1.getText().indexOf("(");
				 parentesis2= moto1.getText().indexOf("€");
				System.out.println(parentesis1+ " es la posicion del primer parentisiss");
				 precio2 = moto1.getText().substring(parentesis1+1, parentesis2);
				System.out.println("Has elegido la moto 1");
				System.out.println(precio2+ " es el precio");
				Double totalE= Double.valueOf(precio2);
				
				
			}if(moto2.isSelected()) {
				parentesis1= moto2.getText().indexOf("(");
				 parentesis2= moto2.getText().indexOf("€");
				 precio2 = moto2.getText().substring(parentesis1+1, parentesis2);
			}
			precio.setText(precio2);
		}
		
	}
	private class OyenteExtras implements ActionListener{
		int parentesis1,parentesis2;
		Double totalE,añade;
		int interruptor=0;
		@Override
		public void actionPerformed(ActionEvent e) {
			 totalE= Double.valueOf(precio.getText());
			System.out.println("elegida o no la caja "+caja.isSelected());
			System.out.println("elegido o no el inmovilizador: "+ inmovi.isSelected());
			
			if (caja.isSelected() && cajaelegida==false) {
				parentesis1= caja.getText().indexOf("(");
				parentesis2= caja.getText().indexOf("€");
				interruptor=0;
				cajaelegida=true;
				añade= Double.valueOf(caja.getText().substring(parentesis1+1, parentesis2));
				
				totalE+=añade;
				
			}
			if(!caja.isSelected() && cajaelegida) {
				parentesis1= caja.getText().indexOf("(");
				parentesis2= caja.getText().indexOf("€");
				interruptor=1;
				cajaelegida=false;
				añade= Double.valueOf(caja.getText().substring(parentesis1+1, parentesis2));
				totalE-=añade;
			}
			if (inmovi.isSelected() && !inmovilizadorelegido ) {
				parentesis1= inmovi.getText().indexOf("(");
				parentesis2= inmovi.getText().indexOf("€");
				interruptor=2;
				inmovilizadorelegido=true;
				añade= Double.valueOf(inmovi.getText().substring(parentesis1+1, parentesis2));
				totalE+=añade;
				
			}
			if (!inmovi.isSelected() && inmovilizadorelegido) {
				parentesis1= inmovi.getText().indexOf("(");
				parentesis2= inmovi.getText().indexOf("€");
				interruptor=3;
				inmovilizadorelegido=false;
				añade= Double.valueOf(inmovi.getText().substring(parentesis1+1, parentesis2));
				totalE-=añade;
			}
			precio.setText(String.valueOf(totalE));
//			switch (interruptor%2) {
//			case 0: 	if(inmovilizadorelegido && cajaelegida) {
//						//sumar el precio de las dos cosas
//						}
//					break;
//			}
//			 if(caja.isSelected()) {
//				
//				System.out.println(totalE +  " precio sin añadir la caja");
//				 parentesis1= caja.getText().indexOf("(");
//				 parentesis2= caja.getText().indexOf("€");
//				  añade= Double.valueOf(caja.getText().substring(parentesis1+1, parentesis2));
//				  System.out.println(añade+ " lo que añadimos");
//				totalE+=añade;
//				//precio.setText(String.valueOf(totalE));
//				cajaelegida=true;
//				interruptor=1;
//				
//			 System.out.println("el precio con caja elegida es "+ totalE);
//			} 
////			 if (!caja.isSelected()) {
////				Double totalE= Double.valueOf(precio.getText());
////				 parentesis1= caja.getText().indexOf("(");
////				 parentesis2= caja.getText().indexOf("€");
////				 Double añade= Double.valueOf(caja.getText().substring(parentesis1+1, parentesis2));
////				 totalE-=añade;
////				 cajaelegida=false;
////				 interruptor=2;
////				// precio.setText(String.valueOf(totalE));
////			}
////			 
////			if(cajaelegida && interruptor!=2) {
////				Double totalE= Double.valueOf(precio.getText());
////				 parentesis1= caja.getText().indexOf("(");
////				 parentesis2= caja.getText().indexOf("€");
////				 Double añade= Double.valueOf(caja.getText().substring(parentesis1+1, parentesis2));
////				 totalE-=añade;
////				 cajaelegida=false;
////				 interruptor=2;
////				// precio.setText(String.valueOf(totalE));
////				 System.out.println(totalE);
////			}
////			
//		
		}
		
	}
}
