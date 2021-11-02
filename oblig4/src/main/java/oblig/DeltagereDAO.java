package oblig;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class DeltagereDAO {

		@PersistenceContext(name="deltagerDB")
		private EntityManager em; 
		
	public List<Deltagere> hentAlleDeltager(){
		
		
		return em.createQuery("SELECT s from Deltagere s", Deltagere.class).getResultList();
	}
	
	public void leggTil(Deltagere x) {
		
		em.persist(x);
		
	}
	
	public boolean finnes(String mobNrPK) {
		
	return em.find(Deltagere.class, mobNrPK) != null; 
		
	}
	public Deltagere hent(String mobNrPK) {
		return em.find(Deltagere.class, mobNrPK);
	}
	
//	public String getPassord(String PK) {
//		
//		TypedQuery<Deltagere> query = em.createQuery("SELECT s from Deltagere s" + "WHERE s.Deltagere.mobilnr = :mobilnr", Deltagere.class); 
//		
//		query.setParameter("s", "pwd_hash"); 
//		query.setParameter("mobilnr", query)
//		
//	}
	
	
}
