package io.github.springboot.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public")
@Data
@ToString(exclude = "livros")
@EntityListeners(AuditingEntityListener.class)
public class Autor {

    // @Column not necessary, btw it's just for learning

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Need @Getter and @Setter, without don't's works (Sem esses @Getter e @Setter não funciona, não sei o por que e apenas no nome)
    @Getter
    @Setter
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;


    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    // For the framework use
    @Deprecated
    public Autor(){
    }

    @OneToMany(mappedBy = "autor",
            /*cascade = CascadeType.ALL,*/
            fetch = FetchType.LAZY)
    private List<Livro> livros;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;


    @Column(name = "id_usuario")
    private UUID idUsuario;
}
