package model.bean;

import java.util.Date;

public class BenhNhan {
    private String maBenhNhan;
    private String tenBenhNham;
    private Date ngayNhap;
    private Date ngayXuat;
    private BenhAn benhAn;

    public BenhNhan(String maBenhNhan, String tenBenhNham, Date ngayNhap, Date ngayXuat, BenhAn benhAn) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNham = tenBenhNham;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
        this.benhAn = benhAn;
    }

    public BenhNhan(String maBenhNhan, String tenBenhNham, Date ngayNhap, Date ngayXuat) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNham = tenBenhNham;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNham() {
        return tenBenhNham;
    }

    public void setTenBenhNham(String tenBenhNham) {
        this.tenBenhNham = tenBenhNham;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public BenhAn getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(BenhAn benhAn) {
        this.benhAn = benhAn;
    }
}
