package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.metier.Regle;
import panels.RegleModele;
import utils.DefaultValues;
import vue.FenetreRegle;

public class ControlerRegle implements ActionListener, ListSelectionListener {

	private FenetreRegle vue;
	private Regle modele;
	private RegleModele listeRegles;

	public ControlerRegle() {
		listeRegles = new RegleModele(DefaultValues.getDefaultFactory().getRegleDAO().findAll());
	}

	public void setVue(FenetreRegle vue) {
		this.vue = vue;
	}

	public Regle getModele() {
		return this.modele;
	}

	public RegleModele getListeRegles() {
		return this.listeRegles;
	}

	@Override
	public void actionPerformed(ActionEvent ae2) {
		switch (ae2.getActionCommand()) {
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
			this.modele = this.listeRegles.getRegle(b);
			this.listeRegles.deleteRow(b);
			DefaultValues.getDefaultFactory().getRegleDAO().delete(modele);
			break;

		case "Valider":
			System.out.println("Click valider");
			this.modele = new Regle(this.vue.getConditionSaisie(),
					this.vue.getActionSaisie(), this.vue.getActifSaisi());
			this.listeRegles.addRow(modele);
			DefaultValues.getDefaultFactory().getRegleDAO().create(modele);
			this.vue.invisiblePanelAjout();
			this.vue.desactiveBouton();
			break;

		case "OK":
			System.out.println("Click ok");
			int c = this.vue.ligneSelect();
			this.modele = this.listeRegles.getRegle(c);
			modele.setCondition(this.vue.getConditionSaisieModif());
			modele.setAction(this.vue.getActionSaisieModif());
			modele.setActif(this.vue.getActifSaisiModif());
			DefaultValues.getDefaultFactory().getRegleDAO().update(modele);
			this.vue.invisiblePanelModif();
			this.vue.desactiveBouton();
			break;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent r) {
		{
			
			if (r.getValueIsAdjusting()) return;
			if (r.getFirstIndex()==1 && r.getLastIndex()==-1) {
				this.vue.activeBouton(false);
			} else { 
				this.vue.activeBouton(true);
			}
		}

	}
}
