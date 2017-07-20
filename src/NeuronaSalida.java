
import java.io.Serializable;

public class NeuronaSalida implements Serializable
{
    //private double bias = Math.random();
    private double pesosSalida[] = new double[4];
    private double valorOutput;
    private static final long serialVersionUID = -532424099070259384L;
    
    public void inicializarPesosSalida()
    {
        for(int i=0;i<this.pesosSalida.length;i++)
        {
            this.pesosSalida[i] = Math.random();
        }
        System.out.println("\n====PESOS DE SALIDA INICIALES====");
        for(int i=0;i<this.pesosSalida.length;i++)
        {
            System.out.print("["+this.pesosSalida[i]+"]");
        }
    }
    
    public double sumaPonderada(NeuronaOculta[] capaOculta, double bias)
    {
        double suma = 0;
        for(int i=0;i<this.pesosSalida.length;i++)
        {
            suma = suma + capaOculta[i].getValorProcesado()*this.pesosSalida[i];
        }
        return suma + bias;
    }
    
    public double sigmoide(double sumaPonderada)
    {
        double outputSigmoide = (1/( 1 + Math.pow(Math.E,(-1*sumaPonderada))));
        System.out.println("\nLa suma ponderada de la salida es: "+sumaPonderada);
        System.out.println("\nEl resultado de la sigmoide de salida es: "+outputSigmoide);
        return outputSigmoide;
    }
    
    public double desnormalizarSalida(double outputSigmoide)
    {
        return ((45-15)*outputSigmoide) + 15;
    }
    
    public void imprimirPesosSalida()
    {
        for(int i=0;i<this.pesosSalida.length;i++)
        {
            System.out.print("["+this.pesosSalida[i]+"]");
        }
    }

    /*public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }*/

    public double[] getPesosSalida() {
        return pesosSalida;
    }

    public void setPesosSalida(double[] pesosSalida) {
        this.pesosSalida = pesosSalida;
    }

    public double getValorOutput() {
        return valorOutput;
    }

    public void setValorOutput(double valorOutput) {
        this.valorOutput = valorOutput;
    }
}
