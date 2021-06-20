package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String lastName;

    @NotEmpty
    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotNull
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
