public class CTuGiac extends CHinhVe {

    protected float CDiemP1, CDiemP2, CDiemP3, CDiemP4;

    public CTuGiac(float CDiemP1, float CDiemP2, float CDiemP3, float CDiemP4) {
        this.CDiemP1 = CDiemP1;
        this.CDiemP2 = CDiemP2;
        this.CDiemP3 = CDiemP3;
        this.CDiemP4 = CDiemP4;
    }

    @Override
    public float DienTich() {
        return CDiemP4 + CDiemP3 + CDiemP2 + CDiemP1;
    }

    @Override
    public float ChuVi() {
        return CDiemP1 + CDiemP2 + CDiemP3 + CDiemP4;
    }

    @Override
    public void Ve() {
        System.out.println("Ve hinh tu giac voi 4 diem: " + CDiemP1 + ", " + CDiemP2 + ", " + CDiemP3 + ", " + CDiemP4);

    }

}
