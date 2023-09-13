package tdtu.edu.lab09_10.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountDto {
    private Long userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Builder
    public AccountDto(Long userId, String email, String password, String firstName, String lastName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
