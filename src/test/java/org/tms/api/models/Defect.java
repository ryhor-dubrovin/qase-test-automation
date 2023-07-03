package org.tms.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defect {
    private String title;
    @SerializedName("actual_result")
    private String actualResult;
    private int severity; // 6 - 1 >> + 0
}
