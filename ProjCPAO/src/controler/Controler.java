package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panels.EmployeModele;
import utils.DefaultValues;
import vue.FenetreEmploye;
import vue.IVue;
import model.metier.Employe;

public class Controler implements ActionListener {

	private IVue vue;
	private Employe modele;
	private EmployeModele listeEmployes;
	
	public Controler(){
		listeEmployes = new EmployeModele(DefaultValues.getDefaultFactory().getEmployeDAO().findAll());
	}
	
	public void setVue(IVue vue) {
		this.vue = vue;
	}

	public Employe getModele() {
		return this.modele;
	}

	
	public EmployeModele getListeEmployes() {
		return this.listeEmployes;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch(ae.getActionCommand()){
		case "Ajouter":
			FenetreEmploye.affichePanelAjout();
			break;
		case "Modifier":
			FenetreEmploye.affichePanelModifie();
			break;
		case "Supprimer":
			System.out.println("Click supprimer");
			break;
		case "Valider":
			System.out.println("Click valider");
			break;
		}
	}
}
