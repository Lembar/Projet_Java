package modele.metier;

public class Regle {
	private int id = 0;
	private String condition = "";
	private String action = "";
	private boolean actif;

	public Regle() {
		this(-1, "", "", false);
	}

	public Regle(String condition, String action, boolean actif) {
		this(-1, condition, action, actif);
	}

	public Regle(int id, String condition, String action, boolean actif) {
		this.id = id;
		this.setCond(condition);
		this.setAction(action);
		this.actif = actif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCond() {
		return condition;
	}

	public void setCond(String condition) {
		if ((condition != null) && (condition.trim().length() > 0)) {
			this.condition = condition.trim();
		} else
			throw new IllegalArgumentException("Saisir une condition correct");
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		if ((action != null) && (action.trim().length() > 0)) {
			this.action = action.trim();
		} else
			throw new IllegalArgumentException("Saisir une action correct");
	}

	public boolean getActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Regle [id=" + id + ", condition=" + condition + ", action=" + action + ", actif=" + actif + "]";
	}

}