package gatedcommunity.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;


@Schema(description = "Class that describes proposition_service_DTO")

public class PropositionServiceDTO {

//  todo  @Schema(description = "proposition_service unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id; //// null / 0

//  todo  @Schema(description = "proposition_service title", example = "Change lamp")
//    @Column(name = "title")
    private String title;

//  todo  @Schema(description = "proposition_service description", example = "change old lamp nach new")
//    @Column(name = "description")
    private String description;

//  todo  @Column(name = "image")
    private String image;

//  todo  @Schema(description = "Is proposition_service available", accessMode = Schema.AccessMode.READ_ONLY)
//    @Column
    private boolean active; // null / false


    public PropositionServiceDTO() {

    }


    @Override
    public String toString() {
        return String.format("PropositionServiceDTO: id - %d, title - %s, description - %s, active - %s",
                id, title, description, active ? "yes" : "no" );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropositionServiceDTO that = (PropositionServiceDTO) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(image);
        result = 31 * result + Boolean.hashCode(active);
        return result;
    }


    public PropositionServiceDTO(Long id, String title, String description, String image, boolean active) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
