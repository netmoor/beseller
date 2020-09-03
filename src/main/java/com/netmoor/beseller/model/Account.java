package com.netmoor.beseller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Account.
 *
 * @author Nikolay_Batov
 */
@Data
@Entity
@Builder(toBuilder = true, setterPrefix = "with")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class Account implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 6, max = 50)
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "account_granted",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "granted_id")
    )
    private Set<GrantedAuthorityImpl> authorities = new HashSet<>();
    
    private boolean accountNonExpired;
    
    private boolean accountNonLocked;
    
    private boolean credentialsNonExpired;

    private boolean enabled;
}
