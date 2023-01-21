package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer paymentId;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "contractId")
    private Contract contract;


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", createDate=" + createDate +
                ", paymentStatus='" + paymentStatus + '\''+
//                ", contractId=" + contract.getContractId() + '\'' +
                '}';
    }
}
