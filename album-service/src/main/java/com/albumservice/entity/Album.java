package com.albumservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(nullable = false)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pictureId")
    private List<Pictures> pictures;

    @CreationTimestamp
    private LocalDateTime createAt;

    // 멤버 정보
}
