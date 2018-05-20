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

public class Interfaz extends JFrame {
	private JTextField ValorN;
	private JOptionPane msg;
	private JTextField NombreVar;
	
	Operador o=new Operador();
	private JTextField operacion;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public Interfaz() {
		getContentPane().setLayout(null);
		
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
		
		msg=new JOptionPane();
		JLabel Variables = new JLabel("");
		List list = new List();
		list.setVisible(false);
		
		JButton btnGuardar = new JButton("Guardar");
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
		btnGuardar.setBounds(290, 74, 89, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnVerVariables = new JButton("Ver variables");
		btnVerVariables.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				list.setVisible(true);
				if(o.estaVacio())
					list.add("No hay elementos");
				else {
					for(String st:o.toS())
						list.add(st);
				}
			}
		});
		btnVerVariables.setBounds(278, 146, 108, 23);
		getContentPane().add(btnVerVariables);
		
		list.setBounds(10, 139, 110, 60);
		getContentPane().add(list);
		
		JLabel lblIngresarOperacion = new JLabel("Ingresar operacion");
		lblIngresarOperacion.setBounds(37, 215, 110, 14);
		getContentPane().add(lblIngresarOperacion);
		
		operacion = new JTextField();
		int resultado;
		operacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String oper=operacion.getText();
				o.validarOp(oper);
				}
			}
			
		});
		
		operacion.setBounds(167, 212, 108, 20);
		getContentPane().add(operacion);
		operacion.setColumns(10);
		
		
	
	}
}
