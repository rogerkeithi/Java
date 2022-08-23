import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

    public int N;

    
    public String[] lerArquivo(String nomeArq) throws IOException  {
        File arq = new File(nomeArq);
        String arqDir = arq.getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(arqDir));

        while(buffRead.readLine() != null){
            this.N += 1;
        }
        buffRead.close();

        BufferedReader br = new BufferedReader(new FileReader(arqDir));

        String[] res = new String[N];

        for(int i = 0; i < N; i++){
            res[i] = br.readLine();
        }
        br.close();
        return res;
    }


}
