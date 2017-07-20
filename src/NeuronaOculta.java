
import java.io.Serializable;

public class NeuronaOculta implements Serializable
{
    //private double bias = Math.random();
    private double pesosEntrada[] = new double[3];
    private double valorProcesado;
    private static final long serialVersionUID = -5872621466725055203L;
    
    public void hola()
    {
        System.out.println("hola");
    }
    
    public void inicializarPesosEntrada()
    {
        for(int i=0;i<this.pesosEntrada.length;i++)
        {
            this.pesosEntrada[i] = Math.random();
        }
        System.out.println("\n====PESOS OCULTOS INICIALES====");
        for(int i=0;i<this.pesosEntrada.length;i++)
        {
            System.out.print("["+this.pesosEntrada[i]+"]");
        }
    }
    
    public double sumaPonderada(NeuronaEntrada[] capaEntrada, double bias)
    {
        double suma = 0;
        for(int i=0;i<this.pesosEntrada.length;i++)
        {
            suma = suma + capaEntrada[i].getEntrada()*this.pesosEntrada[i];
        }
        return suma + bias;
    }
    
    public double sigmoide(double sumaPonderada)
    {
        double outputSigmoide = (1/( 1 + Math.pow(Math.E,(-1*sumaPonderada))));
        System.out.println("\nLa suma ponderada es: "+sumaPonderada);
        System.out.println("\nEl resultado de la sigmoide es: "+outputSigmoide);
        return outputSigmoide;
    }
    
    public void imprimirPesosOcultos()
    {
        System.out.println("\n====PESOS OCULTOS MODIFICADOS====");
        for(int i=0;i<this.pesosEntrada.length;i++)
        {
            System.out.print("["+this.pesosEntrada[i]+"]");
        }
    }

    /*public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }*/

    public double[] getPesosEntrada() {
        return pesosEntrada;
    }

    public void setPesosEntrada(double[] pesosEntrada) {
        this.pesosEntrada = pesosEntrada;
    }

    public double getValorProcesado() {
        return valorProcesado;
    }

    public void setValorProcesado(double valorProcesado) {
        this.valorProcesado = valorProcesado;
    }
}
