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

import controler.ControlerCotisation;

public class FenetreCotisation extends JFrame implements IVueCotisation  {

	private JTextField tCotisAjout;
	private JTextField tTauxAjout;
	private JTextField tCotisModif;
	private JTextField tTauxModif;

	private JLabel lObject;
	private JLabel lTitle;
	private JLabel lCotis;
	private JLabel lTaux;

	private ControlerCotisation monControleur;

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

	public FenetreCotisation(ControlerCotisation ctrl3) {

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
		lTitle = new JLabel("Cotisations");
		lTitle.setFont(fon);
		lTitle.setForeground(Color.white);
		panelTitre.add(lTitle);

		// panel principal //////////////////////////////////////////////////
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setLayout(new BorderLayout());

		// table /////////////////////////////////////////////////////////////
		table = new JTable(ctrl3.getListeCotisations());
		ListSelectionModel listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(ctrl3);
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

		tCotisAjout = new JTextField();
		tTauxAjout = new JTextField();
		lCotis = new JLabel("Cotisation:");
		lTaux = new JLabel("Taux:");

		panelAjout.setLayout(null);
		lCotis.setBounds(10, 40, 50, 25);
		panelAjout.add(lCotis);
		lTaux.setBounds(10, 70, 50, 25);
		panelAjout.add(lTaux);
		tCotisAjout.setBounds(65, 40, 120, 25);
		panelAjout.add(tCotisAjout);
		tTauxAjout.setBounds(65, 70, 120, 25);
		panelAjout.add(tTauxAjout);
		btnValiderAjout.setBounds(58, 110, 90, 25);
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

		tCotisModif = new JTextField();
		tTauxModif = new JTextField();
		lCotis = new JLabel("Cotisation:");
		lTaux = new JLabel("Taux:");

		panelModifie.setLayout(null);
		lCotis.setBounds(10, 40, 50, 25);
		panelModifie.add(lCotis);
		lTaux.setBounds(10, 70, 50, 25);
		panelModifie.add(lTaux);
		tCotisModif.setBounds(65, 40, 120, 25);
		panelModifie.add(tCotisModif);
		tTauxModif.setBounds(65, 70, 120, 25);
		panelModifie.add(tTauxModif);
		btnValiderModif.setBounds(58, 110, 90, 25);
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

		btnAjoute.addActionListener(ctrl3);
		btnModifie.addActionListener(ctrl3);
		btnSupprime.addActionListener(ctrl3);
		btnValiderAjout.addActionListener(ctrl3);
		btnValiderModif.addActionListener(ctrl3);


		// Creation fenetre  //////////////////////////////////////////////////////
		this.setTitle("Java");
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
	public String getCotisationSaisie() {
		return this.tCotisAjout.getText().trim();
	}

	@Override
	public int getTauxSaisi() {	
		int i = Integer.parseInt(this.tTauxAjout.getText().trim());
		return i;
	}
	
	@Override
	public String getCotisationSaisieModif() {
		return this.tCotisModif.getText().trim();
	}

	@Override
	public int  getTauxSaisiModif() {
		int i = Integer.parseInt(this.tTauxModif.getText().trim());
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
	
	public void supprimeTexte() {
		tCotisAjout.setText("");
		tTauxAjout.setText("");
	}
	
	public void desactiveBouton() {
		this.btnModifie.setEnabled(false);
		this.btnSupprime.setEnabled(false);
	}

	public void getValeur(int i) {
		tCotisModif.setText((String) (table.getValueAt(i, 0)));
		//tTauxModif.setText((String) (table.getValueAt(i, 1)));  // PB ICI
	}
	
	
}
