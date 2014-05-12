package br.com.corsini.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public final class Query<E> {

	private static final Log log = new Log(Query.class);

	private final String name;

	private final String[] parameters;

	private Query(final String name, final String... parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	public String getName() {
		return name;
	}

	public String param(int index) {
		return parameters[index];
	}

	public String[] getParameters() {
		return parameters;
	}

	public static <E> Query<E> valueOf(Class<E> entityClass, String queryName,
			String... parameters) {
		return new Query<E>(queryName, parameters);
	}

	@SuppressWarnings("unchecked")
	public E single(EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		try {
			return (E) theQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			catchNonUniqueResultException(e, param);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public E cachedSingle(String region, EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		if (region != null) {
			theQuery = theQuery.setHint("org.hibernate.cacheRegion", region);
		}

		try {
			return (E) theQuery.setHint("org.hibernate.cacheable", true).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			catchNonUniqueResultException(e, param);
			return null;
		}
	}

	private void catchNonUniqueResultException(NonUniqueResultException e, Object... params) {
		StringBuilder message = new StringBuilder();
		message.append("NonUniqueResultException! ");
		message.append("Query=");
		message.append(name);
		int i = 1;
		for (Object param : params) {
			message.append("; param[");
			message.append(i++);
			message.append("]=");
			message.append(param);
		}
		message.append("; exceptionMsg=");
		message.append(e.getMessage());
		log.fatal(message.toString(), e);
	}

	@SuppressWarnings("unchecked")
	public List<E> list(FlushModeType flushModeType, EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);
		theQuery.setFlushMode(flushModeType);

		return theQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> list(EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		return theQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> cachedList(String region, EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		if (region != null) {
			theQuery = theQuery.setHint("org.hibernate.cacheRegion", region);
		}

		return theQuery.setHint("org.hibernate.cacheable", true).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> listPage(EntityManager em, int currentPage, int pageSize, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		theQuery = theQuery.setFirstResult(currentPage * pageSize).setMaxResults(pageSize);

		return theQuery.getResultList();
	}

	public int executeUpdate(EntityManager em, Object... param) {
		javax.persistence.Query theQuery = getPersistenceQuery(em, param);

		return theQuery.executeUpdate();
	}

	private javax.persistence.Query getPersistenceQuery(EntityManager em, Object... param) {
		// Verifica os parâmetros
		assertParameters(param);

		String[] paramName = getParameters();

		javax.persistence.Query theQuery = em.createNamedQuery(getName());
		for (int i = 0; i < paramName.length; i++) {
			theQuery = theQuery.setParameter(paramName[i], param[i]);
		}

		return theQuery;
	}

	private void assertParameters(Object... param) {
		if (getParameters().length != param.length) {
			throw new IllegalArgumentException("Wrong number of paramaters: query needs " +
					getParameters().length + " you passed " + param.length);
		}
		for (int i = 0; i < param.length; i++) {
			if (param[i] == null) {
				throw new IllegalArgumentException("Paramater " + getParameters()[i] +
						" is null");
			}
		}
	}

}