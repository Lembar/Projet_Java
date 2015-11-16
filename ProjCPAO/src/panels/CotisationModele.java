package panels;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import model.metier.Cotisation;

public class CotisationModele  extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2954398350746156864L;

	private ArrayList<Cotisation> listeCotis;
	
	private final String[] COLONNES = { "Cotisation", "Taux" };
	
	public CotisationModele(ArrayList<Cotisation> arrayList) {
		this.listeCotis = arrayList;
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
		return this.listeCotis.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cotisation cot = this.listeCotis.get(rowIndex);
		Object obj = null;
		switch (columnIndex) {
		case 0:
			obj = cot.getLibelle();
			break;
		case 1:
			obj = cot.getTaux();
		}
		return obj;
	}
	
	public Cotisation getCotisation(int index) {
		return listeCotis.get(index);
	}
	
	public void addRow(Cotisation cot) {

		this.listeCotis.add(cot);
		Collections.sort(this.listeCotis);
		this.fireTableDataChanged();
	}
	
	public void deleteRow(int i) {
		this.listeCotis.remove(i);
		Collections.sort(this.listeCotis);
		this.fireTableDataChanged();
	}

}
