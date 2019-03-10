package com.em.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.em.dto.EmployeeDto;
import com.em.dto.PostDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoInterface {

	@Autowired
	SessionFactory factory;
	@Autowired
	EmployeeDaoInterface daoInterface;

	public EmployeeDto getEmpByLoginId(String loginId) {

		Session session = factory.openSession();
		Query query = session.createQuery("select emp from EmployeeDto emp where loginId = : loginId");
		query.setString("loginId", loginId);
		return (EmployeeDto) query.uniqueResult();
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto empfromJSP) {
		org.hibernate.Transaction transaction = null;
		Long idfromjsp = empfromJSP.getId();
		EmployeeDto empfromdb = null;
		EmployeeDto empUpdated = null;

		// Fetching Id From db
		if (idfromjsp != null) {
			try(Session session  = factory.openSession()) {
				Query query = session.createQuery("select emp from EmployeeDto emp where id = : id");
				query.setLong("id", idfromjsp);
				empfromdb = (EmployeeDto) query.uniqueResult();
				System.out.println("Fetched From db id-->" + empfromdb.getId() + empfromdb.getFirstName());
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		} else {
			return empUpdated;
		}
		// if id-from-db is  null
		if (empfromdb.getId() == null) {
			return empUpdated;
		} 
		// if id-from-db is not null
		else {
			try(Session session1 = factory.openSession()) {
				
				transaction = session1.beginTransaction();
				session1.update(empfromJSP);
				session1.getTransaction().commit();
				 empUpdated = daoInterface.getEmpByLoginId(empfromJSP.getLoginId());
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
		return empUpdated;

	}

	@Override
	public List<PostDto> getAllPost() {
		List<PostDto> list =null;
		try(Session session  = factory.openSession()) {
			Query query = session.createQuery("select post from PostDto post");
			list =  query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
