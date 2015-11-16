package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vue.FenetreFichePaie;
public class ControlerFichePaie implements ActionListener, ListSelectionListener {

	private FenetreFichePaie vue;
	
	public void setVue(FenetreFichePaie vue) {
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (e.getValueIsAdjusting()) return;
		if (e.getFirstIndex()==1 && e.getLastIndex()==-1) {
			this.vue.activeBouton(false);
		} else { 
			this.vue.activeBouton(true);
		}
	}
}
