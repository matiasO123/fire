import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

public class Practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco17 marco17 = new Marco17();
		marco17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}




class Marco17 extends JFrame{
	public Marco17() {
		setBounds(100,100,300,300);
		Lamina17 lamina17 = new Lamina17();
		add(lamina17);
		setVisible(true);
	}
}






class Lamina17 extends JPanel{
	JTextPane miarea = new JTextPane();
	JMenu fuente, estilo, tamanio;
	Font letras;
	JCheckBoxMenuItem rojo = new JCheckBoxMenuItem("Rojo");
	public Lamina17() {
		//CREACIÓN DE ELEMENTOS DE MENU
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		JMenuBar menu = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamanio = new JMenu("Tamaño");
		creacionMenu("Arial",fuente,"Arial",9,10);
		creacionMenu("Verdana",fuente,"Verdana",9,10);
		creacionMenu("Courier",fuente,"Courier",9,10);
		creacionMenu("8",tamanio,"",9,8);
		creacionMenu("10",tamanio,"",9,10);
		creacionMenu("12",tamanio,"",9,12);
		creacionMenu("15",tamanio,"",9,15);
		creacionMenu("20",tamanio,"",9,20);
		creacionMenu("Negrita",estilo,"",Font.BOLD,10);
		creacionMenu("Cursiva",estilo,"",Font.ITALIC,10);
		JToolBar toolbar = new JToolBar();
		JButton botonFondoCeleste = new JButton("FondoCel");
		JButton botonCerrar = new JButton("Cerrar");
		JButton botonSubrayar = new JButton("subrayar");
		JButton botonColorVerde = new JButton(new ImageIcon("src/verde.gif"));
		botonSubrayar.addActionListener(new StyledEditorKit.UnderlineAction());
		botonColorVerde.addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.green));
		toolbar.setOrientation(1);
		toolbar.add(botonFondoCeleste);
		toolbar.add(botonColorVerde);
		toolbar.add(botonSubrayar);
		toolbar.addSeparator();
		toolbar.add(botonCerrar);
		add(toolbar,BorderLayout.WEST);
		botonFondoCeleste.addActionListener(new ColorFondo());
		botonCerrar.addActionListener(new Cerrar());
		
		
		ActionListener oyente = new Colour();
		//JUGANDO CON CHECKBOX Y RADIOBUTTON EN LOS MENUES
		
		estilo.add(rojo);
		rojo.addActionListener(new Colour());
		


		
		
		//Agregando los menues y la lámina y demás
		menu.add(fuente);
		menu.add(estilo);
		menu.add(tamanio);
		laminaMenu.add(menu);
		add(laminaMenu, BorderLayout.NORTH);
		add(miarea, BorderLayout.CENTER);
	}
	
	
	
	//METODOS
	private class Colour implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (rojo.isSelected()==true) {
			miarea.setForeground(Color.RED);
		}else{
			miarea.setForeground(Color.black);}
		}
		
	}
	
	private class ColorFondo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		Color color;
		color=miarea.getBackground();
		if (color==Color.white) {
			miarea.setBackground(Color.CYAN);
		}else {
			miarea.setBackground(Color.white);
		}
		}
		
	}
	
	private class Cerrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}


	public void creacionMenu (String rotulo, JMenu menuF, String tipo, int estiloF, int tamanioF) {
		JMenuItem elemMenu = new JMenuItem(rotulo);
		menuF.add(elemMenu);
		
		elemMenu.addActionListener(new GestionaMenues(menuF, tipo, estiloF, tamanioF));
		elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia_tam", tamanioF));
	}
	
	private class GestionaMenues implements ActionListener{
		String texto;
		String menu;
		JMenu menuR;
		int estiloPrivate, tamanioPrivate;

		
		//Método construcutor de los eventos, porque necesito pasar parámetros...
		GestionaMenues(JMenu menuF, String texto2, int estilo2, int tamanio2){
			texto=texto2;
			estiloPrivate=estilo2;
			tamanioPrivate=tamanio2;
			menu=menuF.getText();
			menuR = menuF;
			
			
			
		}
		
		
		
		
		
		
		public void actionPerformed(ActionEvent e) {
			letras=miarea.getFont();
			System.out.println(menu);
			
			if(menu=="Fuente") {
				tamanioPrivate=letras.getSize();
				estiloPrivate=letras.getStyle();
				
			}else if(menu=="Estilo") {
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estiloPrivate=3;
				}
				tamanioPrivate=letras.getSize();
				texto=letras.getFontName();
				
			}else if(menu=="Tamanio") {
				texto=letras.getFontName();
				estiloPrivate=letras.getStyle();
				
			}
			
			miarea.setFont(new Font(texto,estiloPrivate,tamanioPrivate));
			
			
		}
		
	}
}