package com.company.barmanager.dto;

import com.company.barmanager.model.Type;

public class TypeDTO {

    private Type type;
    private Long sum;

    public TypeDTO(Type type, Long sum) {
        this.type = type;
        this.sum = sum;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
