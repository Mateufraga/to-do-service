package Demo.controller.model;

import lombok.Getter;
import lombok.Setter;

public class TaskModel {
    @Getter
    @Setter
    public String id;
    @Getter
    @Setter
    public String descricao;
    @Getter
    @Setter
    public String dataDeExpiracao;
    @Getter
    @Setter
    public boolean concluida;
}

