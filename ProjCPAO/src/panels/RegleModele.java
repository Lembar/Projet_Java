package panels;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import model.metier.Employe;
import model.metier.Regle;

public class RegleModele extends AbstractTableModel {

	private ArrayList<Regle> listeReg;

	private final String[] COLONNES = { "Condition", "Action", "Actif" };

	public RegleModele(ArrayList<Regle> arrayList) {
		this.listeReg = arrayList;
	}

	@Override
	public int getColumnCount() {
		return this.COLONNES.length;
	}

	@Override
	public String getColumnName(int c) {
		return this.COLONNES[c];
	}

	@Override
	public int getRowCount() {
		return this.listeReg.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Regle reg = this.listeReg.get(rowIndex);
		Object obj = null;
		switch (columnIndex) {
		case 0:
			obj = reg.getCondition();
			break;
		case 1:
			obj = reg.getAction();
			break;
		case 2:
			obj = reg.getActif();
		}
		return obj;
	}

	public Regle getRegle(int index) {
		return listeReg.get(index);
	}

	public void addRow(Regle reg) {

		this.listeReg.add(reg);
		Collections.sort(this.listeReg);
		this.fireTableDataChanged();
	}

	public void deleteRow(int i) {
		this.listeReg.remove(i);
		Collections.sort(this.listeReg);
		this.fireTableDataChanged();
	}
}
