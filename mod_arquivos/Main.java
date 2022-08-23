import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();

        LerArquivo ler = new LerArquivo();

        String[] vetDados= ler.lerArquivo("dados.csv");

        for(int i = 1; i < ler.N; i++){
            
            String dados = vetDados[i];

            String[] dadosSep = dados.split(",");

            Cadastro cad = new Cadastro(dadosSep[0],Integer.parseInt(dadosSep[1]),dadosSep[2],dadosSep[3],dadosSep[4],dadosSep[5],dadosSep[6],dadosSep[7],dadosSep[8],dadosSep[9],dadosSep[10],dadosSep[11]
                                        ,dadosSep[12],Integer.parseInt(dadosSep[13]),dadosSep[14],dadosSep[15],dadosSep[16],dadosSep[17],dadosSep[18],Double.valueOf(dadosSep[19]),Double.valueOf(dadosSep[20]),dadosSep[21],dadosSep[22]);
        
            cadastros.add(cad);
        }
        
        for(int i = 0; i < cadastros.size(); i++){
            System.out.println(cadastros.get(i).getNome());
        }
        
    }
}
