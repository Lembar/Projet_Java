package vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	private JPanel boutons;
	private JPanel titre;
	private JPanel principal;

	private JButton valider;
	private JButton modifie;
	private JButton supprime;
	private JButton ajoute;

	public FenetreEmploye(Controler ctrl) {

		// Creation fenetre
		this.setTitle("Ma première fenêtre Java");
		this.setSize(1200, 800);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		// ajout des panels sur la fenetre
		//this.add(titre);
		//this.add(principal);
		this.add(boutons);
		
		// ajout button
		ajoute= new JButton("Ajouter");
		modifie= new JButton("Modifier");
		supprime= new JButton("Supprimer");
		valider= new JButton("Valider");
		boutons.add(ajoute);
		boutons.add(modifie);
		boutons.add(supprime);
		boutons.add(valider);
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

}
