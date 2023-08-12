package com.document.domaincrawler.schema;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {
    private String id;
    private String name;
}
