create database quan_li_vat_tu;
use quan_li_vat_tu;
CREATE TABLE phieu_xuat (
    so_px INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ngay_xuat DATETIME NOT NULL
);

CREATE TABLE vat_tu (
    ma_vtu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_vtu VARCHAR(30) NOT NULL
);

CREATE TABLE chi_tiet_phieu_xuat (
    dg_xuat VARCHAR(30) NOT NULL,
    sl_xuat INT NOT NULL,
    ma_vtu INT NOT NULL,
    so_px INT NOT NULL,
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px)
);

CREATE TABLE nha_cc (
    ma_ncc INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_ncc VARCHAR(40) NOT NULL,
    dia_chi VARCHAR(50) NOT NULL
);
CREATE TABLE so_dien_thoai (
    phone_number VARCHAR(20) PRIMARY KEY,
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cc (ma_ncc)
);

CREATE TABLE don_dh (
    so_dh INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ngay_dh DATETIME NOT NULL,
    ma_ncc INT NOT NULL,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cc (ma_ncc)
);

CREATE TABLE chi_tiet_don_dat_hang (
    ma_vtu INT NOT NULL,
    so_dh INT NOT NULL,
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_dh)
        REFERENCES don_dh (so_dh)
);

CREATE TABLE phieu_nhap (
    so_pn INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ngay_nhap DATETIME NOT NULL
);

CREATE TABLE chi_tiet_phieu_nhap (
    dg_nhap VARCHAR(30) NOT NULL,
    sl_nhap INT NOT NULL,
    so_pn INT NOT NULL,
    ma_vtu INT NOT NULL,
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn),
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu)
);

