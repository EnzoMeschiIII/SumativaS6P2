package Formativa2Semana6P2package.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name= "motivoConsulta")
    private String motivoConsulta;
    @Column(name= "especialidad")
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;
    
     //Getter y Setters
     public Long getCodigo()
     {
         return codigo;
     }

     public void setCodigo(Long codigo)
     {
        this.codigo=codigo;
     }
 
     public String getMotivoConsulta()
     {
         return motivoConsulta;
     }

     public void setMotivoConsulta(String motivoConsulta)
     {
        this.motivoConsulta=motivoConsulta;
     }

     public String getEspecialidad()
     {
        return especialidad;
     }

     public void setEspecialidad(String especialidad)
     {
        this.especialidad=especialidad;
     }

     public Paciente getPaciente()
     {
         return paciente;
     }
 
     public void setPaciente(Paciente paciente)
     {
         this.paciente=paciente;
     }
}
