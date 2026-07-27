package tech.logicforge.transaction.dto;

public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private double walletBalance;

    public StudentDTO(Long id, String name, String email, double walletBalance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.walletBalance = walletBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
