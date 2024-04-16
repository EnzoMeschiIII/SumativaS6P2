package Formativa2Semana6P2package.Controller;

import Formativa2Semana6P2package.Model.Consulta;
import Formativa2Semana6P2package.Model.DetalleAtencion;
import Formativa2Semana6P2package.Model.Paciente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import java.util.Optional;
import Formativa2Semana6P2package.Service.PacienteService;
import Formativa2Semana6P2package.Service.ConsultaService;
import Formativa2Semana6P2package.Service.DetalleAtencionService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/pacientes")
public class PacienteController 
{
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private DetalleAtencionService detalleAtencionService;

    @GetMapping
    public List<Paciente> getAllPacientes(){
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> pacienteExiste = pacienteService.getPacienteById(id);

        if (pacienteExiste.isPresent()) {
            return ResponseEntity.ok(pacienteExiste.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create para cuando no hay nada

    @PostMapping
    public ResponseEntity<Paciente> createPaciente2(@RequestBody Paciente paciente) {

        if (paciente.getConsultas() != null) {
            for (Consulta consulta : paciente.getConsultas()) {
                // No es necesario verificar si la consulta existe, solo crearla
                Consulta nuevaConsulta = consultaService.createConsulta(consulta);
                if (nuevaConsulta == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }

        if (paciente.getDetalleAtencion() != null) {
            for (DetalleAtencion detalleAtencion : paciente.getDetalleAtencion()) {
                // No es necesario verificar si el detalle de atención existe, solo crearlo
                DetalleAtencion nuevoDetalleAtencion = detalleAtencionService.createDetalleAtencion(detalleAtencion);
                if (nuevoDetalleAtencion == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }

    Paciente nuevoPaciente = pacienteService.createPaciente(paciente);
    if (nuevoPaciente == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    return ResponseEntity.ok(nuevoPaciente);
    }


    // Create para cuando si existen

    /* 
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {

    Optional<Paciente> pacienteExiste = pacienteService.getPacienteById(paciente.getId());
    if (pacienteExiste.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    if (paciente.getConsultas() != null) {
        for (Consulta consulta : paciente.getConsultas()) {
            Optional<Consulta>consultaExiste = consultaService.getConsultaById(consulta.getCodigo());
            if (consultaExiste.isEmpty()) {
                Consulta nuevaConsulta = consultaService.createConsulta(consulta);
                if (nuevaConsulta == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }
    }

    if (paciente.getDetalleAtencion() != null) {
        for (DetalleAtencion detalleAtencion : paciente.getDetalleAtencion()) {
            Optional<DetalleAtencion> detalleAtencionExiste = detalleAtencionService.getDetalleAtencionById(detalleAtencion.getCodigo());
            if (detalleAtencionExiste.isEmpty()) {
                DetalleAtencion nuevoDetalleAtencion = detalleAtencionService.createDetalleAtencion(detalleAtencion);
                if (nuevoDetalleAtencion == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }
    }

    Paciente nuevoPaciente = pacienteService.createPaciente(paciente);
    if (nuevoPaciente == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    return ResponseEntity.ok(nuevoPaciente);
    }

    */

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Optional<Paciente> pacienteExiste = pacienteService.getPacienteById(id);
        if (!pacienteExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Paciente existente = pacienteExiste.get();
    
        existente.setNombre(paciente.getNombre());
        existente.setRut(paciente.getRut());
        existente.setTelefono(paciente.getTelefono());
        existente.setMedicoCabecera(paciente.getMedicoCabecera());
        existente.setConsultas(paciente.getConsultas());
        existente.setDetalleAtencion(paciente.getDetalleAtencion());
    
        Paciente updatePaciente = pacienteService.updatePaciente(id, existente);
        return ResponseEntity.ok(updatePaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteExiste = pacienteService.getPacienteById(id);
        if (!pacienteExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }
    
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

}
