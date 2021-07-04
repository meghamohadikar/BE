package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Watch;
import com.mindtree.exceptions.ServiceException;

public interface IWatchStoreService {

	int insertType(String tid, String ttype) throws ServiceException;

	int insertWatch(String tidd, int wid, int modelnum, int price) throws ServiceException;

	List<Watch> sortWatch() throws ServiceException;

	void deletewatch(String ttidd) throws ServiceException;

	void CallableStmtexample() throws ServiceException;

}
