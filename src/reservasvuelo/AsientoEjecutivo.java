package reservasvuelo;

public class AsientoEjecutivo extends Asiento {
    private boolean tieneSalaVip;
    private boolean tieneBebidasIlimitadas;
    private double precioBase;

    public AsientoEjecutivo(int numero) {
        super(numero);
        this.tieneSalaVip = true;
        this.tieneBebidasIlimitadas = true;
        this.precioBase = 450000;
    }

    @Override
    public String getTipoAsiento() {
        return "Ejecutivo";
    }

    @Override
    public double getPrecio() {
        double precioFinal = precioBase;
        if (tieneSalaVip) {
            precioFinal += 80000;
        }
        if (tieneBebidasIlimitadas) {
            precioFinal += 50000;
        }
        return precioFinal;
    }

    public boolean isTieneSalaVip() {
        return tieneSalaVip;
    }

    public void setTieneSalaVip(boolean tieneSalaVip) {
        this.tieneSalaVip = tieneSalaVip;
    }

    public boolean isTieneBebidasIlimitadas() {
        return tieneBebidasIlimitadas;
    }

    public void setTieneBebidasIlimitadas(boolean tieneBebidasIlimitadas) {
        this.tieneBebidasIlimitadas = tieneBebidasIlimitadas;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        }
    }

    @Override
    public String toString() {
        String beneficios = "";
        if (tieneSalaVip) beneficios += " Sala VIP";
        if (tieneBebidasIlimitadas) beneficios += " Bebidas Ilimitadas";
        return super.toString() + " (" + beneficios.trim() + ")";
    }
}