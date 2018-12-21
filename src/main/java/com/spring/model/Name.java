package com.spring.model;

import org.springframework.util.Assert;

public class Name {

    private String fullName;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String fullName, String prefix, String firstName, String middleName, String lastName, String suffix) {
        this.fullName = fullName;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }


    /*

    ex. ErikDelJaku-Mr-Erik-Del-Jaku-Sr.

     */
    public static Name parseName(String name){

        Assert.notNull(name);
        String [] namesParsed = name.split("-");
        Assert.state(namesParsed.length == 6);
        Assert.noNullElements(namesParsed);


        return new Name(namesParsed[0], namesParsed[1], namesParsed[2], namesParsed[3],
                namesParsed[4], namesParsed[5]);
    }

    @Override
    public String toString() {
        return "Name{" +
                "fullName='" + fullName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
