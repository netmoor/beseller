package com.netmoor.beseller.models;

import com.netmoor.beseller.model.GrantedAuthorityImpl;
import lombok.experimental.UtilityClass;

/**
 * GrantedModels.
 *
 * @author Nikolay_Batov
 */
@UtilityClass
public class GrantedModels {

    public GrantedAuthorityImpl getGrantedAuthorityImpl() {
        return new GrantedAuthorityImpl(1L, "ADMIN");
    }
}
