package vue;


import javax.swing.JFrame;
import javax.swing.JTextField;

public class VueEmploye extends JFrame implements IVue {

	  private JTextField tId;
	  private JTextField tNom;
	  private JTextField tPrenom;
	  private JTextField tRegle;
	  private JTextField tVariable;
	  
	  
	  public int getIdSaisi() {
		  int i= Integer.parseInt(this.tId.getText().trim());
		  return i;
	  }
	  
	  public String getNomSaisi() {
		  return this.tNom.getText().trim();
	  }
	  
	  public String getPrenomSaisi() {
		  return this.tPrenom.getText().trim();
	  }
	  
	  public String getRegleSaisie() {
		  return this.tRegle.getText().trim();
	  }
	  
	  public String getVariableSaisie() {
		  return this.tVariable.getText().trim();
	  }

	@Override
	public void AfficheModele() {
		
	}
}
	  
	  
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  


