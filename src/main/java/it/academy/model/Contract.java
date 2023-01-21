package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract")
@Entity
public class Contract implements Serializable{
    @Id
    @Column(name = "contractId")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer contractId;

    @Column(name = "receivedDate")
    private Date receivedDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name ="contractStatus")
    private String contractStatus;

    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    private Payment payment;

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", receivedDate=" + receivedDate +
                ", returnDate=" + returnDate +
                ", contractStatus='" + contractStatus +'\'' +
//                ", carId=" + car.getCarId() +'\'' +
                '}';
    }
}
