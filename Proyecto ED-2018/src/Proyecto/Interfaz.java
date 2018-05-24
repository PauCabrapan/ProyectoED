package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

/**
 * Clase Interfaz que representa la interfaz grafica del programa.
 * @author Cabrapan Paula y Cabrapan Diego.
 *
 */
public class Interfaz extends JFrame {
	private JTextField ValorN;
	private JOptionPane msg;
	private JTextField NombreVar;
	
	Operador o=new Operador();
	private JTextField operacion;

	/**
	 * Ejecuta la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 */
	public Interfaz() {
		getContentPane().setLayout(null);
		//Componentes y sus propiedades
		NombreVar = new JTextField();
		NombreVar.setBounds(165, 50, 86, 20);
		getContentPane().add(NombreVar);
		NombreVar.setColumns(10);
		
		ValorN = new JTextField(new Integer(3));
		ValorN.setBounds(165, 91, 86, 20);
		getContentPane().add(ValorN);
		ValorN.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la variable");
		lblNombreDeLa.setBounds(26, 41, 121, 38);
		getContentPane().add(lblNombreDeLa);
		
		JLabel lblValorNumerico = new JLabel("Valor numerico");
		lblValorNumerico.setBounds(36, 94, 70, 14);
		getContentPane().add(lblValorNumerico);
				
		JLabel lblIngresarOperacion = new JLabel("Ingresar operacion");
		lblIngresarOperacion.setBounds(37, 215, 110, 14);
		getContentPane().add(lblIngresarOperacion);
		
		msg=new JOptionPane();
		JLabel Variables = new JLabel("");
		
		List listVar = new List();
		listVar.setVisible(false);
		listVar.setBounds(10, 139, 110, 60);
		getContentPane().add(listVar);
		
		List LInfo = new List();
		LInfo.setBounds(283, 153, 110, 82);
		getContentPane().add(LInfo);
		listVar.setVisible(false);		
		
		//Boton Guardar variable y su oyente
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(290, 74, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isNumeric(ValorN.getText())) {
					o.ingresar(NombreVar.getText(),Integer.parseInt(ValorN.getText()) );
					msg.showMessageDialog(null,"Guardado");
					ValorN.setText("");
					NombreVar.setText("");
					NombreVar.setFocusable(true);
				}
				else {
						msg.showMessageDialog(null, "Debe ser numerico el valor");
						ValorN.setText("");
						ValorN.setFocusable(true);
				}	
			}
			private boolean isNumeric(String s) {
				boolean es=true;
		        try {
		            Integer.parseInt(s);
		        } catch (NumberFormatException excepcion) {
		            es= false;
		        }
		        return es;
			}
		});
		
		//Boton ver variables y su oyente
		JButton btnVerVariables = new JButton("Ver variables");
		btnVerVariables.setBounds(10, 119, 110, 23);
		getContentPane().add(btnVerVariables);
		btnVerVariables.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				listVar.setVisible(true);
				if(o.estaVacio())
					listVar.add("No hay elementos");
				else {
					for(String st:o.toS())
						listVar.add(st);
				}
			}
		});
		
		//Boton para mostrar info del arbol y su oyente.
		JButton btnMostrarInformacionDel = new JButton("Mostrar informacion del arbol");
		btnMostrarInformacionDel.setBounds(238, 119, 186, 23);
		getContentPane().add(btnMostrarInformacionDel);
		btnMostrarInformacionDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LInfo.setVisible(true);
				LInfo.add(o.altura());
				LInfo.add(o.hojas());
				LInfo.add(o.internos());
				LInfo.add(o.nodos());
				
			}
		});
	
	}
}
