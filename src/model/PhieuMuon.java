package model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

public class PhieuMuon implements Serializable{
	private String maTheMuon;
	private String isbn;
	private LocalDate ngayMuon;
	private LocalDate ngayTraDuKien;
	private LocalDate ngayTraThucTe;
	private boolean tinhTrang;
	
	public PhieuMuon(String maTheMuon, String isbn,boolean tinhTrang, LocalDate ngayMuon, LocalDate ngayTraDuKien, LocalDate ngayTraThucTe
			) {
		this.maTheMuon = maTheMuon;
		this.isbn = isbn;
		this.ngayMuon = ngayMuon;
		this.ngayTraDuKien = ngayTraDuKien;
		this.ngayTraThucTe = ngayTraThucTe;
		this.tinhTrang = tinhTrang;
	}


	public String getMaTheMuon() {
		return maTheMuon;
	}

	public void setMaTheMuon(String maTheMuon) {
		this.maTheMuon = maTheMuon;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(LocalDate ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public LocalDate getNgayTraDuKien() {
		return ngayTraDuKien;
	}

	public void setNgayTraDuKien(LocalDate ngayTraDuKien) {
		this.ngayTraDuKien = ngayTraDuKien;
	}

	public LocalDate getNgayTraThucTe() {
		return ngayTraThucTe;
	}

	public void setNgayTraThucTe(LocalDate ngayTraThucTe) {
		this.ngayTraThucTe = ngayTraThucTe;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "PhieuMuon [maTheMuon=" + maTheMuon + ", isbn=" + isbn + ", ngayMuon=" + ngayMuon + ", ngayTraDuKien="
				+ ngayTraDuKien + ", ngayTraThucTe=" + ngayTraThucTe + ", tinhTrang=" + tinhTrang + "]";
	}

	public long calculateFine() {
		if(ngayTraThucTe != null&& ngayTraThucTe.isAfter(ngayTraDuKien)) {
            return ChronoUnit.DAYS.between(ngayTraDuKien, ngayTraThucTe);

		}
		return 0;
	}
	
	
	
}
