public class CTamGiac extends CHinhVe {

    protected float CDiemP1, CDiemP2, CDiemP3;

    public CTamGiac(float CDiemP3, float CDiemP2, float CDiemP1) {
        this.CDiemP3 = CDiemP3;
        this.CDiemP2 = CDiemP2;
        this.CDiemP1 = CDiemP1;
    }

    @Override
    public float DienTich() {
        float chieuDai = (CDiemP1 + CDiemP2 + CDiemP3) /3;
        return 1/2 * CDiemP1 * chieuDai;
    }

    @Override
    public float ChuVi() {
        return CDiemP1 + CDiemP2 + CDiemP3;
    }

    @Override
    public void Ve() {
        System.out.println("Ve hinh tam giac voi 3 diem: " + CDiemP1 + ", " + CDiemP2 + ", "+ CDiemP3);
    }

}
