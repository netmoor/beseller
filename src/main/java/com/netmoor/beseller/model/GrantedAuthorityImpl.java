package com.netmoor.beseller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GrantedAuthorityImpl.
 *
 * @author Nikolay_Batov
 */
@Data
@Entity
@Table(name = "granted")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "granted_id_seq")
    private Long id;

    private String authority;

    public String getAuthority() {
        return "ROLE_" + authority;
    }
}
