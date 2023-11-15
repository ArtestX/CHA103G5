package com.cha103g5.customerservicerecord.model.old;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customerservicerecord")
public class CSRecVO {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordno", updatable = false)
    private Integer recordNo;

    @Column(name = "memberno")
    private Integer memberNo;

    @Column(name = "adminno")
    private Integer adminNo;

    @Column(name = "recordtime")
    private Date recordTime;

    @Column(name = "interactioncontent")
    private String interactionContent;

    @Column(name = "talkdirection")
    private Integer talkDirection;
    
}