package sn.set.ut.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class RendezVous implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String codeRv;
    private String description;
    private String lieu;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

}
