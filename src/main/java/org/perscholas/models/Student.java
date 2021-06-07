package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//lombok
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//database
@Entity
//springboot
@Component
@Slf4j
public class Student implements Serializable {
    static final long serialVersionUID = 6381462249347345007L;

    /*
            note use annotation  '@ToString.Exclude' for Lists
            ----------------
            - add validation for fields
            - relationships
            - utilities methods if any
     */

    //fields

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sId;
    @NonNull @Column(unique = true) @NotBlank
    String sUsername;
    @NonNull @NotBlank
    String sEmail;
    @NonNull @NotBlank
    String sPassword;

    @PostConstruct
    void constructed(){
        log.trace("Constructed");
    }



}
