package com.xplorelatam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="users")
public class User {
  @Id
  @EqualsAndHashCode.Include
  private Integer idUser;

  @Column(nullable = false, length = 70,
    unique = true)
  private String username;

  @Column(nullable = false, length = 100)
  private String password;

  @Column(nullable = false)
  private boolean enabled;

  @ManyToMany(fetch= FetchType.EAGER) //Relacion muchos a muchos
  @JoinTable(name= "user_role",
    joinColumns= @JoinColumn(name="id_user", referencedColumnName = "idUser"),
    inverseJoinColumns =  @JoinColumn(name="id_role", referencedColumnName = "idRole"))
  private List<Role> roles;
}
