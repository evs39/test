package ru.orm.test.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "author_eager",
        attributeNodes = {
                @NamedAttributeNode(value = "author")
        }
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "writer_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Author author;

    private Instant date;
}
