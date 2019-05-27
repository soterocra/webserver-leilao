package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.EstadoLeilaoDao;
import model.entities.EstadoLeilao;

public class EstadoLeilaoDaoJDBC implements EstadoLeilaoDao {

	private Connection conn;
	
	public EstadoLeilaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public EstadoLeilao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM Estado_leilao "
					+ "WHERE id_estado_leilao = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				EstadoLeilao obj = new EstadoLeilao();
				obj.setIdEstadoLeilao(rs.getInt("id_estado_leilao"));
				obj.setEstado(rs.getString("estado"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<EstadoLeilao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM Estado_leilao "
					+ "ORDER BY id_estado_leilao");
			
			rs = st.executeQuery();
			
			List<EstadoLeilao> list = new ArrayList<>();
			
			while (rs.next()) {
				
				EstadoLeilao obj = new EstadoLeilao();
				obj.setIdEstadoLeilao(rs.getInt("id_estado_leilao"));
				obj.setEstado(rs.getString("estado"));
				list.add(obj);
			}
			
			for (EstadoLeilao estadoLeilao : list) {
				System.out.println(estadoLeilao);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}