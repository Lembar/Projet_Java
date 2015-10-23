package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import panels.EmployeModele;
import utils.DefaultValues;
import vue.FenetreEmploye;
import model.metier.Employe;

public class Controler implements ActionListener, ListSelectionListener {

	private FenetreEmploye vue;
	private Employe modele;
	private EmployeModele listeEmployes;
	
	public Controler(){
		listeEmployes = new EmployeModele(DefaultValues.getDefaultFactory().getEmployeDAO().findAll());
	}
	
	public void setVue(FenetreEmploye vue) {
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
			System.out.println("Click ajouter");
			this.vue.affichePanelAjout();
			break;
		case "Modifier":
			System.out.println("Click modifier");
			int i = this.vue.ligneSelect();
			this.vue.getValeur(i);
			this.vue.activeBouton(true);
			this.vue.affichePanelModifie();
			
			break;
		case "Supprimer":
			System.out.println("Click supprimer");
			this.vue.supprimeEmploye();
			break;
		case "Valider":
			System.out.println("Click valider");
			this.vue.valideAjoutEmploye();
			this.vue.valideModificationEmploye();
			break;
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (e.getValueIsAdjusting()) return;
		if (e.getFirstIndex()==1 && e.getLastIndex()==-1) {
			this.vue.activeBouton(false);
		} else { 
			this.vue.activeBouton(true);
		}
	}
}
