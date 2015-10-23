package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controler.Controler;

public class FenetreEmploye extends JFrame implements IVue {

	private JTextField tNom;
	private JTextField tPrenom;

	private JLabel lObject;
	private JLabel lTitle;
	private JLabel lNom;
	private JLabel lPrenom;

	private Controler monControleur;

	private JPanel panelBoutons;
	private JPanel panelTitre;
	private JPanel panelPrincipal;
	private static JPanel panelAjout;
	private static JPanel panelModifie;

	private JButton btnValider;
	private JButton btnModifie;
	private JButton btnSupprime;
	private JButton btnAjoute;

	public FenetreEmploye(Controler ctrl) {

		// panel boutons//////////////////////////////////////////////////////
		panelBoutons = new JPanel();
		panelBoutons.setPreferredSize(new Dimension(100, 50));
		panelBoutons.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelBoutons.setBackground(Color.ORANGE);

		// panel titre //////////////////////////////////////////////////////
		panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(100, 50));
		panelTitre.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelTitre.setBackground(Color.PINK);
		Font fon = new Font("Arial", Font.BOLD, 35);
		lTitle = new JLabel("Bienvenue");
		lTitle.setFont(fon);
		panelTitre.add(lTitle);

		// panel principal //////////////////////////////////////////////////
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.yellow);

		//table /////////////////////////////////////////////////////////////
		JTable table = new JTable(ctrl.getListeEmployes());
		JScrollPane jsp = new JScrollPane(table);
		panelPrincipal.add(jsp);

		// panel ajout //////////////////////////////////////////////////////
		panelAjout = new JPanel();
		btnValider = new JButton("Valider");
		
		panelAjout.setPreferredSize(new Dimension(200, 150));
		panelAjout.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelAjout.setBackground(Color.GREEN);

		
		tNom = new JTextField();
		tPrenom = new JTextField();
		lNom = new JLabel("Nom:");
		lPrenom = new JLabel("Prénom:");
		
	    panelAjout.setLayout(null);
		lNom.setBounds(10, 70, 50, 25);
		panelAjout.add(lNom);
		lPrenom.setBounds(10, 40, 50, 25);
		panelAjout.add(lPrenom);
		tNom.setBounds(65, 40, 120, 25);
		panelAjout.add(tNom);
		tPrenom.setBounds(65, 70, 120, 25);
		panelAjout.add(tPrenom); 
		btnValider.setBounds(58, 110, 90, 25);
		panelAjout.add(btnValider);

		panelPrincipal.add(panelAjout);
		panelAjout.setVisible(false);

		// panel modifier //////////////////////////////////////////////////////////////
		panelModifie = new JPanel();
		btnValider = new JButton("Valider");
		panelModifie.setPreferredSize(new Dimension(200, 150));
		panelModifie.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelModifie.setBackground(Color.RED);

		tNom = new JTextField();
		tPrenom = new JTextField();
		lNom = new JLabel("Nom:");
		lPrenom = new JLabel("Prénom:");

		panelModifie.setLayout(null);
		lNom.setBounds(10, 70, 50, 25);
		panelModifie.add(lNom);
		lPrenom.setBounds(10, 40, 50, 25);
		panelModifie.add(lPrenom);
		tNom.setBounds(65, 40, 120, 25);
		panelModifie.add(tNom);
		tPrenom.setBounds(65, 70, 120, 25);
		panelModifie.add(tPrenom);
		btnValider.setBounds(58, 110, 90, 25);
		panelModifie.add(btnValider);

		panelPrincipal.add(panelModifie);
		panelModifie.setVisible(false);

		// ajout panel sur la fenetre//////////////////////////////////////////////////////
		this.add(panelTitre, BorderLayout.NORTH);
		this.add(panelBoutons, BorderLayout.SOUTH);
		this.add(panelPrincipal, BorderLayout.CENTER);

		// ajout button	//////////////////////////////////////////////////////
		btnAjoute = new JButton("Ajouter");
		btnModifie = new JButton("Modifier");
		btnSupprime = new JButton("Supprimer");

		panelBoutons.add(btnAjoute);
		panelBoutons.add(btnModifie);
		panelBoutons.add(btnSupprime);
		
		btnModifie.setEnabled(false);
		btnSupprime.setEnabled(false);

		btnAjoute.addActionListener(ctrl);
		btnModifie.addActionListener(ctrl);
		btnSupprime.addActionListener(ctrl);
		btnValider.addActionListener(ctrl);
		
		// this.pack();

		// Creation fenetre //////////////////////////////////////////////////////
		this.setTitle("Java");
		this.setSize(1100, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void affichePanelAjout() {
		panelAjout.setVisible(true);
		panelModifie.setVisible(false);
	}
	
	public static void affichePanelModifie() {
		panelModifie.setVisible(true);
		panelAjout.setVisible(false);
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
	public void afficheModele() {
		this.lObject.setText(this.monControleur.getModele().toString());
	}

}
