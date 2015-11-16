package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controler.ControlerFichePaie;

public class FenetreFichePaie extends JFrame implements IVueFichePaie {

	private static final long serialVersionUID = -6622882927352035659L;
	private JLabel lTitle;

	private JPanel panelBoutons;
	private JPanel panelTitre;
	private JPanel panelPrincipal;

	private JButton btnModifie;
	private JButton btnSupprime;
	private JButton btnRegle;
	private JButton btnCotisation;

	public FenetreFichePaie(ControlerFichePaie ctrl) {

		// panel boutons//////////////////////////////////////////////////////
		panelBoutons = new JPanel();
		panelBoutons.setPreferredSize(new Dimension(100, 50));
		panelBoutons.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		panelBoutons.setBackground(Color.lightGray);

		// panel titre //////////////////////////////////////////////////////
		panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(100, 50));
		panelTitre.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		panelTitre.setBackground(Color.LIGHT_GRAY);
		Font fon = new Font("Arial", Font.BOLD, 35);
		lTitle = new JLabel("Employés");
		lTitle.setFont(fon);
		lTitle.setForeground(Color.white);
		panelTitre.add(lTitle);

		// panel principal //////////////////////////////////////////////////
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.white);
		panelPrincipal.setLayout(new BorderLayout());

		// ajout button //////////////////////////////////////////////////////
		btnRegle = new JButton("Règles");
		btnCotisation = new JButton("Cotisation");

		btnRegle.setPreferredSize(new Dimension(95, 25));
		btnCotisation.setPreferredSize(new Dimension(95, 25));

		panelBoutons.add(btnRegle);
		panelBoutons.add(btnCotisation);

		btnRegle.addActionListener(ctrl);
		btnCotisation.addActionListener(ctrl);

		// Creation fenetre		/////////////////////////////////////////////
		this.setTitle("Fiche de paie");
		this.setSize(759, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void activeBouton(boolean a) {
		this.btnModifie.setEnabled(a);
		this.btnSupprime.setEnabled(a);

	}

	public void desactiveBouton() {
		this.btnModifie.setEnabled(false);
		this.btnSupprime.setEnabled(false);
	}

	@Override
	public void afficheModele() {
		// TODO Auto-generated method stub

	}

}
