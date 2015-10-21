package main;

import vue.FenetreEmploye;
import controler.Controler;

public class Main {

	public static void main(String[] args) {
		Controler ctrl= new Controler();
		FenetreEmploye vueSwing = new FenetreEmploye(ctrl);
		
		ctrl.setVue(vueSwing);
	}

}
