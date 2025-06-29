package util;

import java.time.LocalDate;

public class Companies {
    private String companyId;
    private String companyName;
    private String companyType;
    private String companyDescription;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Companies(String companyId, String companyName, String companyType, String companyDescription, LocalDate createdAt, LocalDate updatedAt) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyDescription = companyDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Companies(String companyName, String companyType, String companyDescription, LocalDate createdAt, LocalDate updatedAt) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyDescription = companyDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Companies(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
