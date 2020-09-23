package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class HomeNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homeNewsSeq;

    @Column(length = 20, nullable = false)
    private String homeNewsNo;

    @Column(length = 2000, nullable = false)
    private String image;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String address;

    @Column(length = 200, nullable = false)
    private String date;

    @Builder
    public HomeNews(String homeNewsNo, String address, String title, String image,  String date) {
        this.homeNewsNo = homeNewsNo;
        this.title = title;
        this.address = address;
        this.image = image;
        this.date = date;
    }
}