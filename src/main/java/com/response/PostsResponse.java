package com.response;

import com.domain.PostDomain;
import com.utils.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostsResponse extends ResponseData {

    List<PostDomain> posts;

}
