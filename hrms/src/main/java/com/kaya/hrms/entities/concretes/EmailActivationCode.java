package com.kaya.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verifications")
public class EmailActivationCode {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="email_activation_code")
    private String emailActivationCode;

    @Column(name="email_expiration_date")
    private LocalDate emailExpirationDate;

    @Column(name="email_is_confirmed")
    private boolean emailIsConfirmed;

    @Column(name="email_confirmed_date")
    private LocalDate emailConfirmedDate;

    public EmailActivationCode(
    		Integer userId,
    		String activationCode,
    		boolean emailIsConfirmed,
    		LocalDate emailConfirmedDate) {
        this.id = userId;
        this.emailActivationCode = activationCode;
        this.emailIsConfirmed = emailIsConfirmed;
        this.emailConfirmedDate = emailConfirmedDate;
    }
}
