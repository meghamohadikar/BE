package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Watch;
import com.mindtree.exceptions.DaoException;

public interface IWatchDao {

	int insertData(String tid, String ttype) throws DaoException;

	int insertWatchData(String tidd, int wid, int modelnum, int price) throws DaoException;

	List<Watch> sortWatchPrice() throws DaoException;

	void deletetype(String ttidd) throws DaoException;

	void StoredProceImpl() throws DaoException;

}
