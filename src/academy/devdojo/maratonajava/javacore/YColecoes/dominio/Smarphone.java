package academy.devdojo.maratonajava.javacore.YColecoes.dominio;

public class Smarphone {
    private String serialNumber;
    private String marca;

    public Smarphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    //Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de
    // null

    //Simétrico: para x e y diferentes de null, se x.equals(y) == true logo,
    // y.quals(x) == true

    //Transitividade: para x,y,z diferentes de null, se x.equals(y) == true,
    // e x.equals(z) == true logo, y.equals(z) == true

    //Consistente: x.equals(x) sempre retorna true se x for diferente de null

    //para x diferente de null, x.equals(null) tem que retornar false.
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Smarphone smartphone = (Smarphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.getSerialNumber());
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
