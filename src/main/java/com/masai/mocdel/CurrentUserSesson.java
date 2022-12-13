package com.masai.mocdel;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSesson {
    @Id
	private String email;
	private String uuid;
	private String password;

}
