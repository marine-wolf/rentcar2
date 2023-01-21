package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "carId")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer carId;

    @Column(name = "producer")
    private String producer;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "vmotor")
    private String vmotor;

    @Column(name = "pricePerDay")
    private Double pricePerDay;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private CarPhoto carPhoto;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Contract contract;

//    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
//    private Payment payment;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", vmotor='" + vmotor + '\'' +
                ", pricePerDay='" + pricePerDay + '\'' +
                '}';
    }
}
