package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.IVue;
import model.metier.Employe;

public class Controler implements ActionListener {

	private IVue vue;
	private Employe model;

	public void setVue(IVue vue) {
		this.vue = vue;
	}

	public Employe getEmploye() {
		return this.model;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();

		if (str.equals("OK")) {
			this.model = new Employe(this.vue.getNomSaisi(),
					this.vue.getPrenomSaisi());
			this.vue.afficheModele();
		}
	}
}
