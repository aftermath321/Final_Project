package it.projecteat.finalproject.Entity;

import lombok.*;
import javax.persistence.*;

@Entity(name = "User_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String description;

    @OneToOne
    private User user;

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';

    }
}
