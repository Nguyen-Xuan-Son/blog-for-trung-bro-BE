package com.response;

import com.domain.CategoryDetail;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriesResponse extends ResponseData {

    List<CategoryDetail> categoryEntities;

}
