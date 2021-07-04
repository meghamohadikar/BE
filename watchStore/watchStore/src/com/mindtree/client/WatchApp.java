package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.entity.Watch;
import com.mindtree.exceptions.ApplicationException;
import com.mindtree.exceptions.ServiceException;
import com.mindtree.service.IWatchStoreService;
import com.mindtree.service.implementation.WatchStoreServiceImpl;

public class WatchApp {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		IWatchStoreService s=new WatchStoreServiceImpl();
		
		boolean flag=true;
		while(flag) {
			System.out.println("choices available:");
			System.out.println("1)add type");
			System.out.println("2)add watches in type");
			System.out.println("3)Sorting watches based on price");
			System.out.println("4)delete watches");
		  	System.out.println("5)exit");
			System.out.println("6)Stored Procedures");
			System.out.println();
			System.out.println("enter choice");
			
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:System.out.println("enter the type id");
			String tid=sc.next();
			System.out.println("enter the Type of watch");
			String ttype=sc.next();
				try {
					int i=s.insertType(tid,ttype);
					System.out.println(i+" Record inserted");
					} catch (ServiceException e) {
						try {
							throw new ApplicationException(e.getMessage(),e);
						} catch (ApplicationException e1) {
							try {
								throw new  Exception(e1.getMessage(),e1);
							} catch (Exception e2) {
							System.out.println(e2.getMessage());
								
							}
					}
					}
					break;
					case 2:
						System.out.println("enter the type in which you want to add watch");
						String tidd=sc.next();
						
						System.out.println("enter the watch id");
						int wid=sc.nextInt();
						System.out.println("enter the model number");
						int modelnum=sc.nextInt();
						System.out.println("enter the price of watch");
						int price=sc.nextInt();
					
				try {
					int i=s.insertWatch(tidd,wid,modelnum,price);
					System.out.println(i+"records updated!");
				} catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getMessage(),e);
					} catch (ApplicationException e1) {
						try {
							throw new  Exception(e1.getMessage(),e1);
						} catch (Exception e2) {
						System.out.println(e2.getMessage());
							
						}
				}
				}
			
		
			break;
			case 3:
				List<Watch> list=new ArrayList<Watch>();
				try {
					list=s.sortWatch();
					System.out.println("in sorted order based on price");
					for(Watch itr:list) {
						System.out.println(itr);
					System.out.println();
					}
				
					
					
					
				} catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getMessage(),e);
					} catch (ApplicationException e1) {
						try {
							throw new  Exception(e1.getMessage(),e1);
						} catch (Exception e2) {
						System.out.println(e2.getMessage());
							
						}
				}
				}
				break;
			case 4:
				System.out.println("enter the tid of watch to be deleted");
				String ttidd=sc.next();
				try {
					s.deletewatch(ttidd);
					System.out.println("Deletion Successful!");
				} catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getMessage(),e);
					} catch (ApplicationException e1) {
						try {
							throw new  Exception(e1.getMessage(),e1);
						} catch (Exception e2) {
						System.out.println(e2.getMessage());
							
						}
				}
				}
				break;
			case 5: flag=false;
			break;
			
			case 6:try {
					s.CallableStmtexample();
				}  catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getMessage(),e);
					} catch (ApplicationException e1) {
						try {
							throw new  Exception(e1.getMessage(),e1);
						} catch (Exception e2) {
						System.out.println(e2.getMessage());
							
						}
				}
				}
			break;
			
			default:
				System.out.println("invalid choice:enter agin");
				flag=true;
			
			
			}
			
		}

	}

}

