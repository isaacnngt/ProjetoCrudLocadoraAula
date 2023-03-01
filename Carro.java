package crud;

public class Carro {

    int id_carro;
    private String modelo;
    private String cor;
    private String fabricante;
    private String placa;
    private Double valor_diaria;

    public Carro(int id_carro, String modelo, String cor, String fabricante, String placa, Double valor_diaria) {
        super();
        this.id_carro = id_carro;
        this.modelo = modelo;
        this.cor = cor;
        this.fabricante = fabricante;
        this.placa = placa;
        this.valor_diaria = valor_diaria;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(Double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

}
