package modele.metier;

public class Concerne {
	private int idEmploye = 0;
	private int idRegle = 0;

	public Concerne(int idEmploye, int idRegle) {
		this.idEmploye = idEmploye;
		this.idRegle = idRegle;

	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int id_emp) {
		this.idEmploye = id_emp;
	}

	public int getIdRegle() {
		return idRegle;
	}

	public void setIdRegle(int id_regle) {
		this.idRegle = id_regle;
	}

	@Override
	public String toString() {
		return "Concerne [id_emp=" + idEmploye + ", id_regle=" + idRegle + "]";
	}

}
