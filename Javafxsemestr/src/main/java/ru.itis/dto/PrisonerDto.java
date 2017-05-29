package ru.itis.dto;

import java.util.Date;



public class PrisonerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String sex;
    private Date closingDate;
    private String relativeInf;
    private String personality;
    private String hierarchyName;
    private Long cameraNumber;

    public PrisonerDto() {
    }

    public PrisonerDto(Long id, String firstName, String lastName, Date birthDay, String sex, Date closingDate, String relativeInf, String personality, String hierarchyName, Long cameraNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sex = sex;
        this.closingDate = closingDate;
        this.relativeInf = relativeInf;
        this.personality = personality;
        this.hierarchyName = hierarchyName;
        this.cameraNumber = cameraNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public void setRelativeInf(String relativeInf) {
        this.relativeInf = relativeInf;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void setHierarchyName(String hierarchyName) {
        this.hierarchyName = hierarchyName;
    }

    public void setCameraNumber(Long cameraNumber) {
        this.cameraNumber = cameraNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getSex() {
        return sex;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public String getRelativeInf() {
        return relativeInf;
    }

    public String getPersonality() {
        return personality;
    }

    public String getHierarchyName() {
        return hierarchyName;
    }

    public Long getCameraNumber() {
        return cameraNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
