package Formativa2Semana6P2package.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Formativa2Semana6P2package.Model.Paciente;

public interface PacienteRepository extends JpaRepository <Paciente, Long>{
    
}