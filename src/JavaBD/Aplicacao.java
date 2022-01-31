package JavaBD;

import java.sql.SQLException;
import java.util.List;

import DAO.PessoaDao;
import Model.Pessoa;

public class Aplicacao {
	public static void main(String[] args) throws SQLException {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setIdContato(1);
		pessoa.setNome("Eduard");
		pessoa.setEndereco("Rua");
		pessoa.setCidade("Sem");
		pessoa.setCep("12345");
		pessoa.setRg("5555555");
		pessoa.setCpf("46968507811");
		pessoa.setTelefone("123456789");
		pessoa.setCelular("789654123");
		pessoa.setEmail("edulindo@gmail.com");
		
		PessoaDao pessoaDao = new PessoaDao();
		//pessoaDao.cadastrar(pessoa);
		
		//pessoaDao.alterar(pessoa);
		
		pessoaDao.excluir(pessoa);
		
		List<Pessoa> pessoas = new PessoaDao().getLista();
		for(Pessoa pes: pessoas) {
			System.out.println(pes.getIdContato()+"\n "+pes.getNome()+"\n "+pes.getEndreco()+"\n "+pes.getCidade()
			+"\n "+pes.getCep()+"\n "+pes.getRg()+"\n "+pes.getCpf()+"\n "+pes.getTelefone()+"\n "+pes.getCelular()+"\n "+pes.getEmail());
		}
	}

}
