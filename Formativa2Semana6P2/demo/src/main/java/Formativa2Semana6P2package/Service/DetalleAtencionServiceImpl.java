package Formativa2Semana6P2package.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa2Semana6P2package.Model.DetalleAtencion;
import Formativa2Semana6P2package.Repository.DetalleAtencionRepository;

import java.util.Optional;


@Service
public class DetalleAtencionServiceImpl implements DetalleAtencionService{
    @Autowired
    private DetalleAtencionRepository DetalleAtencionRepository;


    @Override
    public Optional<DetalleAtencion> getDetalleAtencionById(Long codigo) {
        return DetalleAtencionRepository.findById(codigo);
    }
    
    @Override
    public DetalleAtencion createDetalleAtencion(DetalleAtencion DetalleAtencion){
        return DetalleAtencionRepository.save(DetalleAtencion);
    }

}