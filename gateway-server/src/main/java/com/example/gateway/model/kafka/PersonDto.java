package com.example.gateway.model.kafka;

import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String id;
    private String name;
}
