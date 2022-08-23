

public class Cadastro {
    
    public  String nome;
    public  int idade;
    public  String cpf,rg,data_nasc,sexo,signo,mae,pai,email,senha,cep,endereco;
    public  int numero;
    public  String bairro,cidade,estado,telefone_fixo,celular;
    public  double altura,peso;
    public  String tipo_sanguineo,cor;

    public Cadastro(String nome,int idade,String cpf,String rg,String data_nasc,String sexo,String signo,String mae,String pai,String email,String senha,String cep,String endereco,
    int numero,String bairro,String cidade,String estado,String telefone_fixo,String celular,double altura,double peso,String tipo_sanguineo,String cor){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.signo = signo;
        this.mae = mae;
        this.pai = pai;
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro =  bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.altura =altura;
        this.peso = peso;
        this.tipo_sanguineo = tipo_sanguineo;
        this.cor = cor;
    }

    public String getNome(){
        return this.nome;
    }
    
}
