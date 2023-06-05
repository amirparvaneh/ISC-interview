package com.isc.iscnews.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class NewsRequestDto implements Serializable {
    private String country;
    private String category;
}
