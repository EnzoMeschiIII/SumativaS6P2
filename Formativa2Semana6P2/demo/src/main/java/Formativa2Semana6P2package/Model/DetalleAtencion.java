package Formativa2Semana6P2package.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "DetalleAtencion")
public class DetalleAtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name= "examenes")
    private String examenes;
    @Column(name= "valorExamen")
    private int valorExamen;
    @Column(name= "valorConsulta")
    private int valorConsulta;

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

    public String getExamenes()
    {
        return examenes;
    }

    public void setExamenes(String examenes)
    {
        this.examenes=examenes;
    }

    public int getValorExamen()
    {
       return valorExamen;
    }

    public void setValorExamen(int valorExamen)
    {
        this.valorExamen=valorExamen;
    }

    public int getValorConsulta()
    {
        return valorConsulta;
    }

    public void setValorConsulta(int valorConsulta)
    {
        this.valorConsulta=valorConsulta;
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
