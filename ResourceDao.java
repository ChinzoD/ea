package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.Resource;

/**
 * Home object for domain model class Resource.
 * @see edu.mum.volunteering.dao.Resource
 * @author Hibernate Tools
 */
@Stateless
public class ResourceDao {

	private static final Log log = LogFactory.getLog(ResourceDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Resource transientInstance) {
		log.debug("persisting Resource instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Resource persistentInstance) {
		log.debug("removing Resource instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Resource merge(Resource detachedInstance) {
		log.debug("merging Resource instance");
		try {
			Resource result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Resource findById(Integer id) {
		log.debug("getting Resource instance with id: " + id);
		try {
			Resource instance = entityManager.find(Resource.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
