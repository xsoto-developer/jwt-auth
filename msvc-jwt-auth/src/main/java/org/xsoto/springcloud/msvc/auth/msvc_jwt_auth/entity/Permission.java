package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "permissions")
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private String resource;

}
