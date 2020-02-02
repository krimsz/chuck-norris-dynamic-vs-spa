package com.codegrasp.demorest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChuckNorrisFactApiDto {
    List<String> categories;
    @JsonProperty("created_at")
    String createdAt;
    @JsonProperty("icon_url")
    String iconUrl;
    String id;
    @JsonProperty("updated_at")
    String updatedAt;
    String url;
    String value;
}
