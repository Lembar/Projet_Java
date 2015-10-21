package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.IVue;
import model.metier.Employe;

public class Controler implements ActionListener {

	private IVue vue;
	private Employe modele;

	public void setVue(IVue vue) {
		this.vue = vue;
	}

	public Employe getModele() {
		return this.modele;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();

		if (str.equals("OK")) {
			this.modele = new Employe(this.vue.getIdSaisi(),
									this.vue.getNomSaisi(),
									this.vue.getPrenomSaisi());
			this.vue.afficheModele();
		}
	}
}
