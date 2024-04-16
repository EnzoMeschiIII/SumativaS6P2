package Formativa2Semana6P2package.Service;
import java.util.Optional;
import Formativa2Semana6P2package.Model.Consulta;


public interface ConsultaService {
    Optional<Consulta> getConsultaById(Long codigo);
    Consulta createConsulta(Consulta consulta);
}