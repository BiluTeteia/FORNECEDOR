package cadastrofornecedores;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class FormatadorCampos {

    public void formataCampoTelefoneCelular(JFormattedTextField field) throws ParseException {
        MaskFormatter mask = new MaskFormatter();
        mask.setMask("(##)#####-####");
        mask.install(field);
    }

    public void formataCampoTelefoneFixo(JFormattedTextField field) throws ParseException {
        MaskFormatter mask = new MaskFormatter();
        mask.setMask("(##)####-####");
        mask.install(field);
    }

    public void formataCampoCPF(JFormattedTextField field) throws ParseException {
        MaskFormatter mask = new MaskFormatter();
        mask.setMask("###.###.###-##");
        mask.install(field);
    }

    public void formataCampoCNPJ(JFormattedTextField field) throws ParseException {
        MaskFormatter mask = new MaskFormatter();
        mask.setMask("##.###.###/####-##");
        mask.install(field);
    }

    public void formataCampoCEP(JFormattedTextField field) throws ParseException {
        MaskFormatter mask = new MaskFormatter();
        mask.setMask("##.###-###");
        mask.install(field);
    }

}
