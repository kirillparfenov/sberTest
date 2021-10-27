package com.example.sbertest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Value {
    private boolean threadA;
    private boolean threadB;
    private List<String> queue;
}
