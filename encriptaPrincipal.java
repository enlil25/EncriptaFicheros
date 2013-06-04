import javax.swing.*;
import java.awt.*;
import java.io.*;
public class encriptaPrincipal
{
	private JLabel lbl_password;
	private JPasswordField txtpass_password;
	private JPanel panel;
	
	private final static String imagenEntrada="CANDADO.JPG";
	private final static String ImagenOpciones="opcion1.jpg";
	public encriptaPrincipal()
	{
		lbl_password=new JLabel("clave para encriptar");
		txtpass_password=new JPasswordField(22);
		panel=new JPanel();
		
		//en panel
		panel.setLayout(new FlowLayout());
		panel.setBorder(BorderFactory.createEtchedBorder(1));
		panel.add(lbl_password);
		panel.add(txtpass_password);
	}
	
	private void entrada()
	{     
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage(imagenEntrada);
	    JOptionPane.showMessageDialog(null,"Bienvenido a encriptador v1.0","Encriptador v1.0",JOptionPane.INFORMATION_MESSAGE,
	     new ImageIcon( img.getScaledInstance(50,50,Image.SCALE_DEFAULT) ));
	}
	
	public void ejecutar() throws IOException
	{
		entrada();
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage(ImagenOpciones);
		
		String opcion=JOptionPane.showInputDialog(null,"Escoge una opcion disponible\n"
			+"1.-Encriptar archivo\n2.-Desencriptar archivo","Encriptador v1.0",
			JOptionPane.DEFAULT_OPTION);
	  
			
		if(opcion==null) return;	
		
		if(opcion.trim().equals("1"))
		{
			encriptar();
		}
		else if(opcion.trim().equals("2"))
		{
			desencriptar();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Opcion no valida");
			return;
		}			
	}	
	
	private void encriptar() throws IOException
	{
		lbl_password.setText("Clave para encriptar");
	   JOptionPane.showMessageDialog(null,panel);
	    JFileChooser chooser=new JFileChooser();
	    
	    //si no hay clave se termina el programa
	    if( new String(txtpass_password.getPassword()).length()==0)
	    {
	    	JOptionPane.showMessageDialog(null,"La clave es invalida\n"+
	    		"Escriba una clave valida");
	    	System.exit(0);
	    }	
	    
	    JOptionPane.showMessageDialog(null,"Selecciona fichero para encriptar");
	    int c=chooser.showOpenDialog(null);
	    //si se cieere el filechooser o se escoge cancelar
	    if(c==-1 || c==JFileChooser.CANCEL_OPTION) System.exit(0);
	    if(c==JFileChooser.APPROVE_OPTION)
	    {
	    	File fichero=chooser.getSelectedFile();
	    	    
	    	JOptionPane.showMessageDialog(null,"Fichero guardado correctamente\n"+
	    		"Selecciona carpeta de destino para guardar fichero encriptado\n"+
	    			"Recuerda siempre tu clave");
	    	
	    	   JFileChooser chooserS=new JFileChooser();
	    	   chooserS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	           int cs=chooserS.showSaveDialog(null);
	          
	           if(cs==-1 || cs==JFileChooser.CANCEL_OPTION) System.exit(0);
	           
	    	   if(cs==JFileChooser.APPROVE_OPTION)
	    	   { 
	    	   	 File directorio=chooserS.getSelectedFile();
	    	   	 encriptacion.encriptar(fichero.getAbsolutePath(),new String(txtpass_password.getPassword()),
	    	   	 directorio.getAbsolutePath());
	             JOptionPane.showMessageDialog(null,"fichero fue encriptado correctamente");
	    	   }
	      
   	        
	    }	
	}
	
	private void desencriptar() throws IOException
	{
		lbl_password.setText("Clave para desencriptar");
	  JOptionPane.showMessageDialog(null,panel);
	    JFileChooser chooser=new JFileChooser();
	    
	    //si no hay clave se termina el programa
	    if( new String(txtpass_password.getPassword()).length()==0)
	    {
	    	JOptionPane.showMessageDialog(null,"La clave es invalida\n"+
	    		"Escriba una clave valida");
	    	System.exit(0);
	    }	
	    
	    JOptionPane.showMessageDialog(null,"Selecciona fichero para desencriptar");
	    int c=chooser.showOpenDialog(null);
	    //si se cieere el filechooser o se escoge cancelar
	    if(c==-1 || c==JFileChooser.CANCEL_OPTION) System.exit(0);
	    if(c==JFileChooser.APPROVE_OPTION)
	    {
	    	File fichero=chooser.getSelectedFile();
	    	    
	    	JOptionPane.showMessageDialog(null,"Fichero guardado correctamente\n"+
	    		"Selecciona carpeta de destino para guardar fichero desencriptado\n"+
	    			"Recuerda siempre tu clave");
	    	
	    	   JFileChooser chooserS=new JFileChooser();
	    	   chooserS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	           int cs=chooserS.showSaveDialog(null);
	          
	           if(cs==-1 || cs==JFileChooser.CANCEL_OPTION) System.exit(0);
	           
	    	   if(cs==JFileChooser.APPROVE_OPTION)
	    	   { 
	    	   	 File directorio=chooserS.getSelectedFile();
	    	   	 encriptacion.desencriptar(fichero.getAbsolutePath(),new String(txtpass_password.getPassword()),
	    	   	 directorio.getAbsolutePath());
	             JOptionPane.showMessageDialog(null,"fichero fue desencriptado correctamente");
	    	   }
	      
   	        
	    }		
		
	}
	
	public static void main (String[] args) throws IOException{
  
  encriptaPrincipal obj=new encriptaPrincipal();
  obj.ejecutar();
  //String salida="C:/Users/Trabajos/Desktop/encriptados";
  //encriptacion.encriptar("fichero.java","cesar12345",null);
  //encriptacion.desencriptar("C:/Users/Trabajos/Desktop/encriptados/encriptado_1334794321269.java",null);  
  }	
			
}