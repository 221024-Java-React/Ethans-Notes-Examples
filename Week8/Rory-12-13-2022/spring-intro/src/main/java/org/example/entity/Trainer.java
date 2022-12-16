package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entity.Pokemon;

// this creates a no argument constructor:
@NoArgsConstructor
// this creates a fully parameterized constructor:
@AllArgsConstructor
// this creates getters and setters:
@Data
// creates toString method
@ToString
public class Trainer {
    private String name;
    private Pokemon starter;
    private int num_badges;
}
