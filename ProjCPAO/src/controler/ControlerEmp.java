package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import panels.EmployeModele;
import utils.DefaultValues;
import vue.FenetreEmploye;
import model.metier.Employe;

public class ControlerEmp implements ActionListener, ListSelectionListener {

	private FenetreEmploye vue;
	private Employe modele;
	private EmployeModele listeEmployes;
	
	public ControlerEmp(){
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
			this.vue.supprimeTexte();
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
			int b = this.vue.ligneSelect();			
			this.modele=this.listeEmployes.getEmploye(b);
			this.listeEmployes.deleteRow(b);	
			DefaultValues.getDefaultFactory().getEmployeDAO().delete(modele);
			break;
			
		case "Valider":
			System.out.println("Click valider");
			this.modele = new Employe(this.vue.getNomSaisi(),this.vue.getPrenomSaisi());
			this.listeEmployes.addRow(modele);
			DefaultValues.getDefaultFactory().getEmployeDAO().create(modele);			
			this.vue.invisiblePanelAjout();	
			this.vue.desactiveBouton();		
			break;
			
		case "OK":
			System.out.println("Click ok");
			int c = this.vue.ligneSelect();	
			this.modele=this.listeEmployes.getEmploye(c);
			modele.setNom(this.vue.getNomSaisiModif()); 			
			modele.setPrenom(this.vue.getPrenomSaisiModif()); 											
			DefaultValues.getDefaultFactory().getEmployeDAO().update(modele);
			this.vue.invisiblePanelModif();
			this.vue.desactiveBouton();
			break;
		case "R�gles":
			System.out.println("Click regle");
			this.vue.afficherRegle();
			break;
		case "Cotisation":
			System.out.println("Click Cotisation");
			this.vue.afficherCotisation();
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