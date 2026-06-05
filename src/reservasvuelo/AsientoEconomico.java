package reservasvuelo;

public class AsientoEconomico extends Asiento {
    private boolean tieneComidaIncluida;
    private double precioBase;

    public AsientoEconomico(int numero) {
        super(numero);
        this.tieneComidaIncluida = false;
        this.precioBase = 150000;
    }

    @Override
    public String getTipoAsiento() {
        return "Economico";
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    public boolean isTieneComidaIncluida() {
        return tieneComidaIncluida;
    }

    public void setTieneComidaIncluida(boolean tieneComidaIncluida) {
        this.tieneComidaIncluida = tieneComidaIncluida;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        }
    }

    @Override
    public String toString() {
        return super.toString() + (tieneComidaIncluida ? " (Con comida)" : " (Sin comida)");
    }
}