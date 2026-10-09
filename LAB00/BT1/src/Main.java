public class Main {
    public static void main(String[] args) {
        CTamGiac cTamGiac = new CTamGiac(1, 2 , 3);
        CTuGiac cTuGiac = new CTuGiac(1, 2, 3, 4);
        CElipse cElipse = new CElipse(1, 2, 3);
        cTamGiac.Ve();
        cTuGiac.Ve();
        cElipse.Ve();
    }
}
