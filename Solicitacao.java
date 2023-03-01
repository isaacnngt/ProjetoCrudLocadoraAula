package crud;

public class Solicitacao {

    private int id_solicitacao;
    private int id_cliente;
    private int id_carro;
    private String dt_solicitacao;
    private String dt_retirada;
    private String dt_prevista;
    private String dt_devolucao;
    private int qtd_dias_aluguel;
    private double valor_diaria;
    private double total_diaria;
    private String ativo;

    //Variaveis das demais tabelas
    private String nome;
    private String cpf;
    private String modelo;

    public Solicitacao(int id_solicitacao, int id_cliente, int id_carro, String dt_solicitacao, String dt_retirada,
                       String dt_prevista, String dt_devolucao, int qtd_dias_aluguel, double valor_diaria, double total_diaria,
                       String ativo, String nome, String cpf, String modelo) {
        super();
        this.id_solicitacao = id_solicitacao;
        this.id_cliente = id_cliente;
        this.id_carro = id_carro;
        this.dt_solicitacao = dt_solicitacao;
        this.dt_retirada = dt_retirada;
        this.dt_prevista = dt_prevista;
        this.dt_devolucao = dt_devolucao;
        this.qtd_dias_aluguel = qtd_dias_aluguel;
        this.valor_diaria = valor_diaria;
        this.total_diaria = total_diaria;
        this.ativo = ativo;
        this.nome = nome;
        this.cpf = cpf;
        this.modelo = modelo;
    }
    public int getId_solicitacao() {
        return id_solicitacao;
    }
    public void setId_solicitacao(int id_solicitacao) {
        this.id_solicitacao = id_solicitacao;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_carro() {
        return id_carro;
    }
    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }
    public String getDt_solicitacao() {
        return dt_solicitacao;
    }
    public void setDt_solicitacao(String dt_solicitacao) {
        this.dt_solicitacao = dt_solicitacao;
    }
    public String getDt_retirada() {
        return dt_retirada;
    }
    public void setDt_retirada(String dt_retirada) {
        this.dt_retirada = dt_retirada;
    }
    public String getDt_prevista() {
        return dt_prevista;
    }
    public void setDt_prevista(String dt_prevista) {
        this.dt_prevista = dt_prevista;
    }
    public String getDt_devolucao() {
        return dt_devolucao;
    }
    public void setDt_devolucao(String dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }
    public int getQtd_dias_aluguel() {
        return qtd_dias_aluguel;
    }
    public void setQtd_dias_aluguel(int qtd_dias_aluguel) {
        this.qtd_dias_aluguel = qtd_dias_aluguel;
    }
    public double getValor_diaria() {
        return valor_diaria;
    }
    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }
    public double getTotal_diaria() {
        return total_diaria;
    }
    public void setTotal_diaria(double total_diaria) {
        this.total_diaria = total_diaria;
    }
    public String getAtivo() {
        return ativo;
    }
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
