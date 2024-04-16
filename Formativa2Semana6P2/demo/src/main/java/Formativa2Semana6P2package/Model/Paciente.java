package Formativa2Semana6P2package.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "rut")
    private String rut;
    @Column(name = "telefono")
    private String telefono;
    @Column(name="medicoCabecera")
    private String medicoCabecera;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consulta;

     @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<DetalleAtencion> detalleAtencion;

    //Getter y Setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getRut()
    {
        return rut;
    }

    public void setRut(String rut)
    {
        this.rut=rut;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono=telefono;
    }

    public String getMedicoCabecera()
    {
        return medicoCabecera;
    }

    public void setMedicoCabecera(String medicoCabecera)
    {
        this.medicoCabecera=medicoCabecera;
    }

    public List<Consulta> getConsultas()
    {
        return consulta;
    }

    public void setConsultas(List<Consulta> consulta)
    {
        this.consulta = consulta;
    }

    public List<DetalleAtencion> getDetalleAtencion()
    {
        return detalleAtencion;
    }

    public void setDetalleAtencion(List<DetalleAtencion> detalleAtencion)
    {
        this.detalleAtencion=detalleAtencion;
    }
}
