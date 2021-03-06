package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;

public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                comandoReserva.getId_reserva(),
                comandoReserva.getCodigo(),
                comandoReserva.getPelicula(),
                comandoReserva.getFechaCreacion(),
                comandoReserva.getHoraCreacion(),
                comandoReserva.getFechaReserva(),
                comandoReserva.getHoraReserva(),
                comandoReserva.getNoPuesto(),
                comandoReserva.getId_usuario()
        );
    }

}
