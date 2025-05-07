package io.github.springboot.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data // - Lombok annotation with get @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@ToString(exclude = "autor")
@EntityListeners(AuditingEntityListener.class)
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    @Getter
    @Setter
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    @Getter
    @Setter
    private String titulo;

    @Column(name = "data_publicacao")
    @Getter
    @Setter
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    @Getter
    @Setter
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    @Getter
    @Setter
    private BigDecimal preco;

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//       this.id = id;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    public LocalDate getDataPublicacao() {
//        return dataPublicacao;
//    }
//
//    public void setDataPublicacao(LocalDate dataPublicacao) {
//        this.dataPublicacao = dataPublicacao;
//    }
//
//    public GeneroLivro getGenero() {
//        return genero;
//    }
//
//    public void setGenero(GeneroLivro genero) {
//        this.genero = genero;
//    }
//
//    public BigDecimal getPreco() {
//        return preco;
//    }
//
//    public void setPreco(BigDecimal preco) {
//        this.preco = preco;
//    }
//
//    public Autor getAutor() {
//        return autor;
//    }
//
//    public void setAutor(Autor autor) {
//        this.autor = autor;
//    }

    @ManyToOne(
            // cascade = CascadeType.ALL)
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
