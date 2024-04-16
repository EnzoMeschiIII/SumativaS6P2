package Formativa2Semana6P2package.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa2Semana6P2package.Model.Consulta;
import Formativa2Semana6P2package.Repository.ConsultaRepository;

import java.util.Optional;


@Service
public class ConsultaServiceImpl implements ConsultaService{
    @Autowired
    private ConsultaRepository consultaRepository;


    @Override
    public Optional<Consulta> getConsultaById(Long codigo) {
        return consultaRepository.findById(codigo);
    }
    
    @Override
    public Consulta createConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

}