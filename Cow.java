public class Cow {
    String cowIdentityCode;
    double numLitresProduced;

    public Cow(String cowIdentityCode) {
        this.cowIdentityCode = cowIdentityCode;
        this.numLitresProduced = 0;
    }

    public void setNumLitres(double numLitres) {
        this.numLitresProduced = numLitres;
    }
}
