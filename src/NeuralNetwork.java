
import java.io.IOException;
import java.util.Scanner;

public class NeuralNetwork 
{
    Red cerebro = new Red();
    ArchivoObjetos guardar;
    private boolean primeraVez = false;
    
    public NeuralNetwork() throws IOException, Exception
    {
        this.guardar = new ArchivoObjetos();
        //this.guardar.crearArchivo(cerebro);
        this.cerebro = (Red)guardar.capturarArchivo();
    }
    
    public void inicializacion()
    {
        if(cerebro.isPrimeraVez() == true)
        {
            return;
        }
        else
        {
            //cerebro.inicializarCapaEntrada();
            //cerebro.inicializarCapaOculta();
            cerebro.capaSalida.inicializarPesosSalida();
            cerebro.setPrimeraVez(true);
        }   
    }
    
    public void ejecucion(Scanner sc) throws IOException, Exception
    {
        //Red cerebro = (Red) guardar.capturarArchivo();
        this.inicializacion();
        cerebro.bienvenida(sc);
        guardar.crearArchivo(cerebro);
    }

    public Red getCerebro() {
        return cerebro;
    }

    public void setCerebro(Red cerebro) {
        this.cerebro = cerebro;
    }
    
    public static void main(String[] args) throws IOException, Exception 
    {
        Scanner sc = new Scanner(System.in);
        NeuralNetwork app = new NeuralNetwork();
        app.ejecucion(sc);
        app.guardar.crearArchivo(app.getCerebro());
    }
}
