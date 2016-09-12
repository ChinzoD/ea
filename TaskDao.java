package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.Task;

/**
 * Home object for domain model class Task.
 * @see edu.mum.volunteering.dao.Task
 * @author Hibernate Tools
 */
@Stateless
public class TaskDao {

	private static final Log log = LogFactory.getLog(TaskDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Task transientInstance) {
		log.debug("persisting Task instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Task persistentInstance) {
		log.debug("removing Task instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Task findById(Integer id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = entityManager.find(Task.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
