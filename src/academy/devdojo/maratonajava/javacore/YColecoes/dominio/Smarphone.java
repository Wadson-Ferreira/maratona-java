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
    //Se x.equals(y) == true, y.hashCode() == x.hashCode()

    //y.hashCode() == x.hashCode() não significa que equals de y.equals == true

    //x.equals(y) == false == x.hashCode() != y.hashCode()

    // y.hashCode() != x.hashCode() == x.equals(y) == false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smarphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
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
