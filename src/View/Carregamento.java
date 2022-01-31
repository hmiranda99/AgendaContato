package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Carregamento extends JFrame {
	private JPanel contentPane;
	public JProgressBar barra;
	public JLabel texto;
	public JLabel percent ;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carregamento frame = new Carregamento();
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
	public Carregamento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Carregamento.class.getResource("/imgs/molieres.png")));
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setTitle("Tela de Carregamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 529, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		percent = new JLabel("New label");
		percent.setFont(new Font("Tahoma", Font.BOLD, 18));
		percent.setForeground(new Color(0, 0, 0));
		percent.setBounds(448, 34, 60, 30);
		panel.add(percent);
		
		texto = new JLabel("Carregando");
		texto.setFont(new Font("Tahoma", Font.BOLD, 18));
		texto.setForeground(new Color(0, 0, 0));
		texto.setBounds(10, 34, 353, 30);
		panel.add(texto);
		
		barra = new JProgressBar();
		barra.setForeground(new Color(255, 182, 193));
		barra.setBounds(10, 11, 498, 24);
		panel.add(barra);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Carregamento.class.getResource("/imgs/agenda2.gif")));
		lblNewLabel.setBounds(35, 46, 460, 460);
		panel.add(lblNewLabel);
		
		new Thread(new carregar()).start();
	
	}
		//implementar a Thread //
		//criar o metodo para percorrer de 0 ï¿½ 100//
	
		public class carregar implements Runnable{
		//metodo para percorrer a barra de progresso//
		public void run (){
			//laï¿½o de repetiï¿½ï¿½o para percorrer progresso//
			for ( int i =0 ; i < 101 ; i ++ ){
				/*tratamento de erro chamado try--cath--
				para o caso da barra nï¿½o inicializar*/
				try {
					/* Mï¿½todo Sleep em milisegundosï¿½ Tempo de Vida da Thread */
					Thread.sleep(40) ;
					/* Chamar a progressive Bar e adicionar o contador para
					* ir de 1 atï¿½ 100. ( variavel do contador) */
					 barra.setValue( i ) ;
					 if (barra.getValue() <= 50 ){
					 /* Setar Mensagem do JLABEL de acordo com progressive Bar */
					 texto.setText("Carregando informações...");
					 percent.setText(i + "%");
					 } else if (barra.getValue() <= 80 ) {
						 /* Setar Mensagem do JLABEL de acordo com progressive Bar */
						 texto.setText("Carregando telas...");
						 percent.setText(i + "%");
					}else if (barra.getValue() <= 90 ){
						/* Setar Mensagem do JLABEL de acordo com progressive Bar */
						texto.setText("Carregando contatos...");
						percent.setText(i + "%");
					} else {
						/* Setar Mensagem do JLABEL de acordo com progressive Bar */
						texto.setText("Bem-vindo de volta...");
						percent.setText(i + "%");
					}
					//cath -- Tratamento de erro//
				} catch (Exception erro) {
				 JOptionPane.showMessageDialog(null,erro);
				} 
			}			
			//chamar proxima tela apos as 2 chaves do catch//
			FormCadastro tela= new FormCadastro();//constroi a tela//
			Carregamento.this.dispose();//fecha a tela atual//
			tela.setVisible(true);//deixa visivel*/
		}
	}	
}
