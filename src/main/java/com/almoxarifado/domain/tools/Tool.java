package com.almoxarifado.domain.tools;

import com.almoxarifado.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_tools")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idTool")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTool;
    private String nameTool;
    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private Employee responsible;
    private boolean available;

    public Tool(String nameTool) {
        this.nameTool = nameTool;
        this.responsible = null;
        this.available = true;
    }
}
