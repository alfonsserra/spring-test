package com.systelab.spring.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@RequiredArgsConstructor(staticName = "of")
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private String eMail;


}
