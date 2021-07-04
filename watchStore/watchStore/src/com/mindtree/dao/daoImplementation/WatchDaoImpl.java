package com.mindtree.dao.daoImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.IWatchDao;
import com.mindtree.entity.Watch;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.TypeNotFoundException;
import com.mindtree.util.DbConnection;

public class WatchDaoImpl implements IWatchDao {
	DbConnection dbc = new DbConnection();

	public int insertData(String tid, String ttype) throws DaoException {
		dbc.createConnection();
		Connection con = dbc.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("insert into Type values(?,?);");
			pst.setString(1, tid);
			pst.setString(2, ttype);
			int i = pst.executeUpdate();
			pst.close();
			return i;

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}

	}

	public int insertWatchData(String tidd, int wid, int modelnum, int price) throws DaoException {
		dbc.createConnection();
		Connection con = dbc.getConnection();
		List<String> list = new ArrayList<String>();
		boolean flag = false;
		try {

			PreparedStatement pst = con.prepareStatement("select tid from Type");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				list.add(id);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.contains(tidd) == true) {
					flag = true;
				}
			}
			if (flag != true) {
				try {
					throw new TypeNotFoundException("Type not found");
				} catch (TypeNotFoundException e) {
					throw new DaoException(e.getMessage(), e);
				}
			} else {
				PreparedStatement psmt = con.prepareStatement("insert into Watch values(?,?,?,?)");
				psmt.setInt(1, wid);
				psmt.setInt(2, modelnum);
				psmt.setInt(3, price);
				psmt.setString(4, tidd);
				int i = psmt.executeUpdate();
				pst.close();
				psmt.close();
				return i;

			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public List<Watch> sortWatchPrice() throws DaoException {
		dbc.createConnection();
		Connection con = dbc.getConnection();
		Watch w;
		List<Watch> list = new ArrayList<Watch>();

		try {
			PreparedStatement pst = con.prepareStatement("select * from Watch");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				w = new Watch();
				w.setWid(rs.getInt(1));
				w.setWmodelNumber(rs.getInt(2));
				w.setwPrice(rs.getInt(3));
				w.setTid(rs.getString(4));
				list.add(w);

			}
			pst.close();
			return list;

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}

	}

	public void deletetype(String ttidd) throws DaoException {
		dbc.createConnection();
		Connection con = dbc.getConnection();
		List<String> list = new ArrayList<String>();
		boolean flag = false;
		try {

			PreparedStatement pst = con.prepareStatement("select tid from Type");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				list.add(id);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.contains(ttidd) == true) {
					flag = true;
				}
			}
			if (flag != true) {
				throw new TypeNotFoundException("Type not found");
			} else {
				PreparedStatement psmt = con.prepareStatement("delete from Type where tid=?");
				psmt.setString(1, ttidd);

				int i = psmt.executeUpdate();
				System.out.println(i + "records deleted");
				PreparedStatement ps = con.prepareStatement("delete from watch where tid=?");
				ps.setString(1, ttidd);

				int j = ps.executeUpdate();
				System.out.println(j + "records deleted");

				pst.close();
				psmt.close();
				ps.close();
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}

	}

	@Override
	public void StoredProceImpl() throws DaoException {
		dbc.createConnection();
		Connection con = dbc.getConnection();
		
		try {
			CallableStatement  stmt=con.prepareCall("{call Simple(?,?,?)}");
			stmt.setInt(1, 3000);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.registerOutParameter(3, Types.INTEGER);
			Boolean hasResult=stmt.execute();
			
			int mn=stmt.getInt(2);
			System.out.println("total watches having price >3000:");
			System.out.println(mn);
			System.out.println("average price:");
			int av=stmt.getInt(3);
			System.out.println(av);
			ResultSet res=stmt.getResultSet();
			System.out.println("modelNumber of watches whose price>3000");
			if(hasResult) {
				
				while(res.next()) {
					
					
					System.out.println(res.getInt(1));
					
					
				}
			}
		
		
		}catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		
	}

}
