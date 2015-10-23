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
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import utils.DefaultValues;
import model.metier.Employe;
import controler.Controler;

public class FenetreEmploye extends JFrame implements IVue {

	private JTextField tNomAjout;
	private JTextField tPrenomAjout;
	private JTextField tNomModif;
	private JTextField tPrenomModif;

	private JLabel lObject;
	private JLabel lTitle;
	private JLabel lNom;
	private JLabel lPrenom;

	private Controler monControleur;

	private JPanel panelBoutons;
	private JPanel panelTitre;
	private JPanel panelPrincipal;
	private JPanel panelAjout;
	private JPanel panelModifie;

	private JButton btnValiderAjout;
	private JButton btnValiderModif;
	private JButton btnModifie;
	private JButton btnSupprime;
	private JButton btnAjoute;
	

	private JTable table;

	public FenetreEmploye(Controler ctrl) {

		// panel boutons//////////////////////////////////////////////////////
		panelBoutons = new JPanel();
		panelBoutons.setPreferredSize(new Dimension(100, 50));
		panelBoutons.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelBoutons.setBackground(Color.BLACK);

		// panel titre //////////////////////////////////////////////////////
		panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(100, 50));
		panelTitre.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelTitre.setBackground(Color.BLACK);
		Font fon = new Font("Arial", Font.BOLD, 35);
		lTitle = new JLabel("Bienvenue");
		lTitle.setFont(fon);
		lTitle.setForeground(Color.white);
		panelTitre.add(lTitle);

		// panel principal //////////////////////////////////////////////////
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.gray);

		// table /////////////////////////////////////////////////////////////
		table = new JTable(ctrl.getListeEmployes());
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(ctrl);
		table.setSelectionModel(listSelectionModel);

		JScrollPane jsp = new JScrollPane(table);
		panelPrincipal.add(jsp);

		// panel ajout //////////////////////////////////////////////////////
		panelAjout = new JPanel();
		btnValiderAjout = new JButton("Valider");

		panelAjout.setPreferredSize(new Dimension(200, 150));
		panelAjout.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelAjout.setBackground(Color.white);

		tNomAjout = new JTextField();
		tPrenomAjout = new JTextField();
		lNom = new JLabel("Nom:");
		lPrenom = new JLabel("Prénom:");

		panelAjout.setLayout(null);
		lNom.setBounds(10, 70, 50, 25);
		panelAjout.add(lNom);
		lPrenom.setBounds(10, 40, 50, 25);
		panelAjout.add(lPrenom);
		tNomAjout.setBounds(65, 40, 120, 25);
		panelAjout.add(tNomAjout);
		tPrenomAjout.setBounds(65, 70, 120, 25);
		panelAjout.add(tPrenomAjout);
		btnValiderAjout.setBounds(58, 110, 90, 25);
		panelAjout.add(btnValiderAjout);

		panelPrincipal.add(panelAjout);
		panelAjout.setVisible(false);

		// panel modifier
		// //////////////////////////////////////////////////////////////
		panelModifie = new JPanel();
		btnValiderModif = new JButton("OK");
		panelModifie.setPreferredSize(new Dimension(200, 150));
		panelModifie.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelModifie.setBackground(Color.white);

		tNomModif = new JTextField();
		tPrenomModif = new JTextField();
		lNom = new JLabel("Nom:");
		lPrenom = new JLabel("Prénom:");

		panelModifie.setLayout(null);
		lNom.setBounds(10, 70, 50, 25);
		panelModifie.add(lNom);
		lPrenom.setBounds(10, 40, 50, 25);
		panelModifie.add(lPrenom);
		tNomModif.setBounds(65, 40, 120, 25);
		panelModifie.add(tNomModif);
		tPrenomModif.setBounds(65, 70, 120, 25);
		panelModifie.add(tPrenomModif);
		btnValiderModif.setBounds(58, 110, 90, 25);
		panelModifie.add(btnValiderModif);

		panelPrincipal.add(panelModifie);
		panelModifie.setVisible(false);

		// ajout panel sur la fenetre//////////////////////////////////////////////////////
		this.add(panelTitre, BorderLayout.NORTH);
		this.add(panelBoutons, BorderLayout.SOUTH);
		this.add(panelPrincipal, BorderLayout.CENTER);

		// ajout button //////////////////////////////////////////////////////
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
		btnValiderAjout.addActionListener(ctrl);
		btnValiderModif.addActionListener(ctrl);

		// this.pack();

		// Creation fenetre
		// //////////////////////////////////////////////////////
		this.setTitle("Java");
		this.setSize(1100, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void affichePanelAjout() {
		panelAjout.setVisible(true);
		panelModifie.setVisible(false);
	}
	
	public void invisiblePanelAjout() {
		panelAjout.setVisible(false);
	}


	public void affichePanelModifie() {
		panelModifie.setVisible(true);
		panelAjout.setVisible(false);
	}

	public void invisiblePanelModif() {
		panelModifie.setVisible(false);
	}
	
	public int ligneSelect() {
		return table.getSelectedRow();
	}

	@Override
	public String getNomSaisi() {
		return this.tNomAjout.getText().trim();
	}

	@Override
	public String getPrenomSaisi() {
		return this.tPrenomAjout.getText().trim();
	}

	@Override
	public void afficheModele() {
		this.lObject.setText(this.monControleur.getModele().toString());
	}

	public void activeBouton(boolean a) {
		this.btnModifie.setEnabled(a);
		this.btnSupprime.setEnabled(a);

	}

	public void getValeur(int i) {
		tNomAjout.setText((String) (table.getValueAt(i, 0)));
		tPrenomAjout.setText((String) (table.getValueAt(i, 1)));
	}

//	public void valideAjoutEmploye() {
//		Employe emp = new Employe(getNomSaisi(), getPrenomSaisi());
//		DefaultValues.getDefaultFactory().getEmployeDAO().create(emp);
//		monControleur.getListeEmployes().addRow(emp);
//	}
//
//	public void valideModificationEmploye() {
//		Employe emp = monControleur.getListeEmployes().getEmploye(
//				table.getSelectedRow());
//		emp.setNom(getNomSaisi());
//		emp.setPrenom(getPrenomSaisi());
//		DefaultValues.getDefaultFactory().getEmployeDAO().update(emp);
//
//	}
//	
//    public void supprimeEmploye() {
//        Employe emp = monControleur.getListeEmployes().getEmploye(table.getSelectedRow());
//        DefaultValues.getDefaultFactory().getEmployeDAO().delete(emp);
//}

}
