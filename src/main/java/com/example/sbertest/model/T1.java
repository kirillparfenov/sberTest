package com.example.sbertest.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Getter
@Setter
public class T1 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t1_seq")
    private long id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Value value;

    public T1() {
    }
}