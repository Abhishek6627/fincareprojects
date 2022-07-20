package com.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequset
{
    @NotNull(message = "user name should not be null")
    private  String name;
    @Email(message = "Invalid email")
    private  String email;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile no")
    private  String  mobile;
    private  String   gender;
    @Min(18)
    @Max(60)
    private  int age;
    @NotBlank
    private  String nationality;
}
