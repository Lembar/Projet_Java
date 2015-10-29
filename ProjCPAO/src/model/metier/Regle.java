package model.metier;

public class Regle implements Comparable<Regle>{
	private int id = 0;
	private String condition = "";
	private String action = "";
	private int actif;

	public Regle() {
		this(-1, "Meh", "Meh",0);
	}

	public Regle(String condition, String action, int actif) {
		this(-1, condition, action, actif);
	}

	public Regle(int id, String condition, String action, int actif) {
		this.id = id;
		this.setCondition(condition);
		this.setAction(action);
		this.actif = actif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		if ((condition != null) && (condition.trim().length() > 0)) {
			this.condition = condition.trim();
		} else
			throw new IllegalArgumentException("Saisir une condition correcte");
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		if ((action != null) && (action.trim().length() > 0)) {
			this.action = action.trim();
		} else
			throw new IllegalArgumentException("Saisir une action correcte");
	}

	public int getActif() {
		return actif;
	}

	public void setActif(int actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Regle [id=" + id + ", condition=" + condition + ", action=" + action + ", actif=" + actif + "]";
	}

	@Override
	public int compareTo(Regle r) {
		if (condition.equals(r.condition)){
			return action.compareTo(r.action);
		}
		return condition.compareTo(r.action);
	}

}