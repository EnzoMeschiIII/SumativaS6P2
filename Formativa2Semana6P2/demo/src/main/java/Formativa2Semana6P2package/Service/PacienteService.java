package Formativa2Semana6P2package.Service;
import java.util.List;
import java.util.Optional;
import Formativa2Semana6P2package.Model.Paciente;


public interface PacienteService {
    List<Paciente> getAllPacientes();
    Optional<Paciente> getPacienteById(Long id);
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Long id, Paciente paciente);
    void deletePaciente(Long id);
}