package com.marlongrazek.builder;

public class StringBuilder {

    private String string;

    public StringBuilder() {
    }

    public StringBuilder(String start) {
        string += start;
    }


    public StringBuilder add(String string) {
        this.string += string;
        return new StringBuilder(this.string);
    }

    public StringBuilder add(String string, Integer index) {
        StringBuilder sb = new StringBuilder(this.string);
        this.string = sb.substring(0, index) + string + sb.substring(index);
        return sb;
    }

    public Boolean contains(String string) {
        return this.string.contains(string);
    }

    public StringBuilder remove(String string) {
        this.string = this.string.replace(string, "");
        return new StringBuilder(this.string);
    }

    public StringBuilder remove(Integer start) {
        StringBuilder sb = new StringBuilder(this.string);
        sb.remove(start, this.string.length());
        this.string = sb.toString();
        return sb;
    }

    public StringBuilder remove(Integer start, Integer end) {
        StringBuilder sb = new StringBuilder(this.string);
        sb.set("", start, end);
        this.string = sb.toString();
        return sb;
    }

    public StringBuilder replace(String string, String replacement) {
        this.string = this.string.replace(string, replacement);
        return new StringBuilder(this.string);
    }

    public StringBuilder replaceFirst(String string, String replacement) {
        this.string = this.string.replaceFirst(string, replacement);
        return new StringBuilder(this.string);
    }

    public StringBuilder set(String string) {
        this.string = string;
        return new StringBuilder(this.string);
    }

    public StringBuilder set(String string, Integer start, Integer end) {
        StringBuilder sb = new StringBuilder(this.string);
        sb.substring(start, end).set(string);
        this.string = sb.toString();
        return sb;
    }

    public StringBuilder substring(Integer start) {
        return new StringBuilder(this.string.substring(start));
    }

    public StringBuilder substring(Integer start, Integer end) {
        return new StringBuilder(this.string.substring(start, end));
    }

    public StringBuilder toLowerCase() {
        this.string = this.string.toLowerCase();
        return new StringBuilder(this.string);
    }

    public StringBuilder toLowerCase(Integer start) {
        this.string = this.string.substring(0, start) + this.string.substring(start).toLowerCase();
        return new StringBuilder(this.string);
    }

    public StringBuilder toLowerCase(Integer start, Integer end) {
        this.string = this.string.substring(0, start) + this.string.substring(start, end).toLowerCase() + this.string.substring(end);
        return new StringBuilder(this.string);
    }

    public String toString() {
        return this.string;
    }

    public StringBuilder toUpperCase() {
        this.string = this.string.toUpperCase();
        return new StringBuilder(this.string);
    }

    public StringBuilder toUpperCase(Integer start) {
        this.string = this.string.substring(0, start) + this.string.substring(start).toUpperCase();
        return new StringBuilder(this.string);
    }

    public StringBuilder toUpperCase(Integer start, Integer end) {
        this.string = this.string.substring(0, start) + this.string.substring(start, end).toUpperCase() + this.string.substring(end);
        return new StringBuilder(this.string);
    }
}
