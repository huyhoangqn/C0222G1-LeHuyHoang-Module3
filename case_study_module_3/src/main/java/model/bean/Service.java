package model.bean;

public class Service {
    private String maDichVu;
    private String tenDichVu;
    private double dienTich;
    private double chiPhiThue;
    private int soNguoiToiDa;
    private TypeRent maKieuThue;
    private TypeService maLoaiDichVu;
    private String tieuChuanPhong;
    private String tienNghiKhac;
    private String dienTichHoBoi;
    private String soTang;

    public Service() {
    }

    public Service(String maDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa,
                   TypeRent maKieuThue, TypeService maLoaiDichVu, String tieuChuanPhong, String tienNghiKhac,
                   String dienTichHoBoi, String soTang) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service(String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa,
                   TypeRent maKieuThue, TypeService maLoaiDichVu, String tieuChuanPhong, String tienNghiKhac,
                   String dienTichHoBoi, String soTang) {
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }
    public Service(String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa,
                   String tieuChuanPhong, String tienNghiKhac,
                   String dienTichHoBoi, String soTang) {
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tieuChuanPhong = tieuChuanPhong;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public TypeRent getMaKieuThue() {
        return maKieuThue;
    }

    public void setMaKieuThue(TypeRent maKieuThue) {
        this.maKieuThue = maKieuThue;
    }

    public TypeService getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(TypeService maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getTienNghiKhac() {
        return tienNghiKhac;
    }

    public void setTienNghiKhac(String tienNghiKhac) {
        this.tienNghiKhac = tienNghiKhac;
    }

    public String getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(String dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }
}
