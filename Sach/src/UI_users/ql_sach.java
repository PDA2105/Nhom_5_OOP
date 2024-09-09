/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_users;

/**
 *
 * @author duyan
 */
public class ql_sach {
    int STT;
    String Tieu_De, Tac_Gia, ISBN, The_Loai;
    int Nam_Sang_Tac;

    public ql_sach(){
        
    }
    
    public ql_sach(int STT, String Tieu_De, String Tac_Gia, String ISBN, String The_Loai, int Nam_Sang_Tac) {
        this.STT = STT;
        this.Tieu_De = Tieu_De;
        this.Tac_Gia = Tac_Gia;
        this.ISBN = ISBN;
        this.The_Loai = The_Loai;
        this.Nam_Sang_Tac = Nam_Sang_Tac;
    }

    public ql_sach(String Tieu_De, String Tac_Gia, String ISBN, String The_Loai, int Nam_Sang_Tac) {
        this.Tieu_De = Tieu_De;
        this.Tac_Gia = Tac_Gia;
        this.ISBN = ISBN;
        this.The_Loai = The_Loai;
        this.Nam_Sang_Tac = Nam_Sang_Tac;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTieu_De() {
        return Tieu_De;
    }

    public void setTieu_De(String Tieu_De) {
        this.Tieu_De = Tieu_De;
    }

    public String getTac_Gia() {
        return Tac_Gia;
    }

    public void setTac_Gia(String Tac_Gia) {
        this.Tac_Gia = Tac_Gia;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getThe_Loai() {
        return The_Loai;
    }

    public void setThe_Loai(String The_Loai) {
        this.The_Loai = The_Loai;
    }

    public int getNam_Sang_Tac() {
        return Nam_Sang_Tac;
    }

    public void setNam_Sang_Tac(int Nam_Sang_Tac) {
        this.Nam_Sang_Tac = Nam_Sang_Tac;
    }
    
    
}