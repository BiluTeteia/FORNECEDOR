package cadastrofornecedores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersistenciaDadosCSV {

    String caminho = "C:\\Users\\03156794090\\Desktop\\CadastroFornecedores\\dadosFornecedores.txt";

    public void criarArquivoDados() {

        File arquivo = new File(caminho);

        try {
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso!");
            } else {
                System.out.println("Arquivo ja existe!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar arquivo!");
            e.printStackTrace();
        }
    }

    public void gravarDadosArquivo(ArrayList<DadosFornecedores> listaItens) {

        try {
            FileWriter escritor = new FileWriter(caminho);

            for (int i = 0; i < listaItens.size(); i++) {
                escritor.write(listaItens.get(i).getNomeFonecedor() + ","
                        + listaItens.get(i).getTipoFonecedor() + ","
                        + listaItens.get(i).getPrincipalProduto() + ","
                        + listaItens.get(i).getCelular() + ","
                        + listaItens.get(i).getTelFixo() + ","
                        + listaItens.get(i).getEmail() + ","
                        + listaItens.get(i).getTelComercial() + ","
                        + listaItens.get(i).getTelRecado() + ","
                        + listaItens.get(i).getNomeContato() + ","
                        + listaItens.get(i).getCep() + ","
                        + listaItens.get(i).getRua() + ","
                        + listaItens.get(i).getNumero() + ","
                        + listaItens.get(i).getBairro() + ","
                        + listaItens.get(i).getCidade() + ","
                        + listaItens.get(i).getEstado() + ","
                        + listaItens.get(i).getDadosAdicionais()
                        + "\n");
            }
            escritor.close();
            System.out.println("Arquivo gravado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao gravar arquivo!");
            e.printStackTrace();
        }
    }

    ArrayList<DadosFornecedores> cargaDados = new ArrayList<>();

    public ArrayList<DadosFornecedores> carregaDados() throws FileNotFoundException {

        File arquivo = new File(caminho);
        Scanner leitorArquivo = new Scanner(arquivo);
        int i = 0;

        try {
            while (leitorArquivo.hasNext()) {
                String linhaArquivo = leitorArquivo.nextLine();
                String vect[] = linhaArquivo.split(",");
                String NomeFonecedor = vect[0];
                String TipoFonecedor = vect[1];
                String PrincipalProduto = vect[2];
                String Celular = vect[3];
                String TelFixo = vect[4];
                String Email = vect[5];
                String TelComercial = vect[6];
                String NomeContato = vect[7];
                String Cep = vect[8];
                String Rua = vect[9];
                String Numero = vect[10];
                String Bairro = vect[11];
                String Cidade = vect[12];
                String Estado = vect[13];
                String DadosAdicionais = vect[14];

                DadosFornecedores novoItem = new DadosFornecedores(NomeFonecedor, TipoFonecedor, PrincipalProduto, Celular, TelFixo, Email, TelComercial, Estado, NomeContato, Cep, Rua, Numero, Bairro, Cidade, Estado, DadosAdicionais);
                cargaDados.add(novoItem);
                System.out.println("Total dados: " + i);
                i++;
            }
            leitorArquivo.close();
            System.out.println("Dados lidos com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao ler dados do arquivo!");
            e.printStackTrace();
        }
        return cargaDados;
    }

}
