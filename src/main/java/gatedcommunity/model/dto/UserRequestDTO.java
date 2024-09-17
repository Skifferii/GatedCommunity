package gatedcommunity.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "DTO for User_Request")
public record UserRequestDTO(
        Long id,
        String photo,
        long propositionServiceId,
        String description,
        Date desiredDateTime,
        long userId,
        long addressId
) {

//
//    private Long id; //// null / 0
//
//    private String photo;
//
//    private long propositionServiceId;
//
//    private String description;
//
//    private Date desiredDateTime;
//
//    private long userId;
//
//    private long addressId;
//
//     @JsonIgnore
//    private boolean active; // null / false
//
//
//    @Override
//    public String toString() {
//        return String.format("User_request: id - %d, description - %s, proposition_service_id - %s, desired_datetime - %s, user_id - %s, address_id - %s,  active - %s",
//                id, description, propositionServiceId, desiredDateTime, userId, addressId,   active ? "yes" : "no");
//    }
//
//


}
