package elte.meetonefriender.example;

import javax.persistence.*;

@Entity
@Table
public class Example {
    @Id
    @SequenceGenerator(
            name = "example_sequence",
            sequenceName = "example_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "example_sequence"
    )
    private Long id;
    private String name;

    public Example(){}

    public Example(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
