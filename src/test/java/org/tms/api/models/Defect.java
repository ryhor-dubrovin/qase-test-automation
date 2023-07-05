package org.tms.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defect {
    public static final int TRIVIAL_DEFECT_SEVERITY_INT = 6;
    public static final int BLOCKER_DEFECT_SEVERITY_INT = 1;
    private String title;
    @SerializedName("actual_result")
    private String actualResult;
    private int severity;

}
