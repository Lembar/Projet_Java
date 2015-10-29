package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import panels.CotisationModele;
import panels.EmployeModele;
import model.metier.Cotisation;
import model.metier.Employe;
import utils.DefaultValues;
import vue.FenetreCotisation;
import vue.FenetreEmploye;


public class ControlerCotisation implements ActionListener, ListSelectionListener {

	private FenetreCotisation vue;
	private Cotisation modele;
	private CotisationModele listeCotisations;
	
	
	public ControlerCotisation(){
		listeCotisations = new CotisationModele(DefaultValues.getDefaultFactory().getCotisationDAO().findAll());
	}
	
	public void setVue(FenetreCotisation vue) {
		this.vue = vue;
	}

	public Cotisation getModele() {
		return this.modele;
	}

	
	public CotisationModele getListeCotisations() {
		return this.listeCotisations;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent c) {
		switch(c.getActionCommand()){
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
			this.modele=this.listeCotisations.getCotisation(b);
			this.listeCotisations.deleteRow(b);	
			DefaultValues.getDefaultFactory().getCotisationDAO().delete(modele);
			break;
			
		case "Valider":
			System.out.println("Click valider");
			this.modele = new Cotisation(this.vue.getCotisationSaisie(),this.vue.getTauxSaisi());
			this.listeCotisations.addRow(modele);
			DefaultValues.getDefaultFactory().getCotisationDAO().create(modele);			
			this.vue.invisiblePanelAjout();	
			this.vue.desactiveBouton();		
			break;
			
		case "OK":
			System.out.println("Click ok");
			int g = this.vue.ligneSelect();	
			this.modele=this.listeCotisations.getCotisation(g);
			modele.setLibelle(this.vue.getCotisationSaisieModif()); 			
			modele.setTaux(this.vue.getTauxSaisiModif()); 											
			DefaultValues.getDefaultFactory().getCotisationDAO().update(modele);
			this.vue.invisiblePanelModif();
			this.vue.desactiveBouton();		
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent c) {

		if (c.getValueIsAdjusting()) return;
		if (c.getFirstIndex()==1 && c.getLastIndex()==-1) {
			this.vue.activeBouton(false);
		} else { 
			this.vue.activeBouton(true);
		}
	}

}
