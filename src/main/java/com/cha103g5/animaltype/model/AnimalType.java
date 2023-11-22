package com.cha103g5.animaltype.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animaltype")
public class AnimalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animaltypeno")
    private Integer animalTypeNo;

    @Column(name = "animaltypename", nullable = false, length = 20)
    @NotEmpty(message="動物種類: 請勿空白")
    @Size(min=1,max=20,message="動物種類: 長度必需在{min}到{max}之間")
    private String animalTypeName;

}
