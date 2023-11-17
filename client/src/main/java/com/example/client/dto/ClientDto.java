package com.example.client.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private String motherName;

}
