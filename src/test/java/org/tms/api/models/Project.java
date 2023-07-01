package org.tms.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    public String title;
    public String code;
    public String description;
    public String access;
    public String group;
}
