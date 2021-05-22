package dominio.padaria.entity;

public class Ingrediente {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUnit() {
        return tipoUnit;
    }

    public void setTipoUnit(String tipoUnit) {
        this.tipoUnit = tipoUnit;
    }

    private String nome;
    private String tipoUnit;


}