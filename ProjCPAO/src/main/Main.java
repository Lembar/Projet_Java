package main;

import vue.FenetreEmploye;
import controler.ControlerEmp;

public class Main {

	public static void main(String[] args) {
		ControlerEmp ctrl= new ControlerEmp();
		FenetreEmploye vueSwing = new FenetreEmploye(ctrl);
		
		ctrl.setVue(vueSwing);
	}

}
