package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import DAO.PessoaDao;
import Model.Pessoa;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormCadastro extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	private JTextField cxId;
	private JTextField cxNome;
	private JTextField cxLog;
	private JTextField cxCep;
	private JTextField cxCidade;
	private JTextField cxCpf;
	private JTextField cxRg;
	private JTextField cxTel;
	private JTextField cxCel;
	private JTextField cxEmail;
	private JTextField cxMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCadastro frame = new FormCadastro();
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
	public FormCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormCadastro.class.getResource("/imgs/molieres.png")));
		setTitle("Cadastro de Contatos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 821);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 524, 784);
		contentPane.add(panel);
		panel.setLayout(null);
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 0, 530, 789);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Op\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 11, 510, 147);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(cxNome.getText().toString());
				pessoa.setCpf(cxCpf.getText().toString());
				pessoa.setRg(cxRg.getText().toString());
				pessoa.setEndereco(cxLog.getText().toString());
				pessoa.setCep(cxCep.getText().toString());
				pessoa.setCidade(cxCidade.getText().toString());
				pessoa.setTelefone(cxTel.getText().toString());
				pessoa.setCelular(cxCel.getText().toString());
				pessoa.setEmail(cxEmail.getText().toString());
				
					PessoaDao pessoaDao = new PessoaDao();
					
					try {
						cxNome.setText("");
						cxCpf.setText("");
						cxRg.setText("");
						cxLog.setText("");
						cxCep.setText("");
						cxCidade.setText("");
						cxTel.setText("");
						cxCel.setText("");
						cxEmail.setText("");
						
						cxId.setEditable(false);
						cxNome.setEditable(false);
						cxCpf.setEditable(false);
						cxRg.setEditable(false);
						cxLog.setEditable(false);
						cxCep.setEditable(false);
						cxCidade.setEditable(false);
						cxTel.setEditable(false);
						cxCel.setEditable(false);
						cxEmail.setEditable(false);
						
						cxMensagem.setText("Cadastro concluído com sucesso!");
						pessoaDao.cadastrar(pessoa);
						
					} catch(SQLException e1) {
						e1.printStackTrace();
						cxMensagem.setText("Ops... Houve algo de errado com o cadastro.");
					}
				
				//cxNome.setEditable(true);
				//cxCpf.setEditable(true);
				//cxRg.setEditable(true);
				//cxLog.setEditable(true);
				//cxCep.setEditable(true);
				//cxCidade.setEditable(true);
				//cxTel.setEditable(true);
				//cxCel.setEditable(true);
				//cxEmail.setEditable(true);
				
				//cxNome.requestFocus();
			}
		});
		cadastrar.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/cadastrar1 (1).png")));
		cadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		cadastrar.setBounds(10, 22, 147, 50);
		panel_2.add(cadastrar);
		
		JButton btnNewButton_1 = new JButton("Consultar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdContato(Integer.parseInt(cxId.getText().toString()));
				
				try {
					List<Pessoa> pessoas = new PessoaDao().getLista();
					
					for(Pessoa pes:pessoas) {
						if(pes.getIdContato() == Integer.parseInt(cxId.getText().toString())) {
							cxNome.setText(pes.getNome());
							cxCpf.setText(pes.getCpf());
							cxRg.setText(pes.getRg());
							cxLog.setText(pes.getEndreco());
							cxCep.setText(pes.getCep());
							cxCidade.setText(pes.getCidade());
							cxTel.setText(pes.getTelefone());
							cxCel.setText(pes.getCelular());
							cxEmail.setText(pes.getEmail());
						}
					}
					cxNome.setEditable(false);
					cxCpf.setEditable(false);
					cxRg.setEditable(false);
					cxLog.setEditable(false);
					cxCep.setEditable(false);
					cxCidade.setEditable(false);
					cxTel.setEditable(false);
					cxCel.setEditable(false);
					cxEmail.setEditable(false);
					
					cxMensagem.setText("Consulta concluída com sucesso!");
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/consultar.png")));
		btnNewButton_1.setBounds(182, 23, 147, 50);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cxNome.requestFocus();
				
				Pessoa pessoa = new Pessoa();
				pessoa.setIdContato(Integer.parseInt(cxId.getText().toString()));
				pessoa.setNome(cxNome.getText().toString());
				pessoa.setCpf(cxCpf.getText().toString());
				pessoa.setRg(cxRg.getText().toString());
				pessoa.setEndereco(cxLog.getText().toString());
				pessoa.setCep(cxCep.getText().toString());
				pessoa.setCidade(cxCidade.getText().toString());
				pessoa.setTelefone(cxTel.getText().toString());
				pessoa.setCelular(cxCel.getText().toString());
				pessoa.setEmail(cxEmail.getText().toString());
				
				PessoaDao pessoaDao = new PessoaDao();
				
				try {
					pessoaDao.alterar(pessoa);
					cxMensagem.setText("Alteração feita com sucesso!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/editar.png")));
		btnNewButton_2.setBounds(353, 23, 147, 50);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdContato(Integer.parseInt(cxId.getText().toString()));
				
				PessoaDao pessoaDao = new PessoaDao();
				
				try {
					pessoaDao.excluir(pessoa);
					cxMensagem.setText("Contato excluído com sucesso!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/excluiur1.png")));
		btnNewButton_3.setBounds(182, 84, 147, 50);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("Sair");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicio janela = new TelaInicio();
				FormCadastro.this.dispose();
				janela.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_7.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/sair.png")));
		btnNewButton_7.setBounds(353, 84, 147, 50);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Limpar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cxId.setText("");
				cxNome.setText("");
				cxCpf.setText("");
				cxRg.setText("");
				cxLog.setText("");
				cxCep.setText("");
				cxCidade.setText("");
				cxTel.setText("");
				cxCel.setText("");
				cxEmail.setText("");
				
				cxId.setEditable(true);
				cxNome.setEditable(true);
				cxCpf.setEditable(true);
				cxRg.setEditable(true);
				cxLog.setEditable(true);
				cxCep.setEditable(true);
				cxCidade.setEditable(true);
				cxTel.setEditable(true);
				cxCel.setEditable(true);
				cxEmail.setEditable(true);
				
				//voltar cursor do mouse
				cxId.requestFocus();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/limpar.png")));
		btnNewButton_6.setBounds(10, 83, 147, 50);
		panel_2.add(btnNewButton_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_4.setBounds(10, 169, 510, 484);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(182, 22, 58, 20);
		panel_4.add(lblNewLabel);
		
		cxId = new JTextField();
		cxId.setBounds(235, 23, 86, 20);
		panel_4.add(cxId);
		cxId.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informa\u00E7\u00F5es Pessoais:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(10, 54, 490, 137);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 23, 46, 14);
		panel_5.add(lblNewLabel_1);
		
		cxNome = new JTextField();
		cxNome.setBounds(10, 48, 470, 20);
		panel_5.add(cxNome);
		cxNome.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CPF:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 79, 46, 14);
		panel_5.add(lblNewLabel_6);
		
		
		try {
		cxCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cxCpf.setBounds(10, 104, 225, 20);
		panel_5.add(cxCpf);
		cxCpf.setColumns(10);
		}catch(Exception erro) {

        }
		
		JLabel lblNewLabel_7 = new JLabel("RG:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(250, 79, 46, 14);
		panel_5.add(lblNewLabel_7);
		
		cxRg = new JTextField();
		cxRg.setBounds(250, 104, 230, 20);
		panel_5.add(cxRg);
		cxRg.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_6.setBounds(10, 202, 490, 137);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Logradouro:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 23, 86, 14);
		panel_6.add(lblNewLabel_2);
		
		cxLog = new JTextField();
		cxLog.setBounds(10, 48, 470, 20);
		panel_6.add(cxLog);
		cxLog.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 79, 46, 14);
		panel_6.add(lblNewLabel_4);
		
		try {
		cxCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		cxCep.setBounds(10, 104, 225, 20);
		panel_6.add(cxCep);
		cxCep.setColumns(10);
		}catch(Exception erro) {

        }
		
		cxCidade = new JTextField();
		cxCidade.setBounds(250, 104, 230, 20);
		panel_6.add(cxCidade);
		cxCidade.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(250, 79, 46, 14);
		panel_6.add(lblNewLabel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		panel_7.setBounds(10, 350, 490, 127);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Telefone:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 21, 66, 14);
		panel_7.add(lblNewLabel_8);
		
		try {
		cxTel = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		cxTel.setBounds(10, 42, 225, 20);
		panel_7.add(cxTel);
		cxTel.setColumns(10);
		}catch(Exception erro) {

        }
		
		JLabel lblNewLabel_9 = new JLabel("Celular:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(249, 21, 46, 14);
		panel_7.add(lblNewLabel_9);
		
		try {
		cxCel = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
		cxCel.setBounds(249, 42, 231, 20);
		panel_7.add(cxCel);
		cxCel.setColumns(10);
		}catch(Exception erro) {

        }
		
		JLabel lblNewLabel_10 = new JLabel("Email:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(10, 73, 46, 14);
		panel_7.add(lblNewLabel_10);
		
		cxEmail = new JTextField();
		cxEmail.setBounds(10, 96, 470, 20);
		panel_7.add(cxEmail);
		cxEmail.setColumns(10);
		
		JButton ok = new JButton("\r\n");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ok.setBounds(106, 723, 147, 50);
		panel_1.add(ok);
		ok.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/ok.png")));
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(263, 723, 147, 50);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setIcon(new ImageIcon(FormCadastro.class.getResource("/imgs/cancelar2.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mensagem", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 663, 510, 50);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		cxMensagem = new JTextField();
		cxMensagem.setFont(new Font("Tahoma", Font.BOLD, 10));
		cxMensagem.setEditable(false);
		cxMensagem.setBounds(10, 21, 490, 19);
		panel_3.add(cxMensagem);
		cxMensagem.setColumns(10);
	}
}
