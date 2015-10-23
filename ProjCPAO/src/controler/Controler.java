package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.EmployeDAO;
import panels.EmployeModele;
import vue.IVue;
import model.metier.Employe;

public class Controler implements ActionListener {

	private IVue vue;
	private Employe modele;
	private EmployeModele listeEmployes;
	
	public Controler(){
		listeEmployes = new EmployeModele(EmployeDAO);
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
			Employe emp = new Employe(vue.getIdSaisi(),vue.getNomSaisi(),vue.getPrenomSaisi());
			
			break;
		case "Modifier":
			break;
		case "Supprimer":
			break;
		case "Valider":
			break;
		}
	}
}
