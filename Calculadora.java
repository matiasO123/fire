import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco marco = new Marco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}




class Marco extends JFrame{
	public Marco() {
		setVisible(true);
		setBounds(150,150,300,300);
		Lamina lamina = new Lamina();
		add(lamina);
		//Esta instrucción le dice al marco que se adapta al tamaño de lo que tiene adentro
		pack();
		setTitle("Calculadora");
	}
}




class Lamina extends JPanel{

	public Lamina() {
		setLayout(new BorderLayout(5,5));
	
		add(pantalla, BorderLayout.NORTH);
		pantalla.setEnabled(false);
		lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(4,4,5,5));
		/*JButton boton1 = new JButton("1");
		lamina2.add(boton1);
		JButton boton2 = new JButton("2");
		lamina2.add(boton2);
		JButton boton3 = new JButton("3");
		lamina2.add(boton3);
		JButton boton4 = new JButton("4");
		lamina2.add(boton4);
		JButton boton5 = new JButton("5");
		lamina2.add(boton5);
		JButton boton6 = new JButton("6");
		lamina2.add(boton6);
		JButton boton7 = new JButton("7");
		lamina2.add(boton7);
		JButton boton8 = new JButton("8");
		lamina2.add(boton8);
		JButton boton9 = new JButton("9");
		lamina2.add(boton9);
		JButton botonMas = new JButton("+");
		lamina2.add(botonMas);
		JButton botonEqual = new JButton("=");
		lamina2.add(botonEqual);*/
		ActionListener insertar = new insertar();
		ActionListener accion = new accion();
		ponerBoton("7",insertar);
		ponerBoton("8",insertar);
		ponerBoton("9",insertar);
		ponerBoton("/",accion);
		ponerBoton("4",insertar);
		ponerBoton("5",insertar);
		ponerBoton("6",insertar);
		ponerBoton("*",accion);
		ponerBoton("1",insertar);
		ponerBoton("2",insertar);
		ponerBoton("3",insertar);
		ponerBoton("-",accion);
		ponerBoton("0",insertar);
		ponerBoton(".",insertar);
		ponerBoton("=",accion);
		ponerBoton("+",accion);
		ultimaOperacion="=";
		add(lamina2, BorderLayout.CENTER);
	}
	//Agrega los botones con su oyente
	private void ponerBoton(String rotulo, ActionListener oyente) {
		JButton boton = new JButton(rotulo);
		lamina2.add(boton);
		boton.addActionListener(oyente);
		
	}
	//Muestra el número clickeado en la pantalla 
	private class insertar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String entrada = e.getActionCommand();
			//Esto es para concatenar una sucesión de números ingresados
			if(principio) {
				pantalla.setText("");
				principio=false;
			}
			pantalla.setText(pantalla.getText() + entrada);
			
		}
		
	}
	
	//Guarda los valores ingresados en variables
	private class accion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			principio = true;
			
			String operador = e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion = operador;
				
			}
		
		//Acá se hacen los cálculos
		public void calcular (double x) {
			if(ultimaOperacion.equals("+")) {
				resultado += x;
				
				
			} else if(ultimaOperacion.equals("-")) {
				resultado -= x;}
			else if(ultimaOperacion.equals("=")) {
				resultado=x;
			}
			pantalla.setText(""+resultado);;
		}
		
		
	}
	
	
	
	Boolean principio = new Boolean(true);
	 JPanel lamina2;
	JButton pantalla = new JButton("0");
	String ultimaOperacion;
	Double resultado= new Double(0);
}
