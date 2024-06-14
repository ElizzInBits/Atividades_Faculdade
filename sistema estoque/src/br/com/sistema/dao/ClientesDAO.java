package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.sistema.jdbc.ConexaoBanco;
import br.com.sistema.model.Clientes;
import br.com.sistema.utilitarios.LoggerErroUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    private Connection conn;

    public ClientesDAO() {
        this.conn = new ConexaoBanco().pegarConexao();
    }

    public void Salvar(Clientes obj) {
        String sql = "INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente: " + erro.getMessage());
        }
    }
    
    public void Editar(Clientes obj) {
        String sql = "update tb_clientes set nome=?,rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?,"
        		+ "numero=?, complemento=?, bairro=?, cidade=?, estado=?where id=? ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());

            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editado o cliente: " + erro.getMessage());
        }
    }
    
    	public void Excluir(Clientes obj) {
    		
    		try {
    			
				String sql = "delete from tb_clientes where id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, obj.getId());
				stmt.execute();
				stmt.close();
				
				JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente" + e);
			}
    		
    	}

    public Clientes buscarCliente(String nome) {
        String sql = "SELECT * FROM tb_clientes WHERE nome = ?";
        Clientes obj = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    obj = new Clientes();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + erro.getMessage());
        }
        return obj;
    }
    public List<Clientes>Listar(){
    	List<Clientes> lista = new ArrayList<>();
    	try {
			String sql = "select * from tb_clientes";
			PreparedStatement stmt  = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Clientes obj =  new Clientes(); obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
				
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a lista");
		}
    	return null;
    	
    }
    public List<Clientes>Filtrar(String nome){
    	List<Clientes> lista = new ArrayList<>();
    	try {
			String sql = "select * from tb_clientes where nome like ?";
			PreparedStatement stmt  = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Clientes obj =  new Clientes(); obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
				
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a lista");
		}
    	return null;
    	
    }

    public List<Clientes> buscarClientesPorNome(String nome) {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%"); // Adiciona os caracteres '%' para buscar parte do nome
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Clientes obj = new Clientes();
                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setRg(rs.getString("rg"));
                    obj.setCpf(rs.getString("cpf"));
                    obj.setEmail(rs.getString("email"));
                    obj.setTelefone(rs.getString("telefone"));
                    obj.setCelular(rs.getString("celular"));
                    obj.setCep(rs.getString("cep"));
                    obj.setEndereco(rs.getString("endereco"));
                    obj.setNumero(rs.getInt("numero"));
                    obj.setComplemento(rs.getString("complemento"));
                    obj.setBairro(rs.getString("bairro"));
                    obj.setCidade(rs.getString("cidade"));
                    obj.setEstado(rs.getString("estado"));
                    lista.add(obj);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes por nome: " + e.getMessage());
            LoggerErroUtil.log("Erro ao buscar clientes por nome: " + nome, e); // Log do erro
        }
        return lista;
    }

}
