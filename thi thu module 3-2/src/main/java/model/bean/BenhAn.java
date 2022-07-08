package model.bean;

public class BenhAn {
    private String maBanhAn;
    private String lyDoNhapVien;

    public BenhAn(String maBanhAn, String lyDoNhapVien) {
        this.maBanhAn = maBanhAn;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public String getMaBanhAn() {
        return maBanhAn;
    }

    public void setMaBanhAn(String maBanhAn) {
        this.maBanhAn = maBanhAn;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
