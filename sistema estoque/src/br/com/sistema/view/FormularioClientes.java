package br.com.sistema.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import br.com.sistema.dao.ClientesDAO;
import br.com.sistema.model.Clientes;
import br.com.sistema.utilitarios.Utilitarios;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.com.sistema.utilitarios.LoggerUtil;
import br.com.sistema.utilitarios.LoggerErroUtil; 




public class FormularioClientes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane painel_guias = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtPesquisarNome;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			LoggerErroUtil.log("Erro ao configurar o LookAndFeel", e);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioClientes frame = new FormularioClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					LoggerErroUtil.log("Erro ao inicializar o FormularioClientes", e);
				}
			}
		});
	}
	public void listar() {
		try {
            ClientesDAO dao = new ClientesDAO();
            List<Clientes> lista = dao.Listar();
            DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
            dados.setNumRows(0);
            for (Clientes c : lista) {
                dados.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getRg(),
                    c.getCpf(),
                    c.getEmail(),
                    c.getTelefone(),
                    c.getCelular(),
                    c.getCep(),
                    c.getEndereco(),
                    c.getNumero(),
                    c.getComplemento(),
                    c.getBairro(),
                    c.getCidade(),
                    c.getEstado()
                });
            }
            LoggerUtil.log("Listagem de clientes atualizada. Total: " + lista.size());
        } catch (Exception e) {
            LoggerErroUtil.log("Erro ao listar clientes", e);
        }
    }
	/**
	 * Create the frame.
	 */
	public FormularioClientes() {
		setTitle("Formulário de clientes");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				listar();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1258, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(167, 29, 73));
		panel.setBounds(-11, 0, 1266, 152);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Cadastro de Clientes");
		lblNewJgoodiesTitle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 46));
		lblNewJgoodiesTitle.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesTitle.setBounds(369, 42, 527, 67);
		panel.add(lblNewJgoodiesTitle);
		painel_guias.setBounds(-1, 152, 1256, 342);
		contentPane.add(painel_guias);

		JPanel painel_dados_pessoais = new JPanel();
		painel_dados_pessoais.setAlignmentX(Component.RIGHT_ALIGNMENT);
		painel_guias.addTab("Dados Pessoais", null, painel_dados_pessoais, null);
		painel_dados_pessoais.setLayout(null);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 62, 86, 22);
		painel_dados_pessoais.add(lblNewLabel);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(103, 62, 158, 22);
		painel_dados_pessoais.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNome.setBounds(20, 94, 86, 22);
		painel_dados_pessoais.add(lblNome);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
		    private JComboBox<String> cbUf;

			@Override
			 public void keyPressed(KeyEvent evt) {
                try {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        String nome = txtNome.getText();
                        Clientes obj = new Clientes();
                        ClientesDAO dao = new ClientesDAO();
                        obj = dao.buscarCliente(nome);
                        if (obj != null && obj.getNome() != null) {
                            txtCodigo.setText(String.valueOf(obj.getId()));
                            txtNome.setText(obj.getNome());
                            txtRg.setText(obj.getRg());
                            txtCpf.setText(obj.getCpf());
                            txtEmail.setText(obj.getEmail());
                            txtTelefone.setText(obj.getTelefone());
                            txtCelular.setText(obj.getCelular());
                            txtCep.setText(obj.getCep());
                            txtEndereco.setText(obj.getEndereco());
                            txtNumero.setText(String.valueOf(obj.getNumero()));
                            txtComplemento.setText(obj.getComplemento());
                            txtBairro.setText(obj.getBairro());
                            txtCidade.setText(obj.getCidade());
                            cbUf.setSelectedItem(obj.getEstado());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                            LoggerErroUtil.log("Cliente não encontrado: " + nome);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LoggerErroUtil.log("Erro ao buscar cliente: " + txtNome.getText(), e);
                }
            }
        });

		txtNome.setColumns(10);
		txtNome.setBounds(103, 94, 323, 22);
		painel_dados_pessoais.add(txtNome);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			private JComboBox<String> cbUf;

			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				Clientes obj = new Clientes();
				ClientesDAO dao = new ClientesDAO();
				
				obj = dao.buscarCliente(nome);
				if (obj.getNome() != null) {
					txtCodigo.setText(String.valueOf(obj.getId()));
					txtNome.setText(obj.getNome());
					txtRg.setText(obj.getRg());
					txtCpf.setText(obj.getCpf());
					txtEmail.setText(obj.getEmail());
					txtTelefone.setText(obj.getTelefone());
					txtCelular.setText(obj.getCelular());
					txtCep.setText(obj.getCep());
					txtEndereco.setText(obj.getEndereco());
					txtNumero.setText(String.valueOf(obj.getNumero()));
					txtComplemento.setText(obj.getComplemento());
					txtBairro.setText(obj.getBairro());
					txtCidade.setText(obj.getCidade());
					cbUf.setSelectedItem(obj.getEstado());
					
				}else {
					JOptionPane.showMessageDialog(null,"Cliente não encontrado");
				}
			}
		});
		btnPesquisar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnPesquisar.setBounds(450, 95, 97, 23);
		painel_dados_pessoais.add(btnPesquisar);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblEmail.setBounds(20, 128, 86, 22);
		painel_dados_pessoais.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 128, 323, 22);
		painel_dados_pessoais.add(txtEmail);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblCelular.setBounds(450, 128, 86, 22);
		painel_dados_pessoais.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(533, 128, 158, 22);
		painel_dados_pessoais.add(txtCelular);
		

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblTelefone.setBounds(711, 128, 104, 22);
		painel_dados_pessoais.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(808, 128, 158, 22);
		painel_dados_pessoais.add(txtTelefone);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblCep.setBounds(20, 160, 86, 22);
		painel_dados_pessoais.add(lblCep);

		txtCep = new JTextField();

		txtCep.setColumns(10);
		txtCep.setBounds(103, 160, 158, 22);
		painel_dados_pessoais.add(txtCep);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblEndereo.setBounds(271, 160, 113, 22);
		painel_dados_pessoais.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(381, 160, 310, 22);
		painel_dados_pessoais.add(txtEndereco);

		JLabel lblN = new JLabel("Nº:");
		lblN.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblN.setBounds(725, 160, 86, 22);
		painel_dados_pessoais.add(lblN);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(808, 160, 158, 22);
		painel_dados_pessoais.add(txtNumero);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBairro.setBounds(20, 192, 86, 22);
		painel_dados_pessoais.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(103, 192, 220, 22);
		painel_dados_pessoais.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblCidade.setBounds(333, 192, 86, 22);
		painel_dados_pessoais.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(416, 192, 220, 22);
		painel_dados_pessoais.add(txtCidade);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(808, 192, 158, 22);
		painel_dados_pessoais.add(txtComplemento);

		JLabel lblCidade_1 = new JLabel("Complemento:");
		lblCidade_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblCidade_1.setBounds(654, 192, 142, 22);
		painel_dados_pessoais.add(lblCidade_1);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblRg.setBounds(20, 228, 86, 22);
		painel_dados_pessoais.add(lblRg);

		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(103, 228, 220, 22);
		painel_dados_pessoais.add(txtRg);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblCpf.setBounds(333, 228, 86, 22);
		painel_dados_pessoais.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(416, 228, 220, 22);
		painel_dados_pessoais.add(txtCpf);

		JComboBox<String> cbUF = new JComboBox<>();
		cbUF.setBounds(983, 192, 47, 21);
		
		String[] estados = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
		for (String estado : estados) {
		    cbUF.addItem(estado);
		}
		painel_dados_pessoais.add(cbUF);

		JPanel painel_consulta = new JPanel();
		painel_guias.addTab("Consulta de Clientes", null, painel_consulta, null);
		painel_consulta.setLayout(null);

		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNome_1.setBounds(10, 20, 86, 22);
		painel_consulta.add(lblNome_1);

		txtPesquisarNome = new JTextField();
		txtPesquisarNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
                try {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        String nome = "%" + txtPesquisarNome.getText() + "%";
                        ClientesDAO dao = new ClientesDAO();
                        List<Clientes> lista = dao.buscarClientesPorNome(nome);
                        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
                        dados.setNumRows(0);
                        for (Clientes c : lista) {
                            dados.addRow(new Object[]{
                                c.getId(),
                                c.getNome(),
                                c.getRg(),
                                c.getCpf(),
                                c.getEmail(),
                                c.getTelefone(),
                                c.getCelular(),
                                c.getCep(),
                                c.getEndereco(),
                                c.getNumero(),
                                c.getComplemento(),
                                c.getBairro(),
                                c.getCidade(),
                                c.getEstado()
                            });
                        }
                        LoggerUtil.log("Pesquisa de clientes pelo nome. Total: " + lista.size());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LoggerErroUtil.log("Erro ao pesquisar clientes por nome", e);
                }
            }
        });
		txtPesquisarNome.setColumns(10);
		txtPesquisarNome.setBounds(93, 20, 323, 22);
		painel_consulta.add(txtPesquisarNome);

		JButton btnPesquisaNome = new JButton("Pesquisar");
		btnPesquisaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = "%" + txtPesquisarNome.getText()+ "%";
				ClientesDAO dao = new ClientesDAO();
				List<Clientes> lista = dao.Filtrar(nome);
				
				DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
				
				dados.setNumRows(0);
				for(Clientes c : lista) {
					dados.addRow(new Object[] {
							c.getId(),
							c.getNome(),
							c.getRg(),
							c.getCpf(),
							c.getEmail(),
							c.getTelefone(),
							c.getCelular(),
							c.getCep(),
							c.getEndereco(),
							c.getNumero(),
							c.getComplemento(),
							c.getBairro(),
							c.getCidade(),
							c.getEstado()
					});
				}
				
			}
		});
		btnPesquisaNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnPesquisaNome.setBounds(426, 20, 97, 23);
		painel_consulta.add(btnPesquisaNome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 48, 1210, 267);
		painel_consulta.add(scrollPane);

		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        painel_guias.setSelectedIndex(0);
		        
		        int selectedRow = tabela.getSelectedRow();
		        if (selectedRow != -1) { 
		            txtCodigo.setText(tabela.getValueAt(selectedRow, 0).toString());
		            txtNome.setText(tabela.getValueAt(selectedRow, 1).toString());
		            txtRg.setText(tabela.getValueAt(selectedRow, 2).toString());
		            txtCpf.setText(tabela.getValueAt(selectedRow, 3).toString());
		            txtEmail.setText(tabela.getValueAt(selectedRow, 4).toString());
		            txtTelefone.setText(tabela.getValueAt(selectedRow, 5).toString());
		            txtCelular.setText(tabela.getValueAt(selectedRow, 6).toString());
		            txtCep.setText(tabela.getValueAt(selectedRow, 7).toString());
		            txtEndereco.setText(tabela.getValueAt(selectedRow, 8).toString());
		            txtNumero.setText(tabela.getValueAt(selectedRow, 9).toString());
		            txtComplemento.setText(tabela.getValueAt(selectedRow, 10).toString());
		            txtBairro.setText(tabela.getValueAt(selectedRow, 11).toString());
		            txtCidade.setText(tabela.getValueAt(selectedRow, 12).toString());
		            cbUF.setSelectedItem(tabela.getValueAt(selectedRow, 13).toString());
		        }
		    }
		});

		tabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "RG",
				"CPF", "Email", "Telefone", "Celular", "CEP", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado" }));
		scrollPane.setViewportView(tabela);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setIcon(new ImageIcon(FormularioClientes.class.getResource("/br/com/sistema/imagens/novo_1.png")));
		btnNovo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				
				util.LimparTela(painel_dados_pessoais);
			}
		});
		btnNovo.setBounds(90, 553, 180, 35);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setIcon(new ImageIcon(FormularioClientes.class.getResource("/br/com/sistema/imagens/salvar.png")));
		btnSalvar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnSalvar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Clientes obj = new Clientes();

		        obj.setNome(txtNome.getText());
		        obj.setRg(txtRg.getText());
		        obj.setCpf(txtCpf.getText());
		        obj.setEmail(txtEmail.getText());
		        obj.setTelefone(txtTelefone.getText());
		        obj.setCelular(txtCelular.getText());
		        obj.setCep(txtCep.getText());
		        obj.setEndereco(txtEndereco.getText());
		        obj.setNumero(Integer.parseInt(txtNumero.getText()));
		        obj.setComplemento(txtComplemento.getText());
		        obj.setBairro(txtBairro.getText());
		        obj.setCidade(txtCidade.getText());
		        obj.setEstado(cbUF.getSelectedItem().toString());

		        ClientesDAO dao = new ClientesDAO();
		        dao.Salvar(obj);
		        LoggerUtil.log("Cliente salvo: " + obj.getNome() + " (ID: " + obj.getId() + ")");
		        Utilitarios util = new Utilitarios();
		        util.LimparTela(painel_dados_pessoais);
		    }
		});

		btnSalvar.setBounds(305, 553, 180, 35);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Clientes obj = new Clientes();

			        obj.setNome(txtNome.getText());
			        obj.setRg(txtRg.getText());
			        obj.setCpf(txtCpf.getText());
			        obj.setEmail(txtEmail.getText());
			        obj.setTelefone(txtTelefone.getText());
			        obj.setCelular(txtCelular.getText());
			        obj.setCep(txtCep.getText());
			        obj.setEndereco(txtEndereco.getText());
			        obj.setNumero(Integer.parseInt(txtNumero.getText()));
			        obj.setComplemento(txtComplemento.getText());
			        obj.setBairro(txtBairro.getText());
			        obj.setCidade(txtCidade.getText());
			        obj.setEstado(cbUF.getSelectedItem().toString());
			        obj.setId(Integer.valueOf(txtCodigo.getText()));

			        ClientesDAO dao = new ClientesDAO();
			        dao.Editar(obj);
			        LoggerUtil.log("Cliente editado: " + obj.getNome() + " (ID: " + obj.getId() + ")");
			        Utilitarios util = new Utilitarios();
			        util.LimparTela(painel_dados_pessoais);
			}
		});
		btnEditar.setIcon(new ImageIcon(FormularioClientes.class.getResource("/br/com/sistema/imagens/editar.png")));
		btnEditar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnEditar.setBounds(520, 553, 180, 35);
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setIcon(new ImageIcon(FormularioClientes.class.getResource("/br/com/sistema/imagens/excluir.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes obj = new Clientes();
				obj.setId(Integer.valueOf(txtCodigo.getText()));
				ClientesDAO dao = new ClientesDAO();
				dao.Excluir(obj);
				LoggerUtil.log("Cliente excluído: ID " + obj.getId());
				Utilitarios util = new Utilitarios();
				util.LimparTela(painel_dados_pessoais);
			}
		});
		btnExcluir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnExcluir.setBounds(730, 553, 180, 35);
		contentPane.add(btnExcluir);

		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setIcon(new ImageIcon(FormularioClientes.class.getResource("/br/com/sistema/imagens/printer.png")));
		btnImprimir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnImprimir.setBounds(940, 553, 180, 35);
		contentPane.add(btnImprimir);
	}
} 