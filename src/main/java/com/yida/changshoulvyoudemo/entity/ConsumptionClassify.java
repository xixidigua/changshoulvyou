package com.yida.changshoulvyoudemo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * javabeanš▒╗
 */
@Table(name = "r_classify")
public class ConsumptionClassify {
    @Id
    private Integer id;
    private String name;

    public ConsumptionClassify() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
