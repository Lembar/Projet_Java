package modele.metier;

import java.util.ArrayList;

public class Employe {
  private int id = 0;
  private String nom = "";
  private String prenom = "";
  private ArrayList<Regle> regle;
   

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
  
@Override
public String toString() {
	return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom
			+ ", regle=" + regle + "]";
}



}