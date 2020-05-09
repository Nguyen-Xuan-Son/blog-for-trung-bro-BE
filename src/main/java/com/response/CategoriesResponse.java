package com.response;

import com.domain.CategoryDomain;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriesResponse extends ResponseData {

    List<CategoryDomain> categoryEntities;

}
