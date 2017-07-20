
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ArchivoObjetos implements Serializable
{
    public void crearArchivo(Red red) throws FileNotFoundException, IOException
    {
        ObjectOutputStream Ooutput = new ObjectOutputStream (new FileOutputStream ("Rede.DAT"));
        Ooutput.writeObject(red);
        Ooutput.close();
        System.out.println("GUARDÉ EL ARCHIVO");
    }
    
    public Object capturarArchivo() throws Exception
    {
        Object red;
        ObjectInputStream oInput = new ObjectInputStream (new FileInputStream ("Rede.DAT"));
        red = oInput.readObject();
        oInput.close();
        System.out.println("LEÍ EL ARCHIVO");
        return red;
    }
}
