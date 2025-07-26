package model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "sesiones")
public class Sesion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "dolorInicial")
    private String dolorInicial;

    @Column(name = "dolorFinal")
    private String dolorFinal;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSerie", nullable = false)
    private Serie serie;

    public Sesion() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getDolorInicial() { return dolorInicial; }
    public void setDolorInicial(String dolorInicial) { this.dolorInicial = dolorInicial; }
    public String getDolorFinal() { return dolorFinal; }
    public void setDolorFinal(String dolorFinal) { this.dolorFinal = dolorFinal; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Serie getSerie() { return serie; }
    public void setSerie(Serie serie) { this.serie = serie; }
}