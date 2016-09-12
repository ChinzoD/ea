package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.TaskBeneficiary;

/**
 * Home object for domain model class TaskBeneficiary.
 * @see edu.mum.volunteering.dao.TaskBeneficiary
 * @author Hibernate Tools
 */
@Stateless
public class TaskBeneficiaryDao {

	private static final Log log = LogFactory.getLog(TaskBeneficiaryDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TaskBeneficiary transientInstance) {
		log.debug("persisting TaskBeneficiary instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TaskBeneficiary persistentInstance) {
		log.debug("removing TaskBeneficiary instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TaskBeneficiary merge(TaskBeneficiary detachedInstance) {
		log.debug("merging TaskBeneficiary instance");
		try {
			TaskBeneficiary result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TaskBeneficiary findById(Integer id) {
		log.debug("getting TaskBeneficiary instance with id: " + id);
		try {
			TaskBeneficiary instance = entityManager.find(TaskBeneficiary.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
