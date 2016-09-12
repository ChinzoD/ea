package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.Beneficiary;

/**
 * Home object for domain model class Beneficiary.
 * @see edu.mum.volunteering.dao.Beneficiary
 * @author Hibernate Tools
 */
@Stateless
public class BeneficiaryDao {

	private static final Log log = LogFactory.getLog(BeneficiaryDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Beneficiary transientInstance) {
		log.debug("persisting Beneficiary instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Beneficiary persistentInstance) {
		log.debug("removing Beneficiary instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Beneficiary merge(Beneficiary detachedInstance) {
		log.debug("merging Beneficiary instance");
		try {
			Beneficiary result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Beneficiary findById(Integer id) {
		log.debug("getting Beneficiary instance with id: " + id);
		try {
			Beneficiary instance = entityManager.find(Beneficiary.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
