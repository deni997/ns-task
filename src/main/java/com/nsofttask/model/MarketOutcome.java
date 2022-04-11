package com.nsofttask.model;

import com.google.gson.annotations.SerializedName;
import com.nsofttask.enumerations.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MarketOutcome {

    @NotNull
    @SerializedName("id:")
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Status status;

}
