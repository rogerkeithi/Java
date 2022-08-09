import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class dale {
    public static int N[] = new int[]{100, 1000, 10000, 50000, 100000};
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 5; i++) {
            File pasta = new File(String.valueOf(N[i]));

            if (!pasta.exists()) {
                pasta.mkdir();
            }
            int max = N[i];
            int min = 0;
            //pasta.getAbsolutePath() retorna o caminho absoluto da pasta, 
            //adicione o string com o nome do arquivo a ser criado
            System.out.println(pasta.getAbsolutePath());
            for(int j = 1; j <= 10; j++){
                String arqCriacao = pasta.getAbsolutePath()+ "/arq" + j + ".txt";
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqCriacao, false));

                for(int k = 0; k < N[i]; k++){
                    Random aleatorio = new Random();
                    int valor = aleatorio.nextInt(max - min) + min;
                    buffWrite.append(valor + "\n");
                }
                buffWrite.close();

                max = max + max;
                min = min + N[i];
            }
        }
    }
}
