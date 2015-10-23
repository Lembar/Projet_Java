package panels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.metier.Employe;

public class EmployeModele extends AbstractTableModel {

	private ArrayList<Employe> listeEmp;

	private final String[] COLONNES = { "Nom", "Prénom" };

	public EmployeModele(ArrayList<Employe> arrayList) {
		this.listeEmp = arrayList;
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
		return this.listeEmp.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employe emp = this.listeEmp.get(rowIndex);
		Object obj = null;
		switch (columnIndex) {
		case 0:
			obj = emp.getNom();
			break;
		case 1:
			obj = emp.getPrenom();
		}
		return obj;
	}

	public void addRow(Employe emp) {

		this.listeEmp.add(emp);
	//	Collections.sort(this.listeEmp);

		this.fireTableDataChanged();
	}

}
