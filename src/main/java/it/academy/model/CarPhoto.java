package it.academy.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "car_photo")
@Getter
@Setter
public class CarPhoto {
    @Id
    @Column(name = "photoId")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer photoId;

    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    @Lob
    @Column(name = "photo", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;
}
