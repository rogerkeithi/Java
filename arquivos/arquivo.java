import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
//Esse programa lê o arquivo numeros.txt e imprime na tela
//Logo depois escreve a mesma sequencia de numeros no mesmo arquivo porem na ordem inversa
public class arquivo {
    public static void main(String[] args) throws IOException {
        String arqLeitura = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Apenas arquivos de Texto","doc","txt");
        chooser.addChoosableFileFilter(filter);
        int returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqLeitura = chooser.getSelectedFile().getAbsolutePath();
        }

        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));
        System.out.println("Lendo o arquivo " + arqLeitura);     

        int N = Integer.parseInt(buffRead.readLine());

        int vet[] = new int[N];

        for (int i = 0; i < N; i++) {
            vet[i] = Integer.parseInt(buffRead.readLine());
        }
        buffRead.close();

        System.out.println("Valores lidos no arquivo");
        for (int i = 0; i < N; i++) {
            System.out.println(vet[i]);
        }

        System.out.println(" ");

        String arqEscrita = "";
        returnVal = chooser.showSaveDialog(chooser);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqEscrita = chooser.getSelectedFile().getAbsolutePath();
            //arqEscrita = chooser.getSelectedFile().getName();
        }
        System.out.println("Escrevendo no arquivo " + arqEscrita);
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqEscrita, true));

        for(int i = N; i > 0; i--){
            buffWrite.append(vet[i-1] +"\n");
        }
    
        buffWrite.close();
    }
}
