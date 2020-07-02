package ch.itenengineering.bmt.company.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.itenengineering.bmt.company.domain.Company;

@Stateless
public class CompanyManagerBean implements CompanyManagerRemote {

	@PersistenceContext(unitName = "BMTCompanyPU")
	private EntityManager em;

	public Company persist(Company company) {
		em.persist(company);
		return company;
	}

	public Company merge(Company company) {
		Company result = em.merge(company);
		return result;
	}

	public void remove(int id) {
		// find company
		Company company = em.find(Company.class, id);

		// remove company
		if (company != null) {
			em.remove(company);
		}
	}

	public Company find(int id) {
		Company result = em.find(Company.class, id);
		return result;
	}

	public List find(String namePattern) {
		Query query = em
				.createQuery("select c from Company as c where c.name like :paramName order by c.name");
		query.setParameter("paramName", namePattern);

		List result = query.getResultList();

		return result;
	}

} // end of class
