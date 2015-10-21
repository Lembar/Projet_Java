package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controler.Controler;

public class FenetreEmploye extends JFrame implements IVue {

	private JTextField tId;
	private JTextField tNom;
	private JTextField tPrenom;
	private JTextField tRegle;
	private JTextField tVariable;
	private JLabel lObject;
	private Controler monControleur;

	public FenetreEmploye(Controler ctrl) {
		
	}

	@Override
	public int getIdSaisi() {
		int i = Integer.parseInt(this.tId.getText().trim());
		return i;
	}

	@Override
	public String getNomSaisi() {
		return this.tNom.getText().trim();
	}

	@Override
	public String getPrenomSaisi() {
		return this.tPrenom.getText().trim();
	}

	@Override
	public String getRegleSaisie() {
		return this.tRegle.getText().trim();
	}

	@Override
	public String getVariableSaisie() {
		return this.tVariable.getText().trim();
	}

	@Override
	public void afficheModele() {
		this.lObject.setText(this.monControleur.getModele().toString());
	}
	
	public FenetreV(Controler ctrl) {
		super("Ma fenetre MVC");
		this.monControleur = ctrl;
	}

}
