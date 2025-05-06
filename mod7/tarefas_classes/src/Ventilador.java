package src;

/**
 * @author Marcello
 * 
 * Esta classe é uma representação de um ventilador
 */
public class Ventilador {

  private String marca;
  private String cor;
  private int diametro;
  private int numPas;
  private int[] velocidades = new int[3];
  private int voltagem;

  public String getMarca() {
    return marca;
  }
  public void setMarca(String marca) {
    this.marca = marca;
  }
  public String getCor() {
    return cor;
  }
  public void setCor(String cor) {
    this.cor = cor;
  }
  public int getDiametro() {
    return diametro;
  }
  public void setDiametro(int diametro) {
    this.diametro = diametro;
  }
  public int getNumPas() {
    return numPas;
  }
  public void setNumPas(int numPas) {
    this.numPas = numPas;
  }
  public int getVelocidades(int index) {
    return velocidades[index];
  }
  /**
   * 
   * @param velocidades
   * O ventilador só irá aceitar 3 velocidades
   */
  public void setVelocidades(int[] velocidades) {
    for(int i =0; i <= 2; i++){
      this.velocidades[i] = i+1;
    }
  }
  public int getVoltagem() {
    return voltagem;
  }
  /*
   * Este metodo tem uma particularidade, apenas duas voltagens são aceitas
   * 110v ou 220v.
   */
  public void setVoltagem(int voltagem) {

    if(voltagem < 220) {
      this.voltagem = 110;  
    } else {
      this.voltagem = 220;
    }
    
  }

}
