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

import controler.ControlerRegle;

public class FenetreRegle extends JFrame implements IVueRegle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3050228884712473157L;
	private JTextField tConditionAjout;
	private JTextField tActionAjout;
	private JTextField tActifAjout;
	
	private JTextField tConditionModif;
	private JTextField tActionModif;
	private JTextField tActifModif;
	
	private JLabel lObject;
	private JLabel lTitle;
	private JLabel lCondition;
	private JLabel lAction;
	private JLabel lActif;

	private ControlerRegle monControleur;
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
	
	public FenetreRegle(ControlerRegle ctrl2) {
		
		// panel boutons//////////////////////////////////////////////////////
		panelBoutons = new JPanel();
		panelBoutons.setPreferredSize(new Dimension(100, 50));
		panelBoutons.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelBoutons.setBackground(Color.lightGray);

		// panel titre //////////////////////////////////////////////////////
		panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(100, 50));
		panelTitre.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelTitre.setBackground(Color.LIGHT_GRAY);
		Font fon = new Font("Arial", Font.BOLD, 35);
		lTitle = new JLabel("Règles");
		lTitle.setFont(fon);
		lTitle.setForeground(Color.white);
		panelTitre.add(lTitle);

		// panel principal //////////////////////////////////////////////////
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setLayout(new BorderLayout());

		// table /////////////////////////////////////////////////////////////
		table = new JTable(ctrl2.getListeRegles());
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(ctrl2);
		table.setSelectionModel(listSelectionModel);

		JScrollPane jsp = new JScrollPane(table);
		panelPrincipal.add(jsp, BorderLayout.WEST);

		// panel ajout //////////////////////////////////////////////////////
		panelAjout = new JPanel();
		btnValiderAjout = new JButton("Valider");

		panelAjout.setPreferredSize(new Dimension(200, 150));
		panelAjout.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelAjout.setBackground(Color.lightGray);

		tConditionAjout = new JTextField();
		tActionAjout = new JTextField();
		tActifAjout = new JTextField();
		lCondition = new JLabel("Condition:");
		lAction = new JLabel("Action:");
		lActif = new JLabel("Actif:");

		panelAjout.setLayout(null);
		lCondition.setBounds(10, 40, 50, 25);
		panelAjout.add(lCondition);
		lAction.setBounds(10, 70, 50, 25);
		panelAjout.add(lAction);
		lActif.setBounds(10, 100, 50, 25);
		panelAjout.add(lActif);
		tConditionAjout.setBounds(65, 40, 120, 25);
		panelAjout.add(tConditionAjout);
		tActionAjout.setBounds(65, 70, 120, 25);
		panelAjout.add(tActionAjout);
		tActifAjout.setBounds(65, 100, 120, 25);
		panelAjout.add(tActifAjout);
		btnValiderAjout.setBounds(58, 150, 90, 25);
		panelAjout.add(btnValiderAjout);

		panelPrincipal.add(panelAjout,BorderLayout.EAST);
		panelAjout.setVisible(false);

		// panel modifier
		// //////////////////////////////////////////////////////////////
		panelModifie = new JPanel();
		btnValiderModif = new JButton("OK");
		panelModifie.setPreferredSize(new Dimension(200, 150));
		panelModifie.setBorder(new javax.swing.border.BevelBorder(
				BevelBorder.RAISED));
		panelModifie.setBackground(Color.lightGray);

		tConditionModif = new JTextField();
		tActionModif = new JTextField();
		tActifModif = new JTextField();
		lCondition = new JLabel("Condition:");
		lAction = new JLabel("Action:");
		lActif = new JLabel("Actif:");
		
		panelModifie.setLayout(null);
		lCondition.setBounds(10, 40, 50, 25);
		panelModifie.add(lCondition);
		lAction.setBounds(10, 70, 50, 25);
		panelModifie.add(lAction);
		lActif.setBounds(10, 100, 50, 25);
		panelModifie.add(lActif);
		tConditionModif.setBounds(65, 40, 120, 25);
		panelModifie.add(tConditionModif);
		tActionModif.setBounds(65, 70, 120, 25);
		panelModifie.add(tActionModif);
		tActifModif.setBounds(65, 100, 120, 25);
		panelModifie.add(tActifModif);
		btnValiderModif.setBounds(58, 140, 90, 25);
		panelModifie.add(btnValiderModif);

		panelPrincipal.add(panelModifie);
		panelModifie.setVisible(false);

		// ajout panel sur la fenetre//////////////////////////////////////////////////////
		this.add(panelTitre, BorderLayout.NORTH);
		this.add(panelBoutons, BorderLayout.EAST);
		this.add(panelPrincipal, BorderLayout.CENTER);

		// ajout button //////////////////////////////////////////////////////
		btnAjoute = new JButton("Ajouter");
		btnModifie = new JButton("Modifier");
		btnSupprime = new JButton("Supprimer");
		

		btnAjoute.setPreferredSize(new Dimension(95,25));
		btnModifie.setPreferredSize(new Dimension(95,25));
		btnSupprime.setPreferredSize(new Dimension(95,25));
		
		
		panelBoutons.add(btnAjoute);
		panelBoutons.add(btnModifie);
		panelBoutons.add(btnSupprime);


		btnModifie.setEnabled(false);
		btnSupprime.setEnabled(false);

		btnAjoute.addActionListener(ctrl2);
		btnModifie.addActionListener(ctrl2);
		btnSupprime.addActionListener(ctrl2);
		btnValiderAjout.addActionListener(ctrl2);
		btnValiderModif.addActionListener(ctrl2);
		
		
		
		// Création fenetre
		this.setTitle("Règles");
		this.setSize(759, 550);
		this.setLocationRelativeTo(null);
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
	public String getConditionSaisie() {
		return this.tConditionAjout.getText().trim();
	}
	
	@Override
	public String getActionSaisie() {
		return this.tActionAjout.getText().trim();
	}
	
	@Override
	public int getActifSaisi() {
		int i = Integer.parseInt(this.tActifAjout.getText().trim());
		return i;
	}
	
	@Override
	public void afficheModele() {
		this.lObject.setText(this.monControleur.getModele().toString());
	}
	
	public void activeBouton(boolean a) {
		this.btnModifie.setEnabled(a);
		this.btnSupprime.setEnabled(a);

	}
	
	public void desactiveBouton() {
		this.btnModifie.setEnabled(false);
		this.btnSupprime.setEnabled(false);
	}

	
	public void getValeur(int i) {
		tConditionModif.setText((String) (table.getValueAt(i, 0)));
		tActionModif.setText((String) (table.getValueAt(i, 1)));
	//	tActifModif.setText((String) (table.getValueAt(i,2)));
		
	}
	
	public void supprimeTexte() {
		tConditionAjout.setText("");
		tActionAjout.setText("");
		tActifAjout.setText("");
	}
	
	@Override
	public String getConditionSaisieModif() {
		return this.tConditionModif.getText().trim();
	}

	@Override
	public String getActionSaisieModif() {
		return this.tActionModif.getText().trim();
	}
	
	@Override
	public int getActifSaisiModif() {
		int p = Integer.parseInt(this.tActifModif.getText().trim());
		return p;
	}
}
