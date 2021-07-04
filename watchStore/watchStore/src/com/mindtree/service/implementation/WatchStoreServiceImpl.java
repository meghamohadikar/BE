package com.mindtree.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.mindtree.dao.IWatchDao;
import com.mindtree.dao.daoImplementation.WatchDaoImpl;
import com.mindtree.entity.Watch;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.ServiceException;
import com.mindtree.service.IWatchStoreService;

public class WatchStoreServiceImpl implements IWatchStoreService {
	IWatchDao d = new WatchDaoImpl();

	public int insertType(String tid, String ttype) throws ServiceException {

		int i;
		try {
			i = d.insertData(tid, ttype);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return i;

	}

	public int insertWatch(String tidd, int wid, int modelnum, int price) throws ServiceException {
		int i;
		try {
			i = d.insertWatchData(tidd, wid, modelnum, price);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return i;
	}

	public List<Watch> sortWatch() throws ServiceException {
		List<Watch> list = new ArrayList<Watch>();
		try {
			list = d.sortWatchPrice();
			list.sort(new PriceComparator());
			return list;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public void deletewatch(String ttidd) throws ServiceException {
		try {
			d.deletetype(ttidd);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void CallableStmtexample() throws ServiceException {
		try {
			d.StoredProceImpl();
		} catch (DaoException e) {
			throw new ServiceException( e.getMessage(),e);
		}
		
	}

}
