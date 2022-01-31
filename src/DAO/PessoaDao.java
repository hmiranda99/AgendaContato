package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Pessoa;

public class PessoaDao {
	private Connection connection;
	
	//ROTINA DE CADASTRO
	public PessoaDao() {
		this.connection =  new ConnectionFactory().getConnection();
	}

	public void cadastrar(Pessoa pessoa) throws SQLException {
		try {
			String sql = "INSERT INTO tbContato" + 
						"(nome, endereco, cidade, cep, rg, cpf, telefone, celular, email)" +
						"VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,pessoa.getNome());
			stmt.setString(2,pessoa.getEndreco());
			stmt.setString(3,pessoa.getCidade());
			stmt.setString(4,pessoa.getCep());
			stmt.setString(5,pessoa.getRg());
			stmt.setString(6,pessoa.getCpf());
			stmt.setString(7,pessoa.getTelefone());
			stmt.setString(8,pessoa.getCelular());
			stmt.setString(9,pessoa.getEmail());
			stmt.execute();
			stmt.close();
			System.out.println("Cadastrado com sucesso!");
			
		}catch(SQLException e) {
			System.out.println("ERRO:" + e);
			
		}finally {
			connection.close();
		}
	}
	
	//ROTINA DE CONSULTA
	public List<Pessoa> getLista() throws SQLException{
		try {
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM tbcontato");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdContato(rs.getInt(1));
				pessoa.setNome(rs.getString(2));
				pessoa.setEndereco(rs.getString(3));
				pessoa.setCidade(rs.getString(4));
				pessoa.setCep(rs.getString(5));
				pessoa.setRg(rs.getString(6));
				pessoa.setCpf(rs.getString(7));
				pessoa.setTelefone(rs.getString(8));
				pessoa.setCelular(rs.getString(9));
				pessoa.setEmail(rs.getString(10));
				
				pessoas.add(pessoa);
			}
			
			rs.close();
			stmt.close();
			
			return pessoas;
			
		} catch(SQLException e) {
			throw new RuntimeException();
		}
		finally {
			connection.close();
		}
	}
	
	//ROTINA DE EDITAR
	public void alterar(Pessoa pessoa) throws SQLException {
		
		String sql = "UPDATE tbcontato SET ";
		String sqlInicial = "";
		Pattern pattern = Pattern.compile("\\?", Pattern.CASE_INSENSITIVE);
		
		
		if((pessoa.getNome() != null) && (pessoa.getNome().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", nome = ? " : "nome = ? ")); 
			
		}
		
		if((pessoa.getEndreco() != null) && (pessoa.getEndreco().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", endereco = ? " : "endereco = ? ")); 
		}
		
		if((pessoa.getCidade() != null) && (pessoa.getCidade().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", cidade = ? " : "cidade = ? ")); 
		}
		
		if((pessoa.getCep() != null) && (pessoa.getCep().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", cep = ? " : "cep = ? ")); 
		}
		
		if((pessoa.getRg() != null) && (pessoa.getRg().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", rg = ? " : "rg = ? ")); 
		}
		
		if((pessoa.getCpf() != null) && (pessoa.getCpf().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", cpf = ? " : "cpf = ? ")); 
		}
		
		if((pessoa.getTelefone() != null) && (pessoa.getTelefone().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", telefone = ? " : "telefone = ? ")); 
		}
		

		if((pessoa.getCelular() != null) && (pessoa.getCelular().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", celular = ? " : "celular = ? ")); 
		}
		

		if((pessoa.getEmail() != null) && (pessoa.getEmail().isEmpty() != true)) {
			Matcher matcher = pattern.matcher(sql);
			boolean existePropriedade = matcher.find();
			sql = sql.concat(sqlInicial.concat(existePropriedade ? ", email = ? " : "email = ? ")); 
		}
		
		sql = sql.concat(sql = sqlInicial.concat("WHERE idContato = ? "));
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(sql);
			
			int contador = 1;
			Matcher matcher = pattern.matcher(sql);
			long matchFound = matcher.results().count();
			
			
			
			
			if((pessoa.getNome() != null) && (pessoa.getNome().isEmpty() != true)) {				    
				    for(int i = contador; i < matchFound; i++) {
				    	if(i == contador) {
				    		stmt.setString(contador,pessoa.getNome());
				    		System.out.println(pessoa.getNome());
				    		System.out.println(contador);
				    	}
				    	contador++;
				    }	  
			}
			
			if((pessoa.getEndreco() != null) && (pessoa.getEndreco().isEmpty() != true)) {
				    for(int i = contador; i < matchFound; i++) {
				    	if(i == contador) {
				    		stmt.setString(contador,pessoa.getEndreco());			    		
				    	}
				    	contador++;
				    }	  
			}
			
			if((pessoa.getCidade() != null) && (pessoa.getCidade().isEmpty() != true)) {  
				    for(int i = contador; i < matchFound; i++) {
				    	if(i == contador) {
				    		stmt.setString(contador,pessoa.getCidade());
				    		System.out.println(pessoa.getCidade());
				    		System.out.println(contador);
				    	}
				    	contador++;
				    }	  
			}
			
			if((pessoa.getCep() != null) && (pessoa.getCep().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getCep());			    					    						    		
			    	}
			    	contador++;
			    }	  
			}
			
			if((pessoa.getRg() != null) && (pessoa.getRg().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getRg());			    					    						    		
			    	}
			    	contador++;
			    }	  
			}
			
			if((pessoa.getCpf() != null) && (pessoa.getCpf().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getCpf());	
			    		System.out.println(pessoa.getCpf());
			    		System.out.println(contador);
			    	}
			    	contador++;
			    }	  
			}
			
			if((pessoa.getTelefone() != null) && (pessoa.getTelefone().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getTelefone());			    				    						    						    		
			    	}
			    	contador++;
			    }	  
			}
			
			if((pessoa.getCelular() != null) && (pessoa.getCelular().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getCelular());
			    	}
			    	contador++;
			    }	  
			}
			
			if((pessoa.getEmail() != null) && (pessoa.getEmail().isEmpty() != true)) {  
			    for(int i = contador; i < matchFound; i++) {
			    	if(i == contador) {
			    		stmt.setString(contador,pessoa.getEmail());
			    	}
			    	contador++;
			    }	  
			}
			
			
			stmt.setInt(contador,pessoa.getIdContato());
			
			System.out.println(pessoa.getIdContato());
			System.out.println(contador);
			    	
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Dados alterados com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro: " + e);
		}
		finally {
			connection.close();
		}
		
	}
	
	//ROTINA DE EXCLUIR
	public void excluir(Pessoa pessoa) throws SQLException {
		String sql = "DELETE FROM tbcontato WHERE idContato = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pessoa.getIdContato());
			
			stmt.execute();
			stmt.close();
			System.out.println("Dados excluídos com sucesso!");
			
		} catch(SQLException e) {
			System.out.println("Erro: " + e);
		}
		finally {
			connection.close();
		}
	}
}
