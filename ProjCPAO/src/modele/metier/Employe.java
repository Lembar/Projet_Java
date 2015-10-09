package modele.metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Employe {
  private int id = 0;
  private String nom = "";
  private String prenom = "";
  private ArrayList<Regle> regle;
  HashMap<Variable,String> hm=new HashMap<Variable,String>();
   

  public Employe(int id, String nom, String prenom, ArrayList<Regle> regle) {  
	this.id = id;
	this.setNom(nom);
	this.setPrenom(prenom);
	this.regle = regle;
}
  
  public Employe(String nom, String prenom, ArrayList<Regle> regle) {
	this(-1,nom,prenom,regle);

}  
  
public Employe(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
	  if ((nom!=null)&&(nom.trim().length()>0)) {
		  this.nom = nom.trim();
	  }
	  else throw new IllegalArgumentException("Saisir un nom correct");  
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
	  if ((prenom!=null)&&(prenom.trim().length()>0)) {
		  this.prenom = prenom.trim();
	  }
	  else throw new IllegalArgumentException("Saisir un prenom correct"); 
  }

public ArrayList<Regle> getRegle() {
	return regle;
}

public void setRegle(ArrayList<Regle> regle) {
	this.regle = regle;
}

  
public HashMap<Variable, String> getHm() {
	return hm;
}

public void setHm(HashMap<Variable, String> hm) {
	this.hm = hm;
}


@Override
public String toString() {
	return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom
			+ ", regle=" + regle + ", hm=" + hm + "]";
}




}