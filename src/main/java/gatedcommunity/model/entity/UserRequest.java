package gatedcommunity.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "requests")
@Schema(description = "Class that describes proposition_service")
public class UserRequest {

    @Schema(description = "user_request unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //// null / 0

    @Column(name = "photo")
    private String photo;

    @Schema(description = "user_request  proposition_service_id", example = "023")
    @Column(name = "proposition_service_id")
    private long proposition_service_id;

    @Schema(description = "user_request description", example = "change old lamp nach new")
    @Column(name = "description")
    private String description;

    @Schema(description = "user_request timestamp", example = "12/12/2028")
    @Column(name = "desired_datetime")
    private Date desired_datetime;

    @Schema(description = "user_request  user_id", example = "013")
    @Column(name = "user_id")
    private long user_id;

    @Schema(description = "user_request  address_id", example = "013")
    @Column(name = "address_id")
    private long address_id;

    @Schema(description = "Is user_request available", accessMode = Schema.AccessMode.READ_ONLY)
    @Column
    private boolean active; // null / false

    public UserRequest() {

    }

    @Override
    public String toString() {
        return String.format("User_request: id - %d, description - %s, proposition_service_id - %s, desired_datetime - %s, user_id - %s, address_id - %s,  active - %s",
                id, description, proposition_service_id, desired_datetime, user_id, address_id,   active ? "yes" : "no");
    }

    public UserRequest(Long id, String photo, long proposition_service_id, String description, Date desired_datetime, long user_id, long address_id, boolean active) {
        this.id = id;
        this.photo = photo;
        this.proposition_service_id = proposition_service_id;
        this.description = description;
        this.desired_datetime = desired_datetime;
        this.user_id = user_id;
        this.address_id = address_id;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequest that = (UserRequest) o;
        return proposition_service_id == that.proposition_service_id && user_id == that.user_id && address_id == that.address_id && active == that.active && Objects.equals(id, that.id) && Objects.equals(photo, that.photo) && Objects.equals(description, that.description) && Objects.equals(desired_datetime, that.desired_datetime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(photo);
        result = 31 * result + Long.hashCode(proposition_service_id);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(desired_datetime);
        result = 31 * result + Long.hashCode(user_id);
        result = 31 * result + Long.hashCode(address_id);
        result = 31 * result + Boolean.hashCode(active);
        return result;
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

    public long getProposition_service_id() {
        return proposition_service_id;
    }

    public void setProposition_service_id(long proposition_service_id) {
        this.proposition_service_id = proposition_service_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDesired_datetime() {
        return desired_datetime;
    }

    public void setDesired_datetime(Date desired_datetime) {
        this.desired_datetime = desired_datetime;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
