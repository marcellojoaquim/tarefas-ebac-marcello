public class Notas {

  private int num1;
  private int num2;
  private int num3;
  private int num4;

  public Notas(int a, int b, int c, int d) {
    this.num1 = a;
    this.num2 = b;
    this.num3 = c;
    this.num4 = d;
  }

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getNum3() {
    return num3;
  }

  public void setNum3(int num3) {
    this.num3 = num3;
  }

  public int getNum4() {
    return num4;
  }

  public void setNum4(int num4) {
    this.num4 = num4;
  }

  public int calculaMedia() {
    int media = (this.num1 + this.num2 + this.num3 + this.num4)/4;
    if(media > 10) {
      return 10;
    } else if(media < 0) {
      return 0;
    } else {
      return media;
    }
  }

  @Override
  public String toString() {
    return "Notas [num1=" + num1 + ", num2=" + num2 + ", num3=" + num3 + ", num4=" + num4 + "]";
  }
  
}
