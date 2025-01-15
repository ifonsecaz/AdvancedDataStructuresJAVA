/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda;

import java.util.ArrayList;

/**
 *
 * @author ifons
 */
public class Censo implements Comparable<Censo>{
    private String business_id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String postal_code;
    private double latitude;
    private double longitude;
    private double stars;
    private int review_count;
    private int is_open;
    private ArrayList<String> atributes;
    private String categories;
    private ArrayList<String> hours;

    public Censo(String business_id, String name, String address, String city, String state, String postal_code, double latitude, double longitude, double stars, int review_count, int is_open, String categories) {
        this.business_id = business_id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stars = stars;
        this.review_count = review_count;
        this.is_open = is_open;
        this.atributes = new ArrayList();
        this.categories = categories;
        this.hours = new ArrayList();
    }

    public void agregaAtributo(String at){
        atributes.add(at);
    }
    
    public void agregaHoras(String h){
        hours.add(h);
    }
    
    public String getBusiness_id() {
        return business_id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getStars() {
        return stars;
    }

    public int getReview_count() {
        return review_count;
    }

    public int getIs_open() {
        return is_open;
    }

    public String getAtributes(int i) {
        return atributes.get(i);
    }

    public String getCategories() {
        return categories;
    }

    public String getHours(int i) {
        return hours.get(i);
    }
    
    public int compareTo(Censo otro){
        return this.business_id.compareTo(otro.business_id);
    }

    @Override
    public String toString() {
        return "Censo{" + "business_id=" + business_id + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code + ", latitude=" + latitude + ", longitude=" + longitude + ", stars=" + stars + ", review_count=" + review_count + ", is_open=" + is_open + ", categories=" + categories + '}';
    }
    
    
}
