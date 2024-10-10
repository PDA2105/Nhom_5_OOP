package model;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO {
	private List<PhieuMuon> DSPhieuMuon;
	public PhieuMuonDAO() {
		DSPhieuMuon = new ArrayList<>();
		
	}
	public List<PhieuMuon> getDSPhieuMuon(){
		return DSPhieuMuon;
	}
	public void themPhieuMuon(PhieuMuon phieu) {
		DSPhieuMuon.add(phieu);
		
	}
	public PhieuMuon timPhieuMuon(String maTheMuon) {
		for(PhieuMuon phieu : DSPhieuMuon) {
			if(phieu.getMaTheMuon().equals(maTheMuon)) {
				return phieu;
			}
		}
		return null;
	}
	public void suaPhieuMuon(int index ,PhieuMuon pm) {
		if (index >= 0 && index < DSPhieuMuon.size()) {
            DSPhieuMuon.set(index, pm);
        }else {
            throw new IndexOutOfBoundsException("Invalid index for updating the loan record.");
        }
		
	}
	public void xoaPhieuMuon(int index) {
        if (index >= 0 && index < DSPhieuMuon.size()) {
        	DSPhieuMuon.remove(index);
        }else {
            throw new IndexOutOfBoundsException("Invalid index for deleting the loan record.");
        }
    }
}
