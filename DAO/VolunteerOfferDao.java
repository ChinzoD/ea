package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.VolunteerOffer;

/**
 * Home object for domain model class VolunteerOffer.
 * @see edu.mum.volunteering.dao.VolunteerOffer
 * @author Hibernate Tools
 */
@Stateless
public class VolunteerOfferDao {

	private static final Log log = LogFactory.getLog(VolunteerOfferDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(VolunteerOffer transientInstance) {
		log.debug("persisting VolunteerOffer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(VolunteerOffer persistentInstance) {
		log.debug("removing VolunteerOffer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public VolunteerOffer merge(VolunteerOffer detachedInstance) {
		log.debug("merging VolunteerOffer instance");
		try {
			VolunteerOffer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VolunteerOffer findById(Integer id) {
		log.debug("getting VolunteerOffer instance with id: " + id);
		try {
			VolunteerOffer instance = entityManager.find(VolunteerOffer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
