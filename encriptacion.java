import java.io.*;

public class encriptacion
{
	
	public static void encriptar(String pathfile,String clave,String destino) throws IOException
	{
      File fi=null;
      File fi2=null; //fichero de escritura
      FileInputStream fis=null;
      FileOutputStream fos=null; //flujo de salida
      byte leidos[]=new byte[1024];
      int r=0;
   
      fi=new File(pathfile);
      
      //si destino==null
      if(destino==null)
      {	
      fi2=new File( "encriptado_"+ System.currentTimeMillis()+
   	  fi.getName().substring(fi.getName().lastIndexOf(".") ,fi.getName().length()) );
      }
      else  //sino si destino!=null
      {
      	 fi2=new File(destino+File.separator+"encriptado_"+ System.currentTimeMillis()+
   	   fi.getName().substring(fi.getName().lastIndexOf(".") ,fi.getName().length()) );
      }	
      fis=new FileInputStream(fi);
      fos=new FileOutputStream(fi2,false);
   
   while(  (r=fis.read(leidos))!=-1 )
   {
   	 byte salida[]=new byte[r];
   	  for(int i=0; i<r; i++)
   	  { 
   	  	
   	  	int enc=leidos[i]^getIntClave(clave); //encriptado
	    salida[i]=(byte)enc;
   	  }
   	  fos.write(salida,0,r);	
   }
   
   if(fis!=null) fis.close();
   if (fos!=null) fos.close();	
   	
	}
	
	public static void desencriptar(String pathfile,String clave,String destino) throws IOException
	{
		 File fi=null;
   File fi2=null; //fichero de escritura
   FileInputStream fis=null;
   FileOutputStream fos=null; //flujo de salida
   byte leidos[]=new byte[1024];
   int r=0;
   
   fi=new File(pathfile);
   if(destino==null)
      {	
      fi2=new File( "desencriptado_"+ System.currentTimeMillis()+
   	  fi.getName().substring(fi.getName().lastIndexOf(".") ,fi.getName().length()) );
      }
      else  //sino si destino!=null
      {
      	 fi2=new File(destino+File.separator+"desencriptado_"+ System.currentTimeMillis()+
   	   fi.getName().substring(fi.getName().lastIndexOf(".") ,fi.getName().length()) );
      }	
   fis=new FileInputStream(fi);
   fos=new FileOutputStream(fi2,false);
   
   while(  (r=fis.read(leidos))!=-1 )
   {
   	 byte salida[]=new byte[r];
   	  for(int i=0; i<r; i++)
   	  { 
   	  	int enc=leidos[i]^getIntClave(clave);
	    salida[i]=(byte)enc;
   	  }
   	  fos.write(salida,0,r);	
   }
   
   if(fis!=null) fis.close();
   if (fos!=null) fos.close();	
	}
	
private static int getIntClave(String clave)
{
	int salida=0;
	for(int i=0; i<clave.length(); i++)
	{
		char car=clave.charAt(i);
		salida+=(int)car;
	}
	return salida;	
}
					

}