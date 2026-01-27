package com.amaral.IFeed.dtos;

import java.sql.Date;

public record PostDTO(UserDTO userDTO, String text, Date created_at, ComentsDTO comentsDTO, LikeDTO likeDTO) {

}
