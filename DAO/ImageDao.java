package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.Image;

/**
 * Home object for domain model class Image.
 * @see edu.mum.volunteering.dao.Image
 * @author Hibernate Tools
 */
@Stateless
public class ImageDao {

	private static final Log log = LogFactory.getLog(ImageDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Image transientInstance) {
		log.debug("persisting Image instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Image persistentInstance) {
		log.debug("removing Image instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Image merge(Image detachedInstance) {
		log.debug("merging Image instance");
		try {
			Image result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Image findById(Integer id) {
		log.debug("getting Image instance with id: " + id);
		try {
			Image instance = entityManager.find(Image.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
