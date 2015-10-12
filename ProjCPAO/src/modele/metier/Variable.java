package modele.metier;

public class Variable {
	private int id = 0;
	private String libelle = "";
	private String type = "";

	public Variable() {
		this(-1, "", "");
	}

	public Variable(String libelle, String type) {
		this(-1, libelle, type);
	}

	public Variable(int id, String libelle, String type) {
		this.id = id;
		this.setLibelle(libelle);
		this.setType(type);
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
			throw new IllegalArgumentException("Saisir un nom correct");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if ((type != null) && (type.trim().length() > 0)) {
			this.type = type.trim();
		} else
			throw new IllegalArgumentException("Saisir un nom correct");
	}

	@Override
	public String toString() {
		return "Variable [id=" + id + ", libelle=" + libelle + ", type=" + type + "]";
	}

}