package edu.mum.volunteering.dao;
// Generated Sep 12, 2016 12:53:54 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.volunteering.domain.Project;

/**
 * Home object for domain model class Project.
 * @see edu.mum.volunteering.dao.Project
 * @author Hibernate Tools
 */
@Stateless
public class ProjectDao {

	private static final Log log = LogFactory.getLog(ProjectDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Project transientInstance) {
		log.debug("persisting Project instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Project persistentInstance) {
		log.debug("removing Project instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Project findById(Integer id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = entityManager.find(Project.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
