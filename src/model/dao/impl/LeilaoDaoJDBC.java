package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.LeilaoDao;
import model.entities.Leilao;
import model.entities.Usuario;

public class LeilaoDaoJDBC implements LeilaoDao {

private Connection conn;
	
	public LeilaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Leilao obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Leilao obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Leilao findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leilao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Leilao> findByUser(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
