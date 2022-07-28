package com.lucas.crudspring.model.entities;

import com.lucas.crudspring.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "roles")
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;



    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }



}
