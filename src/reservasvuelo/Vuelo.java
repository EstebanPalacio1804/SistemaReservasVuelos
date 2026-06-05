package reservasvuelo;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private List<Asiento> asientos;

    public Vuelo(int totalAsientosEconomicos, int totalAsientosEjecutivos) {
        asientos = new ArrayList<>();
        int contador = 1;
        for (int i = 0; i < totalAsientosEconomicos; i++) {
            asientos.add(new AsientoEconomico(contador++));
        }
        for (int i = 0; i < totalAsientosEjecutivos; i++) {
            asientos.add(new AsientoEjecutivo(contador++));
        }
    }

    public boolean reservarAsiento(int numeroAsiento, String nombre) {
        for (Asiento a : asientos) {
            if (a.getNumero() == numeroAsiento) {
                return a.reservar(nombre);
            }
        }
        return false;
    }

    public boolean cancelarReserva(int numeroAsiento) {
        for (Asiento a : asientos) {
            if (a.getNumero() == numeroAsiento) {
                return a.cancelarReserva();
            }
        }
        return false;
    }

    public List<Asiento> getAsientosLibres() {
        List<Asiento> libres = new ArrayList<>();
        for (Asiento a : asientos) {
            if (!a.isReservado()) {
                libres.add(a);
            }
        }
        return libres;
    }

    public List<Asiento> getAsientosReservados() {
        List<Asiento> reservados = new ArrayList<>();
        for (Asiento a : asientos) {
            if (a.isReservado()) {
                reservados.add(a);
            }
        }
        return reservados;
    }

    public void reiniciarSistema() {
        for (Asiento a : asientos) {
            a.cancelarReserva();
        }
    }

    public List<Asiento> getTodosLosAsientos() {
        return new ArrayList<>(asientos);
    }
}