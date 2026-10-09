public class CElipse extends CHinhVe {

    protected float CDiemTam, floatA, floatB;

    public CElipse(float CDiemTam, float floatA, float floatB) {
        this.CDiemTam = CDiemTam;
        this.floatA = floatA;
        this.floatB = floatB;
    }

    @Override
    public float DienTich() {
        return CDiemTam * floatB * floatA;
    }

    @Override
    public float ChuVi() {
        return CDiemTam + floatA + floatB;
    }

    @Override
    public void Ve() {
        System.out.println("Ve hinh eclipse voi 3 diem: " + CDiemTam + ", " + floatB + ", " + floatA );
    }

}
