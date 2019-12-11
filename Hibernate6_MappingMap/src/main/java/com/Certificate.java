package com;

import java.util.Objects;

public class Certificate {

    int id;
    String certificateName;
    String certificateType;

    public Certificate() {
    }

    public Certificate(String certificateName, String certificateType) {
        this.certificateName = certificateName;
        this.certificateType = certificateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return certificateName.equals(that.certificateName) &&
                certificateType.equals(that.certificateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificateName, certificateType);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                '}';
    }
}
