package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//database
@Entity
//springboot
@Component
@Log

public class Course implements Serializable {
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
    Long cId;
    @NonNull @NotBlank
    String cName;
    @NonNull
    int cCredits;

    @PostConstruct
    public void letMeKnow(){
        log.warning("Constructed!");
    }



}
