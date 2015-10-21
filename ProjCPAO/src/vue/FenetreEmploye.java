package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controler.Controler;

public class FenetreEmploye extends JFrame implements IVue {

	private JTextField tId;
	private JTextField tNom;
	private JTextField tPrenom;
	private JTextField tRegle;
	private JTextField tVariable;
	private JLabel lObject;
	private JLabel title;
	private Controler monControleur;

	private JPanel panBoutons;
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
		this.setResizable(false);

		// ajout des panels sur la fenetre
		
		//panel boutons
		panBoutons = new JPanel();
		panBoutons.setPreferredSize(new Dimension(100, 50));
		panBoutons.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panBoutons.setBackground(Color.ORANGE);
		
		//panel titre
		titre = new JPanel();
		titre.setPreferredSize(new Dimension(100, 50));
		titre.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		titre.setBackground(Color.PINK);
		
		//panel principal
		principal = new JPanel();
		principal.setBackground(Color.yellow);
		
		
		
		this.add(titre, BorderLayout.NORTH);
		this.add(panBoutons, BorderLayout.SOUTH);		
		this.add(principal,BorderLayout.CENTER);		

		// ajout button
		ajoute = new JButton("Ajouter");
		modifie = new JButton("Modifier");
		supprime = new JButton("Supprimer");
		valider = new JButton("Valider");

		panBoutons.add(ajoute);
		panBoutons.add(modifie);
		panBoutons.add(supprime);
		panBoutons.add(valider);
		 


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
