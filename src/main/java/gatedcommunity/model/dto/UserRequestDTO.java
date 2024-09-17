package gatedcommunity.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.Objects;

@Schema(description = "DTO for User_Request")
public class UserRequestDTO
//        (
//        Long id,
//        String photo,
//        long propositionServiceId,
//        String description,
//        Date desiredDateTime,
//        long userId,
//        long addressId
//)
{

//
    private Long id; //// null / 0

    private String photo;

    private long propositionServiceId;

    private String description;

    private Date desiredDateTime;

    private long userId;

    private long addressId;

     @JsonIgnore
    private boolean active; // null / false


    @Override
    public String toString() {
        return String.format("User_request: id - %d, description - %s, proposition_service_id - %s, desired_datetime - %s, user_id - %s, address_id - %s,  active - %s",
                id, description, propositionServiceId, desiredDateTime, userId, addressId,   active ? "yes" : "no");
    }

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long id, String photo, long propositionServiceId, String description, Date desiredDateTime, long userId, long addressId, boolean active) {
        this.id = id;
        this.photo = photo;
        this.propositionServiceId = propositionServiceId;
        this.description = description;
        this.desiredDateTime = desiredDateTime;
        this.userId = userId;
        this.addressId = addressId;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getPropositionServiceId() {
        return propositionServiceId;
    }

    public void setPropositionServiceId(long propositionServiceId) {
        this.propositionServiceId = propositionServiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDesiredDateTime() {
        return desiredDateTime;
    }

    public void setDesiredDateTime(Date desiredDateTime) {
        this.desiredDateTime = desiredDateTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequestDTO that = (UserRequestDTO) o;
        return propositionServiceId == that.propositionServiceId && userId == that.userId && addressId == that.addressId && active == that.active && Objects.equals(id, that.id) && Objects.equals(photo, that.photo) && Objects.equals(description, that.description) && Objects.equals(desiredDateTime, that.desiredDateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(photo);
        result = 31 * result + Long.hashCode(propositionServiceId);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(desiredDateTime);
        result = 31 * result + Long.hashCode(userId);
        result = 31 * result + Long.hashCode(addressId);
        result = 31 * result + Boolean.hashCode(active);
        return result;
    }
}
