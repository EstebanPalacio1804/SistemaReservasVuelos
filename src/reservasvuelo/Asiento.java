package reservasvuelo;

public abstract class Asiento {
    private int numero;
    private boolean reservado;
    private String nombreReservante;

    public Asiento(int numero) {
        this.numero = numero;
        this.reservado = false;
        this.nombreReservante = "";
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public String getNombreReservante() {
        return nombreReservante;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        }
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void setNombreReservante(String nombreReservante) {
        if (nombreReservante != null && !nombreReservante.trim().isEmpty()) {
            this.nombreReservante = nombreReservante;
        } else {
            this.nombreReservante = "";
        }
    }

    public boolean reservar(String nombre) {
        if (!reservado && nombre != null && !nombre.trim().isEmpty()) {
            this.setReservado(true);
            this.setNombreReservante(nombre);
            return true;
        }
        return false;
    }

    public boolean cancelarReserva() {
        if (reservado) {
            this.setReservado(false);
            this.setNombreReservante("");
            return true;
        }
        return false;
    }

    public abstract String getTipoAsiento();
    public abstract double getPrecio();

    @Override
    public String toString() {
        if (reservado) {
            return "Asiento " + numero + " (" + getTipoAsiento() + ") - Reservado por: " + nombreReservante;
        } else {
            return "Asiento " + numero + " (" + getTipoAsiento() + ") - Libre";
        }
    }
}