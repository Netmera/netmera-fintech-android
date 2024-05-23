package com.netmera.netmerafintech.data.model

import com.google.gson.annotations.SerializedName
import com.netmera.NetmeraUser
import com.netmera.internal.Optional

/**
 * @author Netmera
 */
class NMImpactFintechUser : NetmeraUser() {
    @SerializedName("ca")
    private var companyName: Optional<String>? = null
    @SerializedName("or")
    private var companyEmailAddress: Optional<String>? = null
    @SerializedName("xi")
    private var jobTitle: Optional<String>? = null

    fun setCompanyName(companyName: String?) {
        this.companyName = Optional.fromNullable(companyName)
    }

    fun setCompanyEmailAddress(companyEmailAddress: String?) {
        this.companyEmailAddress = Optional.fromNullable(companyEmailAddress)
    }

    fun setJobTitle(jobTitle: String?) {
        this.jobTitle = Optional.fromNullable(jobTitle)
    }
}