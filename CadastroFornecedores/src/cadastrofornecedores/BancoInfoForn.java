package cadastrofornecedores;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoInfoForn {

    public class GlobalVar {
        public static ArrayList<DadosFornecedores> itensBanco = new ArrayList<>();
    }

    //Inserir Itens no Array
    public void inserirItemArray(DadosFornecedores novoItem) {
        GlobalVar.itensBanco.add(novoItem);
        String mensagem = "Item inserido com sucesso!";
        JOptionPane.showMessageDialog(null, mensagem);
    }

    //Gravar Itens no Arquivo Externo CSV
    //Gravar itens em arquivos externos
    public void gravarDados() {
        PersistenciaDadosCSV gravarItens = new PersistenciaDadosCSV();
        gravarItens.gravarDadosArquivo(GlobalVar.itensBanco);
    }

    // Buscar Informações Arquivo Externo
    public void carregarDados() {

        try {
            //itensBanco.clear();
            PersistenciaDadosCSV carregarDados = new PersistenciaDadosCSV();
            GlobalVar.itensBanco = carregarDados.carregaDados();
            System.out.println("Itens carregados no array com sucesso!");
            System.out.println("Tamanho do array carregado com sucesso:" + GlobalVar.itensBanco.size());
            System.out.println("Item: " + GlobalVar.itensBanco.get(0).getNomeFonecedor());
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados do arquivo txt!");
            e.printStackTrace();
        }

    }

    //Enviar informaçõe da ArrayList para a tabela
    public ArrayList<DadosFornecedores> enviarDadosTabela() {
        carregarDados();
        return GlobalVar.itensBanco;
    }

}
