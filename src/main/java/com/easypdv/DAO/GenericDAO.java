package com.easypdv.DAO;

import com.easypdv.util.HibernateUtil;
import com.easypdv.entidades.Usuario;
import com.easypdv.util.JPAUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.setClasse(
				(Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	
	public Entidade salvar(Entidade entidade) {
		EntityManager em = JPAUtil.createEntityManager();
                Entidade user = null;
		try {
			em.getTransaction().begin();
			user =  em.merge(entidade);
			em.getTransaction().commit();
                        return user;
                        
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
                return user;
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
           
           return null;
	}

	public void excluir(Entidade entidade) {
		EntityManager em = JPAUtil.createEntityManager();
		try {
        		em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void merge(Entidade entidade) {
		EntityManager em = JPAUtil.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
                }
	}

	public Class<Entidade> getClasse() {
		return classe;
	}

	public void setClasse(Class<Entidade> classe) {
		this.classe = classe;
	}
}
