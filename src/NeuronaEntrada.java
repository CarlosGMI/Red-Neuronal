
import java.io.Serializable;

public class NeuronaEntrada implements Serializable
{
    private double entrada;
    private static final long serialVersionUID = 6064116028311586287L;
    
    public double normalizarTemperatura(double temperatura)
    {
        return (temperatura-15.0)/(45-15);
    }
    
    public double normalizarHumedad(double porcentajeHumedad)
    {
        return (porcentajeHumedad-0)/(100-0);
    }
    
    public double normalizarViento(double velocidad)
    {
        return (velocidad-1)/(50-1);
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }
}
