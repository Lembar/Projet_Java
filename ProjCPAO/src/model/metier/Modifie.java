package model.metier;

public class Modifie {
	private int idEmploye = 0;
	private int idVariable = 0;
	private String valeur = "";

	public Modifie() {
		this(-1, -1, "Meh");
	}

	public Modifie(String valeur) {
		this(-1, -1, valeur);
	}

	public Modifie(int id_emp, int id_var, String valeur) {
		this.idEmploye = id_emp;
		this.idVariable = id_var;
		this.setValeur(valeur);
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int id_emp) {
		this.idEmploye = id_emp;
	}

	public int getIdVariable() {
		return idVariable;
	}

	public void setIdVariable(int id_var) {
		this.idVariable = id_var;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		if ((valeur != null) && (valeur.trim().length() > 0)) {
			this.valeur = valeur.trim();
		} else
			throw new IllegalArgumentException("Saisir un nom correct");
	}

	@Override
	public String toString() {
		return "Modifie [id_emp=" + idEmploye + ", id_var=" + idVariable
				+ ", valeur=" + valeur + "]";
	}

}
