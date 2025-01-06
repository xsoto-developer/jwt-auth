package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.request;


import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String email;
    String password;
    Boolean status = true;
    Date createAt;
    Date updateAt;
}
