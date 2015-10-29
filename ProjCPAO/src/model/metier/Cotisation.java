package model.metier;

public class Cotisation implements Comparable<Cotisation> {
	private int id = 0;
	private String libelle = "";
	private double taux;

	public Cotisation() {
		this(-1, "meh", -1);
	}

	public Cotisation(String libelle, double taux) {
		this(-1, libelle, taux);
	}

	public Cotisation(int id, String libelle, double taux) {
		this.id = id;
		this.setLibelle(libelle);
		this.taux = taux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		if ((libelle != null) && (libelle.trim().length() > 0)) {
			this.libelle = libelle.trim();
		} else
			throw new IllegalArgumentException("Saisir un libelle correct");
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "Cotisation [id=" + id + ", libelle=" + libelle + ", taux=" + taux + "]";
	}

	@Override
	public int compareTo(Cotisation c) {
//		if (libelle.equals(c.libelle)){
//			return taux.compareTo(c.taux);
//		}
//		return libelle.compareTo(c.taux);
		return libelle.compareTo(c.libelle);
	}

}
