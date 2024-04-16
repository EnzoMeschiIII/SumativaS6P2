package Formativa2Semana6P2package.Service;
import java.util.Optional;
import Formativa2Semana6P2package.Model.DetalleAtencion;


public interface DetalleAtencionService {
    Optional<DetalleAtencion> getDetalleAtencionById(Long codigo);
    DetalleAtencion createDetalleAtencion(DetalleAtencion detalleAtencion);
}
