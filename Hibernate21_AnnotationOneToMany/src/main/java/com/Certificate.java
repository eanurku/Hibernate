package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CERTIFICATE")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    int id;

    @Column(name = "certificate_name")
    String certificateName;

    @Column(name = "certificate_type")
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
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                '}';
    }
}
