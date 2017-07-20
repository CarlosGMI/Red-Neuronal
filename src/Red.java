
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Red implements Serializable
{
    //transient Scanner sc = new Scanner(System.in);
    NeuronaEntrada capaEntrada[] = new NeuronaEntrada[3];
    NeuronaOculta capaOculta[] = new NeuronaOculta[4];
    NeuronaSalida capaSalida = new NeuronaSalida();
    private double pesosOcultos[];
    private double bias = 2.71; //El número de DIOS Math.E
    private double factorAprendizaje = 0.15; //11.15
    private double valorReal;
    private boolean primeraVez = false;
    ArchivoObjetos guardar = new ArchivoObjetos();
    private static final long serialVersionUID = 7049116601584915981L;
    
    public Red() throws IOException, Exception
    {
        this.inicializarCapaEntrada();
        this.inicializarCapaOculta();
        this.capaSalida.inicializarPesosSalida();
        //guardar.crearArchivo(this);
    }
    
    public void inicioPredecir(double tempMed, double humedad, double viento,JLabel exc, JLabel temp)
    {
        this.capaEntrada[0].setEntrada(this.capaEntrada[0].normalizarTemperatura(tempMed));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarHumedad(humedad));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarViento(viento));
        this.imprimirCapaEntrada();
        this.procesarInputs();
        this.imprimirCapaOculta();
        this.procesarOutputs();
        this.imprimirCapaSalida();
        DecimalFormat df = new DecimalFormat("#.#");
        temp.setText(df.format(this.capaSalida.getValorOutput()));
        exc.setVisible(true);
        temp.setVisible(true);
    }
    
    public void inicioEntrenar(double tempMed, double humedad, double viento, double valorPredecir, JTextArea noticias)
    {
        boolean aux = false;
        this.capaEntrada[0].setEntrada(this.capaEntrada[0].normalizarTemperatura(tempMed));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarHumedad(humedad));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarViento(viento));
        this.setValorReal(this.normalizarTemperaturaReal(valorPredecir));
        this.imprimirCapaEntrada();
        do
        {
            System.out.println("\n============================PROCESANDO VALORES============================");
            this.procesarInputs();
            this.imprimirCapaOculta();
            this.procesarOutputs();
            this.imprimirCapaSalida();
            noticias.setText("=====================");
            noticias.setText("Error: "+Double.toString(this.toleranciaError()));
            System.out.println("\n\nEL ERROR DESNORMALIZADO ES: "+this.toleranciaError());
            if((this.toleranciaError() < -0.5) || (this.toleranciaError() > 0.5))
            {
                System.out.println("\n============================ENTRENANDO LA RED============================");
                this.entrenarRed();
            }
            else if((this.toleranciaError() >= -0.5) && (this.toleranciaError() <= 0.5))
            {
                aux = true;
            }
        }
        while(aux == false);
    }
    
    
    public void bienvenida(Scanner sc) throws IOException
    {
        boolean ciclo = true;
        inputLoop: while(ciclo == true)
        {
            int opcion;
            System.out.println("\n=========Bienvenido a la red neuronal de predicción del clima en Caracas=========");
            System.out.println("Qué desea realizar?");
            System.out.println("1. Predecir el clima.");
            System.out.println("2. Entrenar la red neuronal.");
            //opcion = sc.nextInt();
            do
            {
                opcion = sc.nextInt();
                switch (opcion)
                {
                    case 1: 
                    {
                        ciclo = false;
                        break;
                    }
                    case 2:
                    {
                        boolean aux = false;
                        System.out.print("Introduzca la temperatura media (°C): ");
                        this.capaEntrada[0].setEntrada(this.capaEntrada[0].normalizarTemperatura(sc.nextDouble()));
                        System.out.print("Introduzca la humedad relativa media (%): ");
                        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarHumedad(sc.nextDouble()));
                        System.out.print("Introduzca la velocidad media del viento (km/h): ");
                        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarViento(sc.nextDouble()));
                        System.out.print("Introduzca la temperatura a predecir (°C): ");
                        this.setValorReal(this.normalizarTemperaturaReal(sc.nextDouble()));
                        this.imprimirCapaEntrada();
                        do
                        {
                            System.out.println("\n============================PROCESANDO VALORES============================");
                            this.procesarInputs();
                            this.imprimirCapaOculta();
                            this.procesarOutputs();
                            this.imprimirCapaSalida();
                            System.out.println("\n\nEL ERROR DESNORMALIZADO ES: "+this.toleranciaError());
                            if((this.toleranciaError() < -0.5) || (this.toleranciaError() > 0.5))
                            {
                                System.out.println("\n============================ENTRENANDO LA RED============================");
                                this.entrenarRed();
                            }
                            else if((this.toleranciaError() >= -0.5) && (this.toleranciaError() <= 0.5))
                            {
                                aux = true;
                            }
                        }
                        while(aux == false);
                        break;
                    }
                    default:
                    {
                        System.out.println("Presiona 1 o 2");
                        break;
                    }
                }
            }
            while(opcion != 1 && opcion != 2);
        }
    }
    
    public void imprimirCapaEntrada()
    {
        System.out.println("\n====CAPA DE ENTRADA====");
        for(int i=0;i<this.capaEntrada.length;i++)
        {
            System.out.print("["+this.capaEntrada[i].getEntrada()+"]");
        }
    }
    
    public void imprimirCapaOculta()
    {
        System.out.println("\n====CAPA OCULTA====");
        for(int i=0;i<this.capaOculta.length;i++)
        {
            System.out.print("["+this.capaOculta[i].getValorProcesado()+"]");
        }
    }
    
    public void imprimirCapaSalida()
    {
        System.out.println("\n====CAPA DE SALIDA====");
        System.out.print("["+this.capaSalida.getValorOutput()+"]");
    }
    
    public void inicializarCapaEntrada(/*NeuronaEntrada[] entradas*/)
    {
        //this.setCapaEntrada(entradas);
        for(int i=0;i<this.capaEntrada.length;i++)
        {
            this.capaEntrada[i] = new NeuronaEntrada();
        }
    }
    
    public void inicializarCapaOculta(/*NeuronaOculta[] ocultas*/)
    {
        //this.setCapaOculta(ocultas);
        System.out.println("EL BIAS EN ESTA RONDA ES: "+this.bias);
        for(int i=0;i<this.capaOculta.length;i++)
        {
            this.capaOculta[i] = new NeuronaOculta();
            this.capaOculta[i].inicializarPesosEntrada();
        }
    }
    
    public void imprimirPesosEntrada()
    {
        for(int i=0;i<this.capaOculta.length;i++)
        {
            for(int j=0;j<this.capaOculta[i].getPesosEntrada().length;j++)
            {
                System.out.println("["+this.capaOculta[i].getPesosEntrada()[j]+"]");
            }
        }
    }
    
    public void procesarInputs()
    {
        for(int i=0;i<this.capaOculta.length;i++)
        {
            this.capaOculta[i].setValorProcesado(this.capaOculta[i].sigmoide(this.capaOculta[i].sumaPonderada(capaEntrada,this.bias)));
        }
    }
    
    public void procesarOutputs()
    {
        this.capaSalida.setValorOutput(this.capaSalida.desnormalizarSalida(this.capaSalida.sigmoide(this.capaSalida.sumaPonderada(capaOculta,this.bias))));
    }
    
    public double normalizarTemperaturaReal(double temperaturaReal)
    {
        return (temperaturaReal-15.0)/(45-15);
    }
    
    public double toleranciaError()
    {
        //return (this.capaSalida.getValorOutput() - (((45-15)*this.getValorReal()) + 15))/(((45-15)*this.getValorReal()) + 15);
        //return Math.pow((((45-15)*this.getValorReal()) + 15) - this.capaSalida.getValorOutput(), 2)/2
        return this.capaSalida.getValorOutput() - (((45-15)*this.getValorReal()) + 15);
    }
    
    public void entrenarRed()
    {
        double error = this.getValorReal() - this.normalizarTemperaturaReal(this.capaSalida.getValorOutput());
        System.out.println("EL ERROR ES: "+error);
        this.cambiarPesosSalida(error);
        this.cambiarPesosOcultos(error);
        //double deltaSumaSalida = this.derivadaSigmoide(this.capaSalida.sumaPonderada(this.capaOculta, this.bias)) * error;
        //double pesosSalida[] = this.capaSalida.getPesosSalida();
        //this.calcularPesosDelta(deltaSumaSalida);
        //this.calcularPesosOcultos(deltaSumaSalida, pesosSalida);
    }
    
    public void cambiarPesosSalida(double error)
    {
        double cambio = 0;
        double pesosSalidaCalculados[] = new double[this.capaOculta.length];
        for(int i=0;i<this.capaOculta.length;i++)
        {
            pesosSalidaCalculados[i] = this.capaSalida.getPesosSalida()[i] + (this.factorAprendizaje*error*(this.normalizarTemperaturaReal(this.capaSalida.getValorOutput())*(1-this.normalizarTemperaturaReal(this.capaSalida.getValorOutput())))*this.capaOculta[i].sumaPonderada(this.capaEntrada, this.bias));
        }
        System.out.println("\n====PESOS DE SALIDA ANTERIORES====");
        this.capaSalida.imprimirPesosSalida();
        this.capaSalida.setPesosSalida(pesosSalidaCalculados);
        System.out.println("\n====PESOS DE SALIDA MODIFICADOS====");
        this.capaSalida.imprimirPesosSalida();
        //double cambio = error*(this.capaSalida.getValorOutput()*(1-this.capaSalida.getValorOutput()));
    }
    
    public void cambiarPesosOcultos(double error)
    {
        double cambioSalidaSumaSalida = error*(this.normalizarTemperaturaReal(this.capaSalida.getValorOutput())*(1-this.normalizarTemperaturaReal(this.capaSalida.getValorOutput()))); 
        System.out.println("\n=========PESOS ANTERIORES=========");
        this.imprimirPesosEntrada();
        for(int i=0;i<this.capaOculta.length;i++)
        {
            for(int j=0;j<this.capaOculta[i].getPesosEntrada().length;j++)
            {
                double cambioSumaSalidaValorOculta = this.capaOculta[i].getPesosEntrada()[j];
                double cambioSalidaValorOculta = cambioSalidaSumaSalida*cambioSumaSalidaValorOculta;
                double cambioValorOcultaSumaOculta = this.capaOculta[i].getValorProcesado()*(1-this.capaOculta[i].getValorProcesado());
                double cambioSumaOcultaPesoEntrada = this.capaEntrada[j].getEntrada();
                double cambioSalidaPesoEntrada = cambioSalidaValorOculta*cambioValorOcultaSumaOculta*cambioSumaOcultaPesoEntrada;
                this.capaOculta[i].getPesosEntrada()[j] = this.capaOculta[i].getPesosEntrada()[j] + (this.factorAprendizaje*cambioSalidaPesoEntrada);
            }
        }
        System.out.println("\n=========PESOS MODIFICADOS=========");
        this.imprimirPesosEntrada();
    }
    
    /*public double derivadaSigmoide(double valor)
    {
        return (Math.pow(Math.E, -1*valor))/(Math.pow((1+Math.pow(Math.E, -1*valor)), 2));
    }
    
    public void calcularPesosDelta(double deltaSumaSalida)
    {
        double[] pesosDelta = new double[this.capaOculta.length];
        double[] nuevosPesosSalida = new double[this.capaSalida.getPesosSalida().length];
        for(int i=0;i<pesosDelta.length;i++)
        {
            pesosDelta[i] = deltaSumaSalida/this.capaOculta[i].getValorProcesado();
        }
        for(int i=0;i<nuevosPesosSalida.length;i++)
        {
            nuevosPesosSalida[i] = this.capaSalida.getPesosSalida()[i] + pesosDelta[i];
        }
        System.out.println("\n====PESOS DE SALIDA ANTERIORES====");
        this.capaSalida.imprimirPesosSalida();
        this.capaSalida.setPesosSalida(nuevosPesosSalida);
        System.out.println("\n====PESOS DE SALIDA MODIFICADOS====");
        this.capaSalida.imprimirPesosSalida();
    }
    
    public double[] calcularSumaOcultaDelta(double deltaSumaSalida, double[] pesosSalida)
    {
        double sumaOcultaDelta[] = new double[pesosSalida.length];
        double vecAux[] = new double[pesosSalida.length];
        double vecAux2[] = new double[pesosSalida.length];
        for(int i=0;i<pesosSalida.length;i++)
        {
            vecAux[i] = deltaSumaSalida/pesosSalida[i];
        }
        for(int i=0;i<this.capaOculta.length;i++)
        {
            vecAux2[i] = this.derivadaSigmoide(this.capaOculta[i].sumaPonderada(this.capaEntrada, this.bias));
        }
        for(int i=0;i<vecAux.length;i++)
        {
            sumaOcultaDelta[i] = vecAux[i] * vecAux2[i];
        }
        return sumaOcultaDelta;
    }
    
    public void calcularPesosOcultos(double deltaSumaSalida, double[] pesosSalida)
    {
        double[] sumaOcultaDelta = this.calcularSumaOcultaDelta(deltaSumaSalida, pesosSalida);
        double[] pesosDelta = new double[sumaOcultaDelta.length*this.capaEntrada.length];
        double[] pesosDeltaCalculados = new double[pesosDelta.length];
        int cont = 0, i = 0;
        while(cont < pesosDelta.length)
        {
            for(int j=0;j<sumaOcultaDelta.length;j++)
            {
                pesosDelta[cont] = sumaOcultaDelta[j]/this.capaEntrada[i].getEntrada();
                cont++;
            }
            i++;
        }
        this.pesosOcultos();
        for(int x=0;x<this.pesosOcultos.length;x++)
        {
            pesosDeltaCalculados[x] = this.pesosOcultos[x] + pesosDelta[x];
        }
        System.out.println("\n====PESOS OCULTOS ANTERIORES====");
        for(int x=0;x<this.capaOculta.length;x++)
        {
            for(int y=0;y<this.capaOculta[x].getPesosEntrada().length;y++)
            {
                System.out.print("\nNeurona "+x+": ["+this.capaOculta[x].getPesosEntrada()[y]+"]");
            }
        }
        for(int x=0;x<this.capaOculta.length;x++)
        {
            this.capaOculta[x].setPesosEntrada(Arrays.copyOfRange(pesosDeltaCalculados, ((x)*(pesosDeltaCalculados.length/this.capaOculta.length)), ((x+1)*(pesosDeltaCalculados.length/this.capaOculta.length))));
        }
        System.out.println("\n====PESOS OCULTOS MODIFICADOS====");
        for(int x=0;x<this.capaOculta.length;x++)
        {
            for(int y=0;y<this.capaOculta[x].getPesosEntrada().length;y++)
            {
                System.out.print("\nNeurona "+x+": ["+this.capaOculta[x].getPesosEntrada()[y]+"]");
            }
        }
    }
    
    public void pesosOcultos()
    {
        this.pesosOcultos = new double[this.capaOculta.length*this.capaEntrada.length];
        int cont = 0;
        while(cont < pesosOcultos.length)
        {
            for(int i=0;i<this.capaOculta.length;i++)
            {
                for(int j=0;j<this.capaOculta[i].getPesosEntrada().length;j++)
                {
                    pesosOcultos[cont] = this.capaOculta[i].getPesosEntrada()[j];
                    cont++;
                }
            }
        }
    }*/

    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public boolean isPrimeraVez() {
        return primeraVez;
    }

    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public NeuronaEntrada[] getCapaEntrada() {
        return capaEntrada;
    }

    public void setCapaEntrada(NeuronaEntrada[] capaEntrada) {
        this.capaEntrada = capaEntrada;
    }

    public NeuronaOculta[] getCapaOculta() {
        return capaOculta;
    }

    public void setCapaOculta(NeuronaOculta[] capaOculta) {
        this.capaOculta = capaOculta;
    }

    public NeuronaSalida getCapaSalida() {
        return capaSalida;
    }

    public void setCapaSalida(NeuronaSalida capaSalida) {
        this.capaSalida = capaSalida;
    }
}
